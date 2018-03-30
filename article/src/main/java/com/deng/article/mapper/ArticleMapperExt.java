package com.deng.article.mapper;

import com.deng.article.web.result.ArticleResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleMapperExt extends ArticleMapper{

    List<ArticleResult> getArticleByIndex();

    List<ArticleResult> getArticleByLikeNumber();

    List<ArticleResult> getArticleByCategory(@Param("categoryId") String categoryId);

    ArticleResult getArticle(@Param("id")String id);
}