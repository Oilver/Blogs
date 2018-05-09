package com.deng.article.entity;

import java.math.BigDecimal;
import java.util.Date;

public class LifeImage {
    private String id;

    private String url;

    private BigDecimal sizes;

    private Date datatime;

    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public BigDecimal getSizes() {
        return sizes;
    }

    public void setSizes(BigDecimal sizes) {
        this.sizes = sizes;
    }

    public Date getDatatime() {
        return datatime;
    }

    public void setDatatime(Date datatime) {
        this.datatime = datatime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
}