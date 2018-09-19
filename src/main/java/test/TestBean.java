package test;

import com.lilin.pojo.Article;
import com.lilin.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestBean {

    @Autowired
    ArticleService articleService;

    public List<Article> list(){
        return articleService.list();
    }
}
