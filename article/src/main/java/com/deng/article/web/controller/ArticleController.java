package com.deng.article.web.controller;

import com.deng.article.service.ArticleService;
import com.deng.article.service.IFileService;
import com.deng.article.web.request.ArticleRequest;
import com.deng.article.web.result.ArticleResult;
import com.deng.common.Const.Const;
import com.deng.common.annotation.Check;
import com.deng.common.response.Response;
import com.google.common.collect.Maps;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private IFileService iFileService;

    @ApiOperation(value = "显示首页的博客文章，根据时间降序")
    @RequestMapping(value = "/article/index",method = RequestMethod.GET,produces = Const.JOSN)
    public Response<List<ArticleResult>> getArticleByIndex(){

        return articleService.getArticleByIndex();
    }

    @ApiOperation(value = "根据分类显示文章")
    @RequestMapping(value = "/articleByCategory",method = RequestMethod.GET,produces = Const.JOSN)
    public Response<List<ArticleResult>> getArticleByCategory(@RequestParam String categoryId){

        return articleService.getArticleByCategory(categoryId);
    }

    @ApiOperation(value = "显示热门博客文章，根据点赞量降序")
    @RequestMapping(value = "/articleByLikeNumber",method = RequestMethod.GET,produces = Const.JOSN)
    public Response<List<ArticleResult>> getArticleByLikeNumber(){

        return articleService.getArticleByLikeNumber();
    }

    @ApiOperation(value = "显示文章")
    @RequestMapping(value = "/article",method = RequestMethod.GET,produces = Const.JOSN)
    public Response<ArticleResult> getArticle(@RequestParam String id){

        return articleService.getArticle(id);
    }

    @ApiOperation(value = "点赞")
    @RequestMapping(value = "/likeArticle",method = RequestMethod.POST,produces = Const.JOSN)
    public Response<Integer> likeArticle(@RequestParam String id){

        return articleService.likeArticle(id);
    }

    @Check
    @ApiOperation(value = "写文章")
    @RequestMapping(value = "/article",method = RequestMethod.POST,produces = Const.JOSN)
    public Response addArticle(@RequestBody ArticleRequest articleRequest){

        return  articleService.addArticle(articleRequest);

    }

    @Check
    @ApiOperation(value = "删除文章")
    @RequestMapping(value = "/article",method = RequestMethod.DELETE,produces = Const.JOSN)
    public Response deleteArticle(@RequestParam String userId,@RequestParam String id){

        return articleService.deleteArticle(id);
    }

    //@ApiOperation(value = "上传图片")
    //@RequestMapping(value = "/upload",method = RequestMethod.POST,produces = Const.JOSN)
    //public Response upload(@RequestParam(value = "upload_file",required = false) MultipartFile file, HttpServletRequest request){
    //        String path = request.getSession().getServletContext().getRealPath("upload");
    //        String targetFileName = iFileService.upload(file,path);
    //        String url = "http://image.blogs.com/" + targetFileName;
    //
    //        Map fileMap = Maps.newHashMap();
    //        fileMap.put("uri",targetFileName);
    //        fileMap.put("url",url);
    //        return Response.createBySuccess(fileMap);
    //}

    @ApiOperation(value = "上传生活照")
    @RequestMapping(value = "/uploadLifeImage",method = RequestMethod.POST,produces = Const.JOSN)
    public Response uploadImage(@RequestParam(value = "upload_file",required = false) MultipartFile file, HttpServletRequest request){
        String path = request.getSession().getServletContext().getRealPath("upload");
        return iFileService.uploadLifeImage(file,path);
    }
    //@ApiOperation(value = "测试")
    //@RequestMapping(value = "/test",method = RequestMethod.POST)
    //public Response test(@RequestParam String id){
    //
    //    return Response.createBySuccess(messageServiceRemote.getMessageByArticleId(id));
    //}


}
