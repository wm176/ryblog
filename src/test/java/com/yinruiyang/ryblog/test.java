package com.yinruiyang.ryblog;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yinruiyang.ryblog.entity.Article;
import com.yinruiyang.ryblog.dao.TagsDao;

@SpringBootTest
class test {

    @Autowired
    private TagsDao tagsDao;

    @Test
    void print() {
        System.out.println("-------------------");
        System.out.println("test");
        List<Article> articles = tagsDao.selectArticlesByTagId(1);
        List <String> articleTitles = new ArrayList<>();
        for (Article article : articles) {
            articleTitles.add(article.getTitle());
        }
        System.out.println(articleTitles);
    }
}
