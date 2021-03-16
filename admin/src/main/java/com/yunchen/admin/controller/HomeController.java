package com.yunchen.admin.controller;

import com.github.pagehelper.PageInfo;
import com.yunchen.admin.service.AuthorsService;
import com.yunchen.common.Consts.RetCodeEnum;
import com.yunchen.common.annotaion.AuthedAccount;
import com.yunchen.common.model.Authors;
import com.yunchen.common.model.Response;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "首页")
@RestController
@RequestMapping("/admin/v1/home")
public class HomeController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AuthorsService authorsServer;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/index")
    public Response<PageInfo<Authors>> index(Integer page, @AuthedAccount Authors authors) {
        /*List<Authors> books = jdbcTemplate.query("select * from book", new RowMapper<Authors>(){
            @Override
            public Authors mapRow(ResultSet rs, int i) throws SQLException {
                Authors authors = new Authors();
                authors.setBookId(rs.getInt("book_id"));
                authors.setAuthor(rs.getString("author"));
                authors.setTitle(rs.getString("title"));
                return authors;
            }
        });*/

        PageInfo<Authors> authors2 = authorsServer.allAuthors(page);
        return new Response<>(RetCodeEnum.SUCCESS, authors2);
    }
}
