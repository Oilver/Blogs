package com.deng.article.service;

import com.deng.article.web.request.ArticleRequest;
import com.deng.article.web.result.ArticleResult;
import com.deng.common.response.Response;

import java.util.List;


public interface ArticleService {

    /**
     * 首页
     * @return
     */
    Response<List<ArticleResult>> getArticleByIndex();

    /**
     * 热门点击
     * @return
     */
    Response<List<ArticleResult>> getArticleByLikeNumber();

    /**
     * 分类后显示文章
     * @return
     */
    Response<List<ArticleResult>> getArticleByCategory(String categoryId);

    /**
     * 显示文章，阅读量加1
     * @param id
     * @return
     */
    Response<ArticleResult> getArticle(String id);

    /**
     * 点赞
     * @param id
     * @return
     */
    Response<Integer> likeArticle(String id);

    Response addArticle(ArticleRequest articleRequest);

    Response deleteArticle(String id);

}
