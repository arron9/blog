package com.yunchen.common.model;

import com.yunchen.common.Consts.RetCodeEnum;

public class Response<T> {
    private int code;
    private String msg;
    private T data;

    public Response(int code, String msg, T data) {
        this.code =  code;
        this.msg =  msg;
        this.data =  data;
    }

    public Response(RetCodeEnum retCodeEnum) {
        this.code =  retCodeEnum.getCode();
        this.msg =  retCodeEnum.getMsg();
    }

    public Response(RetCodeEnum retCodeEnum, T data) {
        this.code =  retCodeEnum.getCode();
        this.msg =  retCodeEnum.getMsg();
        this.data =  data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
