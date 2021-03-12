package com.yunchen.admin.server.impl;

import com.yunchen.admin.dao.AdminUsersDao;
import com.yunchen.admin.server.AdminUsersServer;
import com.yunchen.common.model.AdminUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUsersServerImpl implements AdminUsersServer {

    @Autowired
    private AdminUsersDao adminUsersDao;

    @Override
    public AdminUsers adminUserInfo(String username) {
        AdminUsers adminUsers = new AdminUsers();
        adminUsers.setUseranme(username);

        return adminUsersDao.selectOne(adminUsers);
    }

    @Override
    public List<AdminUsers> allAdminUsers() {
        return adminUsersDao.selectAll();
    }
}
