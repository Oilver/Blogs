package com.deng.article.remote.impl;

import com.deng.article.remote.MessageServiceRemote;
import com.deng.article.web.result.MessageResult;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageServiceHystric implements MessageServiceRemote {
    @Override
    public List<MessageResult> getMessageByArticleId(String articleId) {
        return null;
    }
}
