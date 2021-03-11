package com.yunchen.api.controller.dao.impl;

import com.yunchen.api.dao.AuthorsDao;
import com.yunchen.common.mapper.AuthorsMapper;
import com.yunchen.common.model.Authors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

@Repository
public class AuthorsDaoImpl implements AuthorsDao {

    @Autowired
    public AuthorsMapper authorsMapper;

    @Override
    public BaseMapper<Authors> getBaseMapper() {
        return authorsMapper;
    }
}
