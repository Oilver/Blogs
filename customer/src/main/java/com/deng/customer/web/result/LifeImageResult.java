package com.deng.customer.web.result;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class LifeImageResult {
    private String id;

    private String url;

    private BigDecimal sizes;

    private Date datatime;

    private String title;
}
