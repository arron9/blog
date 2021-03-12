package com.yunchen.admin.controller;

import com.yunchen.common.Consts.RetCodeEnum;
import com.yunchen.common.annotaion.AuthLogin;
import com.yunchen.common.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/v1/passport")
public class PassportController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/login")
    public Response login(@RequestParam String username,
                          @RequestParam String password) {

        return new Response<>(RetCodeEnum.SUCCESS);
    }

    @PostMapping("/reg")
    public Response register(@RequestParam String username,
                          @RequestParam String password) {

        return new Response<>(RetCodeEnum.SUCCESS);
    }
}
