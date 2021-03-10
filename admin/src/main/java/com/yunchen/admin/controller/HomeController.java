package com.yunchen.admin.controller;

import com.google.common.collect.Lists;
import com.yunchen.admin.mapper.AuthorsMapper;
import com.yunchen.admin.model.Authors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.awt.print.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
public class HomeController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public AuthorsMapper authorsMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/")
    public String index() {
        List<String> data = Lists.newArrayList("hello", "blog");
        //List<Authors> info =  authorsMapper.selectAll();
        List<Authors> books = jdbcTemplate.query("select * from book", new RowMapper<Authors>(){
            @Override
            public Authors mapRow(ResultSet rs, int i) throws SQLException {
                Authors authors = new Authors();
                authors.setBookId(rs.getInt("book_id"));
                authors.setAuthor(rs.getString("author"));
                authors.setTitle(rs.getString("title"));
                return authors;
            }
        });
        log.info("book:" + books.toString());
        return books.toString();
    }
}
