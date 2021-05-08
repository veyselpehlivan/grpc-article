package com.coronaclientservice.controller;

import com.coronaclientservice.dto.RequestDTO;
import com.coronaclientservice.service.ArticleService;
import greet.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping(value = "/create")
    public String addNewArticle() throws IOException {

        Main.AddArticleRequest article = Main.AddArticleRequest.newBuilder()
                .setArticleContent("grpc-3")
                .setAuthor("veysel")
                .build();

        Main.ArticleReply articleReply = articleService.saveArticle(article);

        return articleReply.toString();
    }

    @RequestMapping(value = "/{articleId}", method = RequestMethod.GET)
    public String getArticle(@PathVariable String articleId) throws IOException {
        Main.GetArticleRequest getArticleRequest = Main.GetArticleRequest.newBuilder().setId(articleId).build();

        Main.ArticleReply articleReply = articleService.getArticleById(getArticleRequest);

        return articleReply.toString();
    }
}
