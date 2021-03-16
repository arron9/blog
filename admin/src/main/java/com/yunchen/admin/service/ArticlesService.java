package com.yunchen.admin.service;

import com.github.pagehelper.PageInfo;
import com.yunchen.common.beans.PageQuery;
import com.yunchen.common.model.Articles;
import com.yunchen.common.service.BaseService;

public interface ArticlesService extends BaseService<Articles, Integer> {
    PageInfo<Articles> allArticles(Articles articles, PageQuery pageQuery);
}
