package com.yunchen.admin.service;

import com.yunchen.common.model.AdminUsers;
import com.yunchen.common.service.BaseService;

import java.util.List;

public interface AdminUsersService extends BaseService<AdminUsers, Integer> {
    AdminUsers adminUserInfo(String username);

    List<AdminUsers> allAdminUsers();

    int updateAdminUsers(AdminUsers adminUsers);
}
