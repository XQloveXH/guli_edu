package com.zxq.eduservice.controller;


import com.zxq.commonutils.R;
import com.zxq.eduservice.service.EduSubjectService;
import com.zxq.servicebase.exception.GuliException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author zxq
 * @since 2020-06-17
 */
@RestController
@RequestMapping("/eduservice/subject")
@CrossOrigin
public class EduSubjectController {

    @Autowired
    private EduSubjectService subjectService;

    @PostMapping("addsubject")
    public R readExcel(MultipartFile file){
        subjectService.readExcel(file,subjectService);
        return R.ok();
    }

    @GetMapping("getdata")
    public R getData(){
        return R.ok(subjectService.getData());
    }


}

