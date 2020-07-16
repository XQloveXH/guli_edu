package com.zxq.eduservice.entity.subject;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zxq
 * @Date 2020/6/17 16:45
 * @Version 1.0
 */
@Data
public class OneSubject {

    private String id;

    private String title;

    private List<TwoSubject> children = new ArrayList<>();
}
