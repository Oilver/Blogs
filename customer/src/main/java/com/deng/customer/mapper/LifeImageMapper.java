package com.deng.customer.mapper;

import com.deng.customer.entity.LifeImage;

public interface LifeImageMapper {
    int deleteByPrimaryKey(String id);

    int insert(LifeImage record);

    int insertSelective(LifeImage record);

    LifeImage selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(LifeImage record);

    int updateByPrimaryKey(LifeImage record);
}