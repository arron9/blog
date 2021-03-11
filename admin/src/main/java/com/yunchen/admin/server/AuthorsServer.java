package com.yunchen.admin.server;

import com.github.pagehelper.PageInfo;
import com.yunchen.common.model.Authors;

public interface AuthorsServer {
    PageInfo<Authors> allAuthors(Integer page);
}
