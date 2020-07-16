package com.zxq.eduService.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Author zxq
 * @Date 2020/6/17 9:22
 * @Version 1.0
 */
@Data
public class Student {

    /**
     * 学号
     * */
    @ExcelProperty(value = "学生学号",index = 0)
    private Long sno;

    /**
     * 姓名
     * */
    @ExcelProperty(value = "学生姓名",index = 1)
    private String name;

}
