package com.deng.article.service.impl;

import com.deng.article.entity.ArticleWithBLOBs;
import com.deng.article.mapper.ArticleMapperExt;
import com.deng.article.remote.MessageServiceRemote;
import com.deng.article.service.ArticleService;
import com.deng.article.web.request.ArticleRequest;
import com.deng.article.web.result.ArticleResult;
import com.deng.common.response.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapperExt articleMapperExt;
    @Autowired
    private MessageServiceRemote messageServiceRemote;

    public Response<List<ArticleResult>> getArticleByIndex(){

        return Response.createBySuccess(articleMapperExt.getArticleByIndex());
    }

    public Response<List<ArticleResult>> getArticleByCategory(String categoryId){
        return Response.createBySuccess(articleMapperExt.getArticleByCategory(categoryId));
    }

    public Response<List<ArticleResult>> getArticleByLikeNumber(){
        return Response.createBySuccess(articleMapperExt.getArticleByLikeNumber());
    }

    public Response<ArticleResult> getArticle(String id){
        //阅读量加一
        ArticleWithBLOBs articleWithBLOBs = articleMapperExt.selectByPrimaryKey(id);
        articleWithBLOBs.setReadNumber(articleWithBLOBs.getReadNumber()+1);
        articleMapperExt.updateByPrimaryKeyWithBLOBs(articleWithBLOBs);
        ArticleResult result = articleMapperExt.getArticle(id);
        result.setMessages(messageServiceRemote.getMessageByArticleId(id));
        return Response.createBySuccess(result);
    }

    public Response<Integer> likeArticle(String id){
        //点赞量加一
        ArticleWithBLOBs articleWithBLOBs = articleMapperExt.selectByPrimaryKey(id);
        int likeNumber = articleWithBLOBs.getLikeNumber()+1;
        articleWithBLOBs.setReadNumber(likeNumber);
        articleMapperExt.updateByPrimaryKeyWithBLOBs(articleWithBLOBs);
        return Response.createBySuccess(likeNumber);
    }

    public Response addArticle(ArticleRequest articleRequest){

        ArticleWithBLOBs articleWithBLOBs = new ArticleWithBLOBs();
        BeanUtils.copyProperties(articleRequest,articleWithBLOBs);
        //补全信息
        articleWithBLOBs.setReadNumber(0);
        articleWithBLOBs.setLikeNumber(0);
        articleWithBLOBs.setMessNumber(0);
        articleWithBLOBs.setUpdatedTime(new Date());
        articleWithBLOBs.setUpdatedUser("邓小辉");
        articleMapperExt.insert(articleWithBLOBs);
        return Response.createBySuccess("新增成功");
    }

    public Response deleteArticle(String id){
        articleMapperExt.deleteByPrimaryKey(id);
        return Response.createBySuccess("删除成功");
    }
}
