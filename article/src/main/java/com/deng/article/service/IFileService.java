package com.deng.article.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by 辉
 */
public interface IFileService {

    String upload(MultipartFile file, String path);
}
