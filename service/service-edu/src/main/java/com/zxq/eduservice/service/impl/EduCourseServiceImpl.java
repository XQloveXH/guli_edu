package com.zxq.eduservice.service.impl;

import com.zxq.eduservice.entity.EduCourse;
import com.zxq.eduservice.entity.EduCourseDescription;
import com.zxq.eduservice.entity.vo.CourseInfoVo;
import com.zxq.eduservice.mapper.EduCourseMapper;
import com.zxq.eduservice.service.EduCourseDescriptionService;
import com.zxq.eduservice.service.EduCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxq.servicebase.exception.GuliException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author zxq
 * @since 2020-07-15
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {
    @Autowired
    private EduCourseMapper eduCourseMapper;
    @Autowired
    private EduCourseDescriptionService descriptionService;

    @Override
    public String addInfo(CourseInfoVo courseInfoVo) {
        //添加课程信息
        EduCourse course = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo,course);
        int insert = eduCourseMapper.insert(course);
        if(insert <= 0){
            throw  new GuliException(500,"添加课程信息失败");
        }
        //添加对应的课程简介
        String courseId = course.getId();
        EduCourseDescription courseDescription = new EduCourseDescription();
        courseDescription.setDescription(courseInfoVo.getDescription());
        courseDescription.setId(courseId);
        descriptionService.save(courseDescription);
        return courseId;
    }
}
