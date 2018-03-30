package com.deng.article.mapper;

import com.deng.article.entity.Category;
import org.apache.ibatis.annotations.Mapper;

public interface CategoryMapper {
    int deleteByPrimaryKey(String id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}