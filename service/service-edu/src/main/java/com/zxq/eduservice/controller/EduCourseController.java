package com.zxq.eduservice.controller;


import com.zxq.commonutils.R;
import com.zxq.eduservice.entity.vo.CourseInfoVo;
import com.zxq.eduservice.service.EduCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author zxq
 * @since 2020-07-15
 */
@RestController
@RequestMapping("/eduservice/course")
@CrossOrigin
public class EduCourseController {

    @Autowired
    private EduCourseService eduCourseService;
    @PostMapping("addinfo")
    public R addInfo(@RequestBody CourseInfoVo courseInfoVo){
        String courseId = eduCourseService.addInfo(courseInfoVo);
        return R.ok(courseId);
    }

}

