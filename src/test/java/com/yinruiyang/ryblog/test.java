package com.yinruiyang.ryblog;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yinruiyang.ryblog.entity.Article;
import com.yinruiyang.ryblog.entity.Tag;
import com.yinruiyang.ryblog.dao.TagsDao;

@SpringBootTest
class test {

    @Autowired
    private TagsDao tagsDao;

    @Test
    void print() {
        List<Tag> tags = tagsDao.selectAll();
        System.out.println(tags);
    }
}
