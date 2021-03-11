package com.yunchen.common.Consts;

public enum RetCodeEnum {
    SUCCESS(200, "success"),
    FAIL(-1, "request fail");

    private int code;
    private String msg;

    private RetCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
