package com.zxq.eduservice.controller;


import com.zxq.commonutils.R;
import com.zxq.eduservice.entity.EduVideo;
import com.zxq.eduservice.service.EduVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author zxq
 * @since 2020-07-15
 */
@RestController
@RequestMapping("/eduservice/video")
@CrossOrigin
public class EduVideoController {
    @Autowired
    private EduVideoService videoService;

    //添加小节
    @PostMapping("addVideo")
    public R addVideo(@RequestBody EduVideo eduVideo) {
        videoService.save(eduVideo);
        return R.ok();
    }

    //删除小节
    // TODO 后面这个方法需要完善：删除小节时候，同时把里面视频删除
    @DeleteMapping("{id}")
    public R deleteVideo(@PathVariable String id) {
        videoService.removeById(id);
        return R.ok();
    }

    //修改小节
    @PutMapping("updateVideo")
    public R updateVideo(@RequestBody EduVideo eduVideo){
        boolean update = videoService.updateById(eduVideo);

        if (!update){
            return R.error("修改失败");
        }
        return R.ok();
    }

}

