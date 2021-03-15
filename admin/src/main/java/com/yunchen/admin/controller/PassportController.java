package com.yunchen.admin.controller;

import com.yunchen.admin.service.AdminUsersService;
import com.yunchen.common.Consts.RetCodeEnum;
import com.yunchen.common.annotaion.AuthLogin;
import com.yunchen.common.model.AdminUsers;
import com.yunchen.common.model.Response;
import com.yunchen.common.utils.RandomString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/admin/v1/passport")
public class PassportController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AdminUsersService adminUsersServer;

    @PostMapping("/login")
    public Response login(
            @RequestParam String username,
            @RequestParam String password
    ) {

        AdminUsers adminUsers = adminUsersServer.adminUserInfo(username);
        if (adminUsers == null) {
            return new Response<>(RetCodeEnum.NO_REGISTER);
        }

        if (!adminUsers.getPassword().equals(password)) {
            return new Response<>(RetCodeEnum.ERROR_PASSWORD);
        }

        adminUsers.setToken(RandomString.random(32));
        Date date = new Date(System.currentTimeMillis() + 3*24*60*60*1000);
        adminUsers.setTokenExpire(date);
        adminUsersServer.updateAdminUsers(adminUsers);

        return new Response<>(RetCodeEnum.SUCCESS);
    }

    @PostMapping("/reg")
    @AuthLogin
    public Response register(
            @RequestParam String username,
            @RequestParam String password
    ) {

       return new Response<>(RetCodeEnum.SUCCESS);
    }
}
