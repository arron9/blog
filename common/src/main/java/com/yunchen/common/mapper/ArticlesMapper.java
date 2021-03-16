package com.yunchen.common.mapper;

import com.yunchen.common.model.Articles;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ArticlesMapper extends Mapper<Articles> {
    List<Articles> listArticles(Articles articles);
}