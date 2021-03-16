package com.yunchen.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yunchen.admin.service.ArticlesService;
import com.yunchen.common.mapper.ArticlesMapper;
import com.yunchen.common.model.Articles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.orderbyhelper.OrderByHelper;

@Service
public class ArticlesServiceImpl implements ArticlesService {

    @Autowired
    ArticlesMapper articlesMapper;

    @Override
    public BaseMapper<Articles> getBaseMapper() {
        return articlesMapper;
    }

    @Override
    public PageInfo<Articles> allArticles(Articles articles, int page) {
        OrderByHelper.orderBy("pulished_at desc");
        PageHelper.startPage(page, 2);

        PageInfo<Articles> pageInfo = new PageInfo<>(articlesMapper.listArticles(articles));
        return pageInfo;
    }

}
