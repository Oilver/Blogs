package com.deng.article.web.request;

import com.deng.common.request.BaseCheckRequest;
import lombok.Data;

@Data
public class CategoryRequest extends BaseCheckRequest {

    private String name;
}
