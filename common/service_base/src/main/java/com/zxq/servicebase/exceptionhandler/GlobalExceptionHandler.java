package com.zxq.servicebase.exceptionhandler;

import com.zxq.commonutils.R;
import com.zxq.servicebase.exception.GuliException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author zxq
 * @Date 2020/6/15 19:14
 * @Version 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        return R.error(500,"服务器发生错误");
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R error(ArithmeticException e){
        return R.error(500,"服务器发生算数异常");
    }

    @ExceptionHandler(GuliException.class)
    @ResponseBody
    public R error(GuliException e){
        return R.error(e.getCode(),e.getMessage());
    }


}
