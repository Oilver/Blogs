package com.deng.article.service;

import com.deng.article.web.request.CategoryRequest;
import com.deng.article.web.result.CategoryResult;
import com.deng.common.Const.Const;
import com.deng.common.annotation.Check;
import com.deng.common.response.Response;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CategoryService {

    /**
     * 得到所有的分类
     * @return
     */
    Response<List<CategoryResult>> getCategory();

    /**
     * 增加分类
     * @param categoryRequest
     * @return
     */
    Response addCategory(CategoryRequest categoryRequest);

    Response deleteCategory(String id);

}
