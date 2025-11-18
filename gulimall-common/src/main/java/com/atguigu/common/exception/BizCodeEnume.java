package com.atguigu.common.exception;

/**
 * 枚举就是一个私有构造器
 */
public enum BizCodeEnume {
    UNKNOW_EXCEPTION(1000, "系统未知异常"),
    VAILD_EXCEPTION(10001, "参数格式校验失败");

    private int code;
    private String msg;

    BizCodeEnume(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
