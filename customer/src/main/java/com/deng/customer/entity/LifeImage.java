package com.deng.customer.entity;

import lombok.Data;

import java.util.Date;

@Data
public class LifeImage {
    private String id;

    private String url;

    private Long sizes;

    private Date datatime;

    private String title;

}