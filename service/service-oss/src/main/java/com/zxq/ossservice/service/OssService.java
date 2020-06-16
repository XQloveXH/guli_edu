package com.zxq.ossservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


/**
 * @Author zxq
 * @Date 2020/6/16 21:23
 * @Version 1.0
 */
@Service
public interface OssService {
    String uploadAvatar(MultipartFile file);
}
