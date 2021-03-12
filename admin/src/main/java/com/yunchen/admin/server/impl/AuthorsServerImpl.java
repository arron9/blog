package com.yunchen.admin.server.impl;

import com.github.pagehelper.PageInfo;
import com.yunchen.admin.dao.AuthorsDao;
import com.yunchen.admin.server.AuthorsServer;
import com.yunchen.common.beans.PageQuery;
import com.yunchen.common.model.Authors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorsServerImpl implements AuthorsServer {

    @Autowired
    private AuthorsDao authorsDao;

    @Override
    public PageInfo<Authors> allAuthors(Integer page) {
        return authorsDao.selectAll(new PageQuery(page, 1));
    }
}
