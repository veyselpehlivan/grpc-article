package com.coronaclientservice.dto;

import java.util.Date;

public class RequestDTO implements java.io.Serializable{

    private static final long serialVersionUID = -919446765920147508L;

    private String Title;
    private String Author;
    private String ArticleContent;
    private Date PublishDate;
    private int StarCount;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getArticleContent() {
        return ArticleContent;
    }

    public void setArticleContent(String articleContent) {
        ArticleContent = articleContent;
    }

    public Date getPublishDate() {
        return PublishDate;
    }

    public void setPublishDate(Date publishDate) {
        PublishDate = publishDate;
    }

    public int getStarCount() {
        return StarCount;
    }

    public void setStarCount(int starCount) {
        StarCount = starCount;
    }
}

