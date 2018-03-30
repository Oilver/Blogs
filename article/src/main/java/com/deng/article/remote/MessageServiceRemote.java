package com.deng.article.remote;

import com.deng.article.web.result.MessageResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "message-service")
public interface MessageServiceRemote {

    @RequestMapping(value = "/messageByAriId",method = RequestMethod.POST)
    List<MessageResult> getMessageByArticleId(@RequestParam("articleId") String articleId);
}
