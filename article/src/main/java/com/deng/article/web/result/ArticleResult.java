package com.deng.article.web.result;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class ArticleResult{

    private String id;

    private List<MessageResult> messages;

    /**
     * 类别的id
     */
    private String categoryId;

    /**
     *类别的名字（如后端面试）
     */
    private String categoryName;

    /**
     *图片url
     */
    private String picture;

    /**
     *标题
     */
    private String title;

    /**
     *阅读量
     */
    private Integer readNumber;

    /**
     *点赞数
     */
    private Integer likeNumber;

    /**
     *留言数
     */
    private Integer messNumber;

    /**
     *发表时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",locale = "zh",timezone = "GMT+8")
    private Date updatedTime;

    /**
     *作者
     */
    private String updatedUser;

    /**
     * 简介
     */
    private String introduction;

    /**
     * 内容
     */
    private String content;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

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

    public List<MessageResult> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageResult> messages) {
        this.messages = messages;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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