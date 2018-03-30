package com.deng.article.entity;

public class ArticleWithBLOBs extends Article {
    private String introduction;

    private String content;

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        //this.introduction = introduction == null ? null : introduction.trim();
        this.introduction = introduction;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        //this.content = content == null ? null : content.trim();
        this.content = content;
    }
}