package com.yunchen.admin.service;

import com.github.pagehelper.PageInfo;
import com.yunchen.common.model.Articles;
import com.yunchen.common.service.BaseService;

import java.util.List;

public interface ArticlesService extends BaseService<Articles, Integer> {
    PageInfo<Articles> allArticles(Articles articles, int page);
    Articles addArticles(Articles articles);
    int updateArticles(Articles articles);
}
