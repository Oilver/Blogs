package com.deng.customer.web.controller;

import com.deng.common.Const.Const;
import com.deng.common.response.Response;
import com.deng.customer.entity.LifeImage;
import com.deng.customer.service.LifeImageService;
import com.deng.customer.web.result.LifeImageResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LifeImageController {
    @Autowired
    private LifeImageService lifeImageService;

    @ApiOperation(value = "查看生活照")
    @RequestMapping(value = "/images",method = RequestMethod.GET,produces = Const.JOSN)
    public Response<List<LifeImageResult>> getImages(){

        return lifeImageService.getImages();
    }

    @ApiOperation(value = "增加生活照")
    @RequestMapping(value = "/images",method = RequestMethod.POST,produces = Const.JOSN)
    public int addImages(@RequestBody LifeImage lifeImage){

        return lifeImageService.addImages(lifeImage);
    }
}
