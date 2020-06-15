package com.zxq.commonutils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一结果返回类
 * @author zxq
 * */
@Data
@NoArgsConstructor
public class R {

    /**
     *  是否成功
     * */
    private boolean success;

    /**
     * 返回码
     * */
    private Integer code;

    /**
     * 返回信息
     * */
    private String message;

    /**
     * 返回数据
     * */
    private Object data;


    public R(Integer code, String message, boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
    }

    public R(Integer code, String message, boolean success, Object data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static R ok() {
        return new R(ReturnCode.SUCCESS,"操作成功",true,null);
    }

    public static R not_ok(String message) {
        return new R(ReturnCode.FAIL,message,false,null);
    }

    public static R ok(Object data) {
        return new R(ReturnCode.SUCCESS,"操作成功",true,data);
    }

    public static R error(String message) {
        return new R(ReturnCode.ERROR,message,false,null);
    }

    public static R error(int code, String message) {
        return new R(code,message,false,null);
    }
}
