package com.deng.message.service;

import com.deng.common.response.Response;
import com.deng.message.web.request.MessageRequest;
import com.deng.message.web.request.ReplyRequest;
import com.deng.message.web.result.MessageResult;

import java.util.List;

public interface MessageService {

    /**
     * 留言功能
     * @return
     */
    Response addMessage(MessageRequest messageRequest);

    /**
     * 回复功能
     * @return
     */
    Response reply(ReplyRequest replyRequest);

    List<MessageResult> getMessageByArticleId(String articleId);
}
