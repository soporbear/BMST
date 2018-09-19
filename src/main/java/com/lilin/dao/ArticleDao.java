package com.lilin.dao;

import com.lilin.pojo.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ArticleDao {

    @Select("SELECT * FROM Article WHERE id = #{id}")
    Article selectArticleById(int id);

    @Insert("INSERT INTO Article ( title, author, content ) " +
            "VALUES ( #{title}, #{author}, #{content} )")
    void insertArticle(@Param("title")String title, @Param("author")String author, @Param("content")String content);

    @Delete("DELETE FROM Article WHERE id = #{id}")
    void deleteArticleById(int id);

    @Update("UPDATE Article SET title = #{title}, author = #{author}, content = #{content}" +
            "WHERE id = #{id}")
    void updateArticle(@Param("id")int id, @Param("title")String title, @Param("author")String author, @Param("content")String content);

    @Select("SELECT * FROM Article")
    List<Article> selectArticleAll();
}
