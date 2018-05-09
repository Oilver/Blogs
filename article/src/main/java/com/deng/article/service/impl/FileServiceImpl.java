package com.deng.article.service.impl;

import com.deng.article.entity.LifeImage;
import com.deng.article.remote.CustomerServiceRemote;
import com.deng.article.service.IFileService;
import com.deng.common.response.Response;
import com.deng.common.utils.FTPUtil;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * Created by 辉
 */
@Service("iFileService")
public class FileServiceImpl implements IFileService {

    @Autowired
    private CustomerServiceRemote customerServiceRemote;

    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    public Response uploadLifeImage(MultipartFile file, String path){
        String uploadResult = upload(file,path,"life");
        if(null == uploadResult){
            return null;
        }
        LifeImage lifeImage = new LifeImage();
        lifeImage.setId(UUID.randomUUID().toString());
        lifeImage.setUrl("http://lifeimage.blogs.com/" + uploadResult);
        lifeImage.setTitle("test");
        lifeImage.setSizes(new BigDecimal(file.getSize()));
        lifeImage.setDatatime(new Date());
        int result = customerServiceRemote.addImages(lifeImage);

        if (200 == result){
            return Response.createBySuccess("上传生活照成功！");
        }else return Response.createByErrorMessage("上传生活照失败！");
    }

    private String upload(MultipartFile file, String path,String flag){
        String fileName = file.getOriginalFilename();
        //扩展名
        //abc.jpg
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".")+1);
        String uploadFileName = UUID.randomUUID().toString()+"."+fileExtensionName;
        logger.info("开始上传文件,上传文件的文件名:{},上传的路径:{},新文件名:{}",fileName,path,uploadFileName);

        File fileDir = new File(path);
        if(!fileDir.exists()){
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File targetFile = new File(path,uploadFileName);

        try {
            file.transferTo(targetFile);
            //文件已经上传成功了

            if(flag.equals("life")){
                FTPUtil.uploadFileToLife(Lists.newArrayList(targetFile));
            }else {
                FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            }
            //已经上传到ftp服务器上

            targetFile.delete();
        } catch (IOException e) {
            logger.error("上传文件异常",e);
            return null;
        }
        //A:abc.jpg
        //B:abc.jpg
        return targetFile.getName();
    }


}
