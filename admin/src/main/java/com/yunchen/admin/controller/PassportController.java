package com.yunchen.admin.controller;

import com.yunchen.admin.service.AdminUsersService;
import com.yunchen.common.Consts.RetCodeEnum;
import com.yunchen.common.annotaion.AuthLogin;
import com.yunchen.common.model.AdminUsers;
import com.yunchen.common.model.Response;
import com.yunchen.common.utils.RandomString;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Api(tags = "登录注册")
@RestController
@RequestMapping("/admin/v1/passport")
public class PassportController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AdminUsersService adminUsersServer;

    @PostMapping("/login")
    @ApiOperation("登录")
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

        String token = RandomString.random(32);
        adminUsers.setToken(token);
        Date date = new Date(System.currentTimeMillis() + 3*24*60*60*1000);
        adminUsers.setTokenExpire(date);
        adminUsersServer.updateAdminUsers(adminUsers);

        return new Response<>(RetCodeEnum.SUCCESS, token);
    }

    @PostMapping("/reg")
    @ApiOperation("注册")
    @AuthLogin
    public Response<AdminUsers> register(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String confirmPassword
    ) {
        if (!confirmPassword.equals(password)) {
            RetCodeEnum.FAIL.setMsg("the two password don`t match");
            return  new Response<>(RetCodeEnum.FAIL);
        }

        AdminUsers adminUsers = adminUsersServer.adminUserInfo(username);
        if (adminUsers != null) {
            return new Response<>(RetCodeEnum.REGISTERED);
        }

        AdminUsers newAdminUser = new AdminUsers();
        newAdminUser.setUsername(username);
        newAdminUser.setPassword(password);
        newAdminUser.setToken(" ");
        newAdminUser.setTokenExpire(new Date());
        newAdminUser.setCreatedAt(new Date());
        newAdminUser.setUpdatedAt(new Date());

        int id = adminUsersServer.insert(newAdminUser);
        if (id <= 0) {
            RetCodeEnum.FAIL.setMsg("insert user error");
            return new Response<>(RetCodeEnum.FAIL);
        }

        newAdminUser.setId(id);
       return new Response<>(RetCodeEnum.SUCCESS, newAdminUser);
    }
}
