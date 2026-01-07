package com.yinruiyang.ryblog;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yinruiyang.ryblog.dao.ArticleDao;
import com.yinruiyang.ryblog.entity.Article;

@SpringBootTest
class test {

    @Autowired
    private ArticleDao articleDao;

    @Test
    void print() {
        System.out.println("-------------------");
        System.out.println("test");
        List<Article> articles = articleDao.selectList();
        for (Article article : articles) {
            System.out.println(article);
        }
        System.out.println("-------------------");
    }
}
