package com.deng.article.web.request;

import com.deng.common.request.BaseCheckRequest;

import java.util.Date;

public class ArticleRequest extends BaseCheckRequest {
    private String categoryId;

    private String picture;

    private String title;

    private Integer readNumber;

    private Integer likeNumber;

    private Integer messNumber;

    private Date updatedTime;

    private String updatedUser;

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

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReadNumber() {
        return readNumber;
    }

    public void setReadNumber(Integer readNumber) {
        this.readNumber = readNumber;
    }

    public Integer getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(Integer likeNumber) {
        this.likeNumber = likeNumber;
    }

    public Integer getMessNumber() {
        return messNumber;
    }

    public void setMessNumber(Integer messNumber) {
        this.messNumber = messNumber;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getUpdatedUser() {
        return updatedUser;
    }

    public void setUpdatedUser(String updatedUser) {
        this.updatedUser = updatedUser;
    }
}