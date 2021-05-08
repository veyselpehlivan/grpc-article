package com.coronaclientservice.service;

import greet.ArticleGrpc;
import greet.Main;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ArticleService {

    @GrpcClient("corona-service")
    private ArticleGrpc.ArticleBlockingStub articleBlockingStub;

    public Main.ArticleReply getArticleById(Main.GetArticleRequest getArticleRequest) throws IOException {
        return articleBlockingStub.getArticle(getArticleRequest);
    }

    public Main.ArticleReply saveArticle(Main.AddArticleRequest addArticleRequest) throws IOException {
        return articleBlockingStub.addArticle(addArticleRequest);
    }
}
