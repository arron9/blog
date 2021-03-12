package com.yunchen.admin.server;

import com.yunchen.common.model.AdminUsers;

import java.util.List;

public interface AdminUsersServer {
    AdminUsers adminUserInfo(String username);
    List<AdminUsers> allAdminUsers();
}
