package com.zxq.eduservice.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Author zxq
 * @Date 2020/6/17 14:27
 * @Version 1.0
 */
@Data
public class SubjectData {

    @ExcelProperty(index = 0)
    private String oneSubjectName;


    @ExcelProperty(index = 1)
    private String twoSubjectName;
}
