package com.zxq.eduservice.service;

import com.zxq.eduservice.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxq.eduservice.entity.subject.OneSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author zxq
 * @since 2020-06-17
 */
public interface EduSubjectService extends IService<EduSubject> {

    void readExcel(MultipartFile file, EduSubjectService subjectService);

    List<OneSubject> getData();
}
