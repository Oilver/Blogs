package com.deng.customer.service.impl;

import com.deng.common.response.Response;
import com.deng.customer.entity.LifeImage;
import com.deng.customer.mapper.LifeImageMapperExt;
import com.deng.customer.service.LifeImageService;
import com.deng.customer.web.result.LifeImageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LifeImageServiceImpl implements LifeImageService {
    @Autowired
    private LifeImageMapperExt lifeImageMapperExt;

    @Override
    public Response<List<LifeImageResult>> getImages() {

        return Response.createBySuccess(lifeImageMapperExt.getImages());
    }

    @Override
    public int addImages(LifeImage lifeImage) {
        int res = lifeImageMapperExt.insert(lifeImage);
        if (1 == res){
            return 200;
        }
        else return 500;
    }
}
