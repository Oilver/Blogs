package com.deng.message.service.impl;

import com.deng.message.entity.Message;
import com.deng.message.mapper.MessageMapperExt;
import com.deng.message.service.MessageService;
import com.deng.message.web.request.MessageRequest;
import com.deng.message.web.request.ReplyRequest;
import com.deng.message.web.result.MessageResult;
import com.deng.common.response.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageMapperExt messageMapperExt;

    @Override
    public Response addMessage(MessageRequest messageRequest) {
        Message message = new Message();
        BeanUtils.copyProperties(messageRequest,message);
        message.setUpdatedTime(new Date());
        //判断第几楼
        int currentFloor = messageMapperExt.queryCount(message.getArticleId());
        message.setFloor(currentFloor+1);
        messageMapperExt.insert(message);
        return Response.createBySuccess("留言成功");
    }

    @Override
    public Response reply(ReplyRequest replyRequest) {
        Message message = new Message();
        BeanUtils.copyProperties(replyRequest,message);
        message.setUpdatedTime(new Date());
        //判断第几楼
        int currentFloor = messageMapperExt.queryCount(message.getArticleId());
        message.setUpdatedUser(replyRequest.getUpdatedUser()+ " 回复--" +
                replyRequest.getLastFloor() + "楼--" + replyRequest.getLastUser());
        message.setFloor(currentFloor+1);
        messageMapperExt.insert(message);
        return Response.createBySuccess("回复成功");
    }

    @Override
    public List<MessageResult> getMessageByArticleId(String messageId){
        List<MessageResult> result =  messageMapperExt.getMessageByArticleId(messageId);
        return result;
    }

}
