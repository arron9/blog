package com.yunchen.api.service.impl;

import com.github.pagehelper.PageInfo;
import com.yunchen.api.service.AuthorsService;
import com.yunchen.common.beans.PageQuery;
import com.yunchen.common.mapper.AuthorsMapper;
import com.yunchen.common.model.Authors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.BaseMapper;

@Service
public class AuthorsServiceImpl implements AuthorsService {

    @Autowired
    private AuthorsMapper authorsMapper;

    @Override
    public PageInfo<Authors> allAuthors(Integer page) {
        return selectAll(new PageQuery(page, PageQuery.DEFAULT_PAGE_SIZE));
    }

    @Override
    public BaseMapper<Authors> getBaseMapper() {
        return authorsMapper;
    }
}
