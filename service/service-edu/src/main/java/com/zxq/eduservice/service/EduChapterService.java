package com.zxq.eduservice.service;

import com.zxq.eduservice.entity.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxq.eduservice.entity.chapter.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author zxq
 * @since 2020-07-15
 */
public interface EduChapterService extends IService<EduChapter> {

    List<ChapterVo> getChapterVideoByCourseId(String courseId);

    boolean deleteChapter(String chapterId);
}
