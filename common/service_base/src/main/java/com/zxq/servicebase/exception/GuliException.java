package com.zxq.servicebase.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author zxq
 * @Date 2020/6/15 19:29
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuliException extends RuntimeException{
    /**
     * 状态码
     * */
    private Integer code;
    /**
     * 异常信息
     * */
    private String message;
}
