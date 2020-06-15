package com.zxq.commonutils;

/**
 * @author zxq
 */
public interface  ReturnCode{

    /**
     * 成功
     * */
    public static final int SUCCESS = 200;

    /**
     *  失败
     * */
    public static final int FAIL = 201;

    /**
     *  用户名或密码错误
     * */
    public static final int LOGINERROR = 202;

    /**
     *  权限不足  
     * */
    public static final int ACCESSERROR = 203;

    /**
     * 远程调用失败
     * */
    public static final int REMOTEERROR = 204;

    /**
     * 重复操作
     * */
    public static final int REPERROR = 205;

    /**
     * 服务器崩溃
     * */
    public static final int SERVEERR0R = 206;
    /**
     * 异常 
     * */
    public static final int ERROR = 207;
}
