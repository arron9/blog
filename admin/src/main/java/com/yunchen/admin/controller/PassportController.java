package com.yunchen.admin.controller;

import com.yunchen.admin.server.AdminUsersServer;
import com.yunchen.common.Consts.RetCodeEnum;
import com.yunchen.common.model.AdminUsers;
import com.yunchen.common.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/v1/passport")
public class PassportController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AdminUsersServer adminUsersServer;

    @PostMapping("/login")
    public Response login(
            @RequestParam String username,
            @RequestParam String password
    ) {

        AdminUsers adminUsers = adminUsersServer.adminUserInfo(username);
        if (adminUsers == null) {
            return new Response<>(RetCodeEnum.NO_REGISTER);
        }

        return new Response<>(RetCodeEnum.SUCCESS);
    }

    @PostMapping("/reg")
    public Response register(
            @RequestParam String username,
            @RequestParam String password
    ) {

        return new Response<>(RetCodeEnum.SUCCESS);
    }
}
