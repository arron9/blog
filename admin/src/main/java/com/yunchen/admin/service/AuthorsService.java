package com.yunchen.admin.service;

import com.github.pagehelper.PageInfo;
import com.yunchen.common.model.Authors;
import com.yunchen.common.service.BaseService;

public interface AuthorsService extends BaseService<Authors, Integer> {
    PageInfo<Authors> allAuthors(Integer page);
}
