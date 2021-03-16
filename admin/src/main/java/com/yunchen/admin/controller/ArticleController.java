package com.yunchen.admin.controller;

import com.github.pagehelper.PageInfo;
import com.yunchen.admin.service.ArticlesService;
import com.yunchen.common.Consts.RetCodeEnum;
import com.yunchen.common.beans.PageQuery;
import com.yunchen.common.model.Articles;
import com.yunchen.common.model.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.google.common.base.Preconditions;

import java.util.Date;
import java.util.List;


/**
 * @author jiangsx
 */
@Api(tags = "文章管理")
@RestController
@RequestMapping("/admin/v1/article")
public class ArticleController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ArticlesService articlesService;

    @ApiOperation("列表查询")
    @RequestMapping("/index")
    public Response<PageInfo<Articles>> all(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String desc,
            @RequestParam(defaultValue = "1") int page
    ) {

        Articles articles = new Articles();
        articles.setTitle(title);
        articles.setDescription(desc);

        PageQuery pageQuery = new PageQuery(page);
        return new Response<>(RetCodeEnum.SUCCESS, articlesService.allArticles(articles, pageQuery));
    }

    @ApiOperation("新增或编辑文章")
    @PostMapping("/add")
    public Response<Articles> store(
            @RequestParam(defaultValue = "0") int id,
            @RequestParam String title,
            @RequestParam String desc,
            @RequestParam String content,
            @RequestParam(defaultValue = "0") int category_id
    ) {
        Preconditions.checkArgument(title.length() < 3, "标题长度必须大于3");

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
