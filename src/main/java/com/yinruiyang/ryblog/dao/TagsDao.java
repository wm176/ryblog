package com.yinruiyang.ryblog.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.yinruiyang.ryblog.entity.Article;
import com.yinruiyang.ryblog.entity.Tag;




@Repository
public class TagsDao {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Tag> selectAll() {
        String sql = "SELECT id, name, slug FROM tags";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Tag.class));
    }

    public List<Article> selectArticlesByTagId(Integer tagId) {
        String sql = """
            SELECT
                a.id          AS id,
                a.title       AS title
            FROM article a
            JOIN post_tag pt ON a.id = pt.post_id
            WHERE pt.tag_id = ?
            ORDER BY a.create_time DESC
            """;
        return jdbcTemplate.query(
            sql,
            new BeanPropertyRowMapper<>(Article.class),
            tagId
        );
    }
}
