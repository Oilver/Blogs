package com.deng.customer.service;

import com.deng.common.response.Response;
import com.deng.customer.entity.LifeImage;
import com.deng.customer.web.result.LifeImageResult;

import java.util.List;

public interface LifeImageService {

    Response<List<LifeImageResult>> getImages();

    int addImages(LifeImage lifeImage);
}
