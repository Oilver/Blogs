package com.deng.article.remote;

import com.deng.article.entity.LifeImage;
import com.deng.article.web.result.MessageResult;
import com.deng.common.response.Response;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "customer-service")
public interface CustomerServiceRemote {

    @RequestMapping(value = "/images",method = RequestMethod.POST)
    int addImages(@RequestBody LifeImage lifeImage);
}
