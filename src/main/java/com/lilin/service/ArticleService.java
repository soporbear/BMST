package com.lilin.service;

import com.lilin.dao.ArticleDao;
import com.lilin.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private ArticleDao articleDao;

    @Autowired
    ArticleService(ArticleDao articleDao){
        this.articleDao = articleDao;
    }

    public Article select(int id){
        return articleDao.selectArticleById(id);
    }

    public void delete(int id){
        articleDao.deleteArticleById(id);
    }

    public void insert(String title, String author, String content){
        articleDao.insertArticle(title, author, content);
    }

    public void update(int id, String title, String author, String content){
        articleDao.updateArticle(id, title, author, content);
    }

    public List<Article> list(){
        return articleDao.selectArticleAll();
    }
}
