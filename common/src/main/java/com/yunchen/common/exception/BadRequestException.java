package com.yunchen.common.exception;

import javax.servlet.ServletException;
import java.io.Serializable;

public class BadRequestException extends RuntimeException{
    private static final long serialVersionUID = -2030894709415253758L;

    public BadRequestException() {
        super("bad request");
    }

    public BadRequestException(String message) {
        super(message);
    }
}
