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
        articles.setTitle(desc);

        return new Response<>(RetCodeEnum.SUCCESS, articlesService.allArticles(articles, page));
    }

    @PostMapping("/add")
    public Response<Articles> store(
            @RequestParam String titile,
            @RequestParam String desc,
            @RequestParam String content,
            @RequestParam("0") String category_id
    ) {
        Articles articles = new Articles();
        articles.setTitle(titile);

        articlesService.addArticles(articles);
        return new Response<>(RetCodeEnum.SUCCESS, articles);
    }
}
