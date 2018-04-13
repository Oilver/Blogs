package com.deng.message.web.controller;

import com.deng.common.Const.Const;
import com.deng.common.annotation.Check;
import com.deng.common.response.Response;
import com.deng.message.service.MessageService;
import com.deng.message.web.request.MessageRequest;
import com.deng.message.web.request.ReplyRequest;
import com.deng.message.web.result.MessageResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.List;


@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    //@Check
    @ApiOperation(value = "留言")
    @RequestMapping(value = "/message",method = RequestMethod.POST,produces = Const.JOSN)
    public Response addMessage(@RequestBody MessageRequest messageRequest){

        return messageService.addMessage(messageRequest);
    }

    //@Check
    @ApiOperation(value = "回复")
    @RequestMapping(value = "/message/reply",method = RequestMethod.POST,produces = Const.JOSN)
    public Response reply(@RequestBody ReplyRequest replyRequest){

        return messageService.reply(replyRequest);
    }

    @ApiOperation(value = "查看留言")
    @RequestMapping(value = "/messageByAriId",method = RequestMethod.POST)
    public List<MessageResult> getMessageByArticleId(@RequestParam("articleId") String articleId){

        List<MessageResult> result = messageService.getMessageByArticleId(articleId);
        return result;
    }



}
