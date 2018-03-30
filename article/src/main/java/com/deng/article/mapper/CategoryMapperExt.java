package com.deng.article.mapper;

import com.deng.article.web.result.CategoryResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapperExt extends CategoryMapper{

    List<CategoryResult> getCategory();
}