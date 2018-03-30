package com.deng.article.web.controller;

import com.deng.article.service.CategoryService;
import com.deng.article.web.request.ArticleRequest;
import com.deng.article.web.request.CategoryRequest;
import com.deng.article.web.result.ArticleResult;
import com.deng.article.web.result.CategoryResult;
import com.deng.common.Const.Const;
import com.deng.common.annotation.Check;
import com.deng.common.response.Response;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "显示所有的分类")
    @RequestMapping(value = "/category/list",method = RequestMethod.GET,produces = Const.JOSN)
    public Response<List<CategoryResult>> getCategory(){

        return categoryService.getCategory();
    }

    @Check
    @ApiOperation(value = "增加分类")
    @RequestMapping(value = "/category",method = RequestMethod.POST,produces = Const.JOSN)
    public Response addCategory(@RequestBody CategoryRequest categoryRequest){

        return categoryService.addCategory(categoryRequest);
    }

    @Check
    @ApiOperation(value = "删除分类")
    @RequestMapping(value = "/category",method = RequestMethod.DELETE,produces = Const.JOSN)
    public Response deleteCategory(@RequestParam String userId,@RequestParam String id){

        return categoryService.deleteCategory(id);
    }
}
