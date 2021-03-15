package com.yunchen.admin.service.impl;

import com.yunchen.admin.service.AdminUsersService;
import com.yunchen.common.mapper.AdminUsersMapper;
import com.yunchen.common.model.AdminUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Service
public class AdminUsersServiceImpl implements AdminUsersService {

    @Autowired
    private AdminUsersMapper adminUsersMapper;

    @Override
    public AdminUsers adminUserInfo(String username) {
        AdminUsers adminUsers = new AdminUsers();
        adminUsers.setUsername(username);

        return selectOne(adminUsers);
    }

    @Override
    public List<AdminUsers> allAdminUsers() {
        return selectAll();
    }

    @Override
    public int updateAdminUsers(AdminUsers adminUsers) {
        return updateByPrimaryKey(adminUsers);
    }

    @Override
    public BaseMapper<AdminUsers> getBaseMapper() {
        return adminUsersMapper;
    }
}
