package com.coronaservice.service;

import com.coronaservice.model.Article;
import com.coronaservice.repository.ArticleRepository;
import greet.ArticleGrpc;
import greet.Main;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.Optional;

@GrpcService
public class CoronaService extends ArticleGrpc.ArticleImplBase {

    private ArticleRepository articleRepository;

    public CoronaService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public void addArticle(Main.AddArticleRequest request, StreamObserver<Main.ArticleReply> responseObserver) {
        Article article = new Article();
        article.setTitle(request.getTitle());
        article.setAuthor(request.getAuthor());
        article.setArticleContent(request.getArticleContent());
        article.setPublishDate(request.getPublishDate());
        article.setStarCount(request.getStarCount());

        Article savedArticle = articleRepository.save(article);

        Main.ArticleReply articleReply = Main.ArticleReply.newBuilder()
                .setAuthor(savedArticle.getAuthor())
                .setArticleContent(savedArticle.getArticleContent())
                .setStarCount(savedArticle.getStarCount())
                .setPublishDate(savedArticle.getPublishDate())
                .setId(savedArticle.getId())
                .setTitle(savedArticle.getTitle())
                .build();

        responseObserver.onNext(articleReply);
        responseObserver.onCompleted();
    }

    @Override
    public void getArticle(Main.GetArticleRequest request, StreamObserver<Main.ArticleReply> responseObserver) {
        Optional<Article> article = articleRepository.findById(request.getId());

        Main.ArticleReply articleReply = Main.ArticleReply.newBuilder()
                .setAuthor(article.get().getAuthor())
                .setArticleContent(article.get().getArticleContent())
                .setStarCount(article.get().getStarCount())
                .setPublishDate(article.get().getPublishDate())
                .setId(article.get().getId())
                .setTitle(article.get().getTitle())
                .build();
        responseObserver.onNext(articleReply);
        responseObserver.onCompleted();
    }


}
