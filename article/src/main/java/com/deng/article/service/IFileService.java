package com.deng.article.service;

import com.deng.common.response.Response;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by 辉
 */
public interface IFileService {

    Response uploadLifeImage(MultipartFile file, String path);
}
