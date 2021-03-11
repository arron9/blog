package com.yunchen.api.server.impl;

import com.github.pagehelper.PageInfo;
import com.yunchen.api.dao.AuthorsDao;
import com.yunchen.api.server.AuthorsServer;
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
        return authorsDao.selectAll(new PageQuery(page, PageQuery.DEFAULT_PAGE_SIZE));
    }
}
