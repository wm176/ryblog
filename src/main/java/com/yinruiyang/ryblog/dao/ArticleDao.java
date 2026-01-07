package com.yinruiyang.ryblog.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDateTime;

import com.yinruiyang.ryblog.entity.Article;
import com.yinruiyang.ryblog.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insert(Article article) {
        String sql = "INSERT INTO article(title, content, create_time) VALUES (?, ?, NOW())";
        return jdbcTemplate.update(sql, article.getTitle(), article.getContent());
    }

    public List<Article> selectList() {

    String sql = """
        SELECT
            a.id            AS article_id,
            a.title         AS title,
            a.create_time   AS create_time,
            a.content       AS content,
            t.id            AS tag_id,
            t.name          AS tag_name,
            t.slug          AS tag_slug
        FROM article a
        LEFT JOIN post_tag pt ON a.id = pt.post_id
        LEFT JOIN tags t ON pt.tag_id = t.id
        ORDER BY a.create_time DESC
        """;

    List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

    Map<Integer, Article> articleMap = new LinkedHashMap<>();

    for (Map<String, Object> row : rows) {

        Integer articleId = (Integer) row.get("article_id");

        Article article = articleMap.get(articleId);
        if (article == null) {
            article = new Article();
            article.setId(articleId);
            article.setTitle((String) row.get("title"));
            article.setContent((String) row.get("content"));
            article.setCreateTime(
                (LocalDateTime) row.get("create_time")
            );
            articleMap.put(articleId, article);
        }

        // 处理标签（可能为空）
        Integer tagId = (Integer) row.get("tag_id");
        if (tagId != null) {
            Tag tag = new Tag();
            tag.setId(tagId);
            tag.setName((String) row.get("tag_name"));
            tag.setSlug((String) row.get("tag_slug"));
            article.getTags().add(tag);
        }
    }

    return new ArrayList<>(articleMap.values());
}


    public Article selectById(Integer id) {
        String sql = "SELECT * FROM article WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Article.class), id);
    }
    public int deleteById(Integer id) {
        String sql = "DELETE FROM article WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
    public int update(Article article) {
        String sql = "UPDATE article SET title = ?, content = ? WHERE id = ?";
        return jdbcTemplate.update(sql, article.getTitle(), article.getContent(), article.getId());
    }
}
