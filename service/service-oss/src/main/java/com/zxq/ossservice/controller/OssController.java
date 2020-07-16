package com.zxq.ossservice.controller;

import com.zxq.commonutils.R;
import com.zxq.ossservice.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author zxq
 * @Date 2020/6/16 21:22
 * @Version 1.0
 */
@RestController
@RequestMapping("edu/oss")
@CrossOrigin
public class OssController {

    @Autowired
    private OssService ossService;

    @PostMapping("avatar")
    public R uploadAvatar(@RequestParam MultipartFile file){

        return R.ok(ossService.uploadAvatar(file));
    }
}
