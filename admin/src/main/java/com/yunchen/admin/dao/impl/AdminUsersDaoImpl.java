package com.yunchen.admin.dao.impl;

import com.yunchen.admin.dao.AdminUsersDao;
import com.yunchen.common.mapper.AdminUsersMapper;
import com.yunchen.common.model.AdminUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

@Repository
public class AdminUsersDaoImpl implements AdminUsersDao {

    @Autowired
    AdminUsersMapper adminUsersMapper;

    @Override
    public BaseMapper<AdminUsers> getBaseMapper() {
        return adminUsersMapper;
    }

}
