package com.yinruiyang.ryblog.dao;

import java.util.List;

import com.yinruiyang.ryblog.entity.Article;
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
        String sql = "SELECT * FROM article ORDER BY create_time DESC";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Article.class));
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
