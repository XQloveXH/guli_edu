package com.zxq.eduservice.controller;




import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxq.commonutils.R;
import com.zxq.eduservice.entity.EduTeacher;
import com.zxq.eduservice.entity.vo.TeacherQuery;
import com.zxq.eduservice.service.EduTeacherService;
import com.zxq.servicebase.exception.GuliException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author zxq
 * @since 2020-06-15
 */
@RestController
@RequestMapping("/edu/teacher")
@CrossOrigin
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    /**
     * 查询讲师表中所有数据
     */
    @GetMapping("getlist")
    public R getList(){
        return R.ok(eduTeacherService.list(null));
    }

    /**
     * 根据id删除指定讲师
     * */
    @DeleteMapping("{id}")
    public R deleteById(@PathVariable("id") String id){
        boolean flag = eduTeacherService.removeById(id);
        if(flag){
            return R.ok();
        }else{
            return R.error("删除失败");
        }
    }

    /**
     * 新增讲师
     * */
    @PostMapping("/add")
    public R add(@RequestBody EduTeacher eduTeacher){

        return R.ok(eduTeacherService.save(eduTeacher));
    }
    /**
     * 根据id修改讲师
     * */
    @PutMapping("")
    public R update(@RequestBody EduTeacher eduTeacher){

        return R.ok(eduTeacherService.updateById(eduTeacher));
    }
    /**
     * 根据id查询讲师
     * */
    @GetMapping("{id}")
    public R getById(@PathVariable("id") String id){
        return R.ok(eduTeacherService.getById(new EduTeacher().setId(id)));
    }
    /**
     * 分页查询--无条件
     * */
    @GetMapping("selectpage/{current}/{size}")
    public R selectPage(@PathVariable("current") long current,
                        @PathVariable(("size")) long size){

        return R.ok(eduTeacherService.selectPage(current, size));
    }

    /**
     * 分页查询--有条件
     * */
    @PostMapping("choosepage/{current}/{size}")
    public R choosePage(@PathVariable("current") long current,
                        @PathVariable(("size")) long size,
                        @RequestBody TeacherQuery teacherQuery){

        return R.ok(eduTeacherService.choosePage(current, size, teacherQuery));
    }





}

