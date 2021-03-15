package com.yunchen.common.Consts;

public enum RetCodeEnum {
    SUCCESS(0, "success"),
    FAIL(-1, "request fail"),
    BADREQUEST(400, "bad request"),

    NO_REGISTER(10001, "no register"),
    ERROR_PASSWORD(10002, "password input error"),
    REGISTERED(10003, "this useranme has already registered");

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
