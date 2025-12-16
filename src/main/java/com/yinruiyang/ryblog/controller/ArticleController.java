package com.yinruiyang.ryblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yinruiyang.ryblog.entity.Article;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.yinruiyang.ryblog.common.Result;
import com.yinruiyang.ryblog.dao.ArticleDao;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/article")
public class ArticleController {
    
    @Autowired
    private ArticleDao articleDao;
    
    @PostMapping("/add")
    public Result<?> add(@RequestBody Article article) {     
        articleDao.insert(article);
        return Result.success();
    }
    
    @GetMapping("/list")
    public Result<List<Article>> list() {
        List<Article> articles = articleDao.selectList();
        return Result.success(articles);
    }
    @GetMapping("/{id}")
    public Result<Article> getById(@PathVariable Integer id) {
        Article article = articleDao.selectById(id);
        return Result.success(article);
    }
    
    @PutMapping("/update")
    public Result<?> update(@RequestBody Article article) {
        articleDao.update(article);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result<?> delete(@PathVariable Integer id) {
        articleDao.deleteById(id);
        return Result.success();
    }
}
