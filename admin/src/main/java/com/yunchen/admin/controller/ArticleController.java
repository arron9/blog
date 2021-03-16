package com.yunchen.admin.controller;

import com.github.pagehelper.PageInfo;
import com.yunchen.admin.service.ArticlesService;
import com.yunchen.common.Consts.RetCodeEnum;
import com.yunchen.common.model.Articles;
import com.yunchen.common.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


/**
 * @author jiangsx
 */
@RestController
@RequestMapping("/admin/v1/article")
public class ArticleController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ArticlesService articlesService;

    @RequestMapping("/index")
    public Response<PageInfo<Articles>> all(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String desc,
            @RequestParam(defaultValue = "1") int page
    ) {
        Articles articles = new Articles();
        articles.setTitle(title);
        articles.setDescription(desc);

        return new Response<>(RetCodeEnum.SUCCESS, articlesService.allArticles(articles, page));
    }

    @PostMapping("/add")
    public Response<Articles> store(
            @RequestParam(defaultValue = "0") int id,
            @RequestParam String title,
            @RequestParam String desc,
            @RequestParam String content,
            @RequestParam(defaultValue = "0") int category_id
    ) {
        Articles articles = new Articles();
        articles.setId(id);
        Articles articlesRecord = articlesService.selectOne(articles);
        Date nowDate = new Date();
        if (articlesRecord != null) {
            articlesRecord.setTitle(title);
            articlesRecord.setDescription(desc);
            articlesRecord.setContent(content);
            articlesService.updateByPrimaryKey(articlesRecord);

            return new Response<>(RetCodeEnum.SUCCESS, articlesRecord);
        } else {
            articles.setTitle(title);
            articles.setDescription(desc);
            articles.setContent(content);
            articles.setCategoryId(category_id);
            articles.setCreatedAt(nowDate);
            articles.setUpdatedAt(nowDate);
            articles.setPulishedAt(nowDate);
            articles.setAuthorsId(0);
            articles.setId(0);
            articlesService.insert(articles);

            return new Response<>(RetCodeEnum.SUCCESS, articles);
        }
    }
}
