package com.yinruiyang.ryblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yinruiyang.ryblog.common.Result;
import com.yinruiyang.ryblog.dao.TagsDao;
import com.yinruiyang.ryblog.entity.Article;
import com.yinruiyang.ryblog.entity.Tag;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/tags")
public class TagController {
   
    @Autowired
    private TagsDao tagsDao;

    @GetMapping("/list")
    public Result<List<Tag>> getTagsList() {
        List<Tag> tags = tagsDao.selectAll();
        return Result.success(tags);
    }
    
    @GetMapping("/{id}")
    public Result<List<Article>> getArticlesByTagId(@PathVariable Integer id) {
        List<Article> articles = tagsDao.selectArticlesByTagId(id);
        return Result.success(articles);
    }
}
