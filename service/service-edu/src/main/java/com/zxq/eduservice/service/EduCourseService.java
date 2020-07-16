package com.zxq.eduservice.service;

import com.zxq.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxq.eduservice.entity.vo.CourseInfoVo;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author zxq
 * @since 2020-07-15
 */
public interface EduCourseService extends IService<EduCourse> {

    String addInfo(CourseInfoVo courseInfoVo);
}
