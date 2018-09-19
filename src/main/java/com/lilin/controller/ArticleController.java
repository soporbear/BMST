package com.lilin.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lilin.pojo.Article;
import com.lilin.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/manage/article/")
public class ArticleController {

    private ArticleService articleService;
    private ObjectMapper objectMapper;

    @Autowired
    ArticleController(ArticleService articleService, ObjectMapper objectMapper){
        this.articleService = articleService;
        this.objectMapper =objectMapper;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String manage(){
        return "manage";
    }

    @ResponseBody
    @RequestMapping(value = "select", method = RequestMethod.GET)
    public String select (int id) throws JsonProcessingException{
        Article article = articleService.select(id);
        return objectMapper.writeValueAsString(article);
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String delete(int id){
        articleService.delete(id);
        return "redirect:.";
    }

    @RequestMapping(value = "insert",method = RequestMethod.GET)
    public String insert(String title, String author, String content){
        articleService.insert(title, author, content);
        return "redirect:.";
    }

    @RequestMapping(value = "update",method = RequestMethod.GET)
    public String update(int id, String title, String author, String content){
        articleService.update(id, title, author, content);
        return "redirect:.";
    }

    @ResponseBody
    @RequestMapping(value = "getData",method = RequestMethod.GET)
    public String test() throws JsonProcessingException{
        List<Article> articles = articleService.list();
        System.out.println(articles);
        System.out.println(objectMapper.writeValueAsString(articles));
        return objectMapper.writeValueAsString(articles);
    }

}
