package com.zxq.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zxq.eduservice.entity.EduSubject;
import com.zxq.eduservice.entity.subject.OneSubject;
import com.zxq.eduservice.entity.excel.SubjectData;
import com.zxq.eduservice.entity.subject.TwoSubject;
import com.zxq.eduservice.listener.ExcelReadListener;
import com.zxq.eduservice.mapper.EduSubjectMapper;
import com.zxq.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author zxq
 * @since 2020-06-17
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Autowired
    private EduSubjectMapper subjectMapper;

    @Override
    public void readExcel(MultipartFile file, EduSubjectService subjectService)  {
        try {
            EasyExcel.read(file.getInputStream(), SubjectData.class,new ExcelReadListener(subjectService)).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OneSubject> getData() {

        List<OneSubject> oneSubjectList = new ArrayList<>();
        QueryWrapper<EduSubject> wrapperOne = new QueryWrapper<>();
        //获取所有一级分类,并存入oneSubjectList
        wrapperOne.eq("parent_id","0");
        List<EduSubject> listOne = subjectMapper.selectList(wrapperOne);
        Iterator<EduSubject> iterator = listOne.iterator();
        while(iterator.hasNext()){
            EduSubject subjectOne = iterator.next();
            OneSubject oneSubject = new OneSubject();
            oneSubject.setId(subjectOne.getId());
            oneSubject.setTitle(subjectOne.getTitle());
            oneSubjectList.add(oneSubject);
        }
        //根据一级分类的id查询二级分类，并存入相应的一级分类

        for (int i = 0; i < oneSubjectList.size(); i++) {
            QueryWrapper<EduSubject> wrapperTwo = new QueryWrapper<>();
            OneSubject oneSubject = oneSubjectList.get(i);
            // 查询一级分类对应的二级分类
            wrapperTwo.eq("parent_id",oneSubject.getId());
            Iterator<EduSubject> iteratorTwo = subjectMapper.selectList(wrapperTwo).iterator();
            ArrayList<TwoSubject> twoSubjectList = new ArrayList<>();
            // 将二级分类，存入返回数据的list中
            while(iteratorTwo.hasNext()){
                EduSubject subjectTwo = iteratorTwo.next();
                TwoSubject twoSubject = new TwoSubject();
                twoSubject.setId(subjectTwo.getId());
                twoSubject.setTitle(subjectTwo.getTitle());
                twoSubjectList.add(twoSubject);
            }
            // 将二级分类的list存入一级分类
            oneSubject.setChildren(twoSubjectList);
        }

        // 返回封装的数据

        return oneSubjectList;
    }
}
