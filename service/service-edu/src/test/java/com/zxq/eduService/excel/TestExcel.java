package com.zxq.eduService.excel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zxq
 * @Date 2020/6/17 9:24
 * @Version 1.0
 */
public class TestExcel {
    public static void main(String[] args) {
        // 设置写出文件的路径
        String filePath = "G:\\idea2020.1.1\\project\\myself\\guli_edu\\service\\service-edu\\src\\main\\resources\\student.xlsx";
        // 调用EasyExcel方法将内容写入指定文件
//        EasyExcel.write(filePath,Student.class)
//                .sheet("学生信息表")
//                .doWrite(getStudentList(11));

        // 读操作

        EasyExcel.read(filePath,Student.class,new ExcelReaderListener()).sheet().doRead();

    }
    public static List<Student> getStudentList(Integer num){
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Student student = new Student();
            student.setName("朱小强"+(i+1));
            student.setSno(1802022120L+i);
            studentList.add(student);
        }
        return studentList;
    }

}
