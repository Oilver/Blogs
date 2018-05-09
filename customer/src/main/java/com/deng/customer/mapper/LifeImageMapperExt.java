package com.deng.customer.mapper;

import com.deng.customer.web.result.LifeImageResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LifeImageMapperExt extends LifeImageMapper{

    List<LifeImageResult> getImages();
}