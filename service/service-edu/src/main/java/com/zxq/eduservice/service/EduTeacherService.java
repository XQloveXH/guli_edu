package com.zxq.eduservice.service;

import com.zxq.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxq.eduservice.entity.vo.TeacherQuery;

import java.util.List;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author zxq
 * @since 2020-06-15
 */
public interface EduTeacherService extends IService<EduTeacher> {


    List<EduTeacher> selectPage(long current,long size);

    List<EduTeacher> choosePage(long current, long size, TeacherQuery teacherQuery);


}
