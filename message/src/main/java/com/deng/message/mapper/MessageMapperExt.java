package com.deng.message.mapper;

import com.deng.message.web.result.MessageResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface MessageMapperExt extends MessageMapper{

    int queryCount(@Param("articleId") String articleId);

    List<MessageResult> getMessageByArticleId(@Param("articleId") String articleId);
}