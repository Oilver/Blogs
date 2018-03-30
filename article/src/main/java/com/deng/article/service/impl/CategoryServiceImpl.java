package com.deng.article.service.impl;

import com.deng.article.entity.Category;
import com.deng.article.mapper.CategoryMapperExt;
import com.deng.article.service.CategoryService;
import com.deng.article.web.request.CategoryRequest;
import com.deng.article.web.result.CategoryResult;
import com.deng.common.response.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapperExt categoryMapperExt;

    @Override
    public Response<List<CategoryResult>> getCategory() {
        List<CategoryResult> resultList= categoryMapperExt.getCategory();
        return Response.createBySuccess(resultList);
    }

    @Override
    public Response addCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryRequest,category);
        categoryMapperExt.insert(category);
        return Response.createBySuccess();
    }

    @Override
    public Response deleteCategory(String id) {
        categoryMapperExt.deleteByPrimaryKey(id);
        return Response.createBySuccess();
    }

}
