package com.yunchen.common.exception;

import com.yunchen.common.Consts.RetCodeEnum;
import com.yunchen.common.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class handleException{

    @ExceptionHandler(BadRequestException.class)
    public Response BadRequestException(BadRequestException e) {
        return new Response<>(RetCodeEnum.BADREQUEST, e.getMessage());
    }
}
