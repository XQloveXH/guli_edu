package com.zxq.eduservice.controller;


import com.zxq.commonutils.R;
import com.zxq.eduservice.entity.EduChapter;
import com.zxq.eduservice.entity.chapter.ChapterVo;
import com.zxq.eduservice.service.EduChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author zxq
 * @since 2020-07-15
 */
@RestController
@RequestMapping("/eduservice/chapter")
@CrossOrigin
public class EduChapterController {

    @Autowired
    private EduChapterService chapterService;
    @GetMapping("chapterlist/{courseId}")
    public R getChapterVideoByCourseId(@PathVariable String courseId){
        List<ChapterVo> chapterVoList = chapterService.getChapterVideoByCourseId(courseId);
        return R.ok(chapterVoList);
    }
    //添加章节
    @PostMapping("addChapter")
    public R addChapter(@RequestBody EduChapter eduChapter) {
        chapterService.save(eduChapter);
        return R.ok();
    }

    //根据章节id查询
    @GetMapping("getChapterInfo/{chapterId}")
    public R getChapterInfo(@PathVariable String chapterId) {
        EduChapter eduChapter = chapterService.getById(chapterId);
        return R.ok(eduChapter);
    }

    //修改章节
    @PostMapping("updateChapter")
    public R updateChapter(@RequestBody EduChapter eduChapter) {
        chapterService.updateById(eduChapter);
        return R.ok();
    }

    //删除的方法
    @DeleteMapping("{chapterId}")
    public R deleteChapter(@PathVariable String chapterId) {
        boolean flag = chapterService.deleteChapter(chapterId);
        if(flag) {
            return R.ok("删除成功");
        } else {
            return R.error("删除失败");
        }

    }

}

