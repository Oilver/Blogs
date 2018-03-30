package com.deng.common.request;

import org.springframework.util.StringUtils;

import java.util.UUID;

public class BaseRequest {
    private String id;

    public String getId() {
        if(StringUtils.isEmpty(id)){
            setId(UUID.randomUUID().toString());
        }
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
