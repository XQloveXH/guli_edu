package com.zxq.eduService.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

/**
 * @Author zxq
 * @Date 2020/6/17 9:49
 * @Version 1.0
 */
public class ExcelReaderListener  extends AnalysisEventListener<Student> {

    //读取表头
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头:"+headMap);
    }

    //一行一行读取内容
    @Override
    public void invoke(Student student, AnalysisContext analysisContext) {
        System.out.println("*****"+student);
    }

    //读取完成后的操作
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
