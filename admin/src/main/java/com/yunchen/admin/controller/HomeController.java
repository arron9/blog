package com.yunchen.admin.controller;

import com.yunchen.common.annotaion.AuthedAccount;
import com.yunchen.common.mapper.AuthorsMapper;
import com.yunchen.common.model.Authors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public AuthorsMapper authorsMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/")
    public Authors index(@AuthedAccount Authors authors) {
        //List<Authors> data = Lists.newArrayList("hello", "blog");
        //List<Authors> data =  authorsMapper.selectAll();
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
        return authors;
    }
}
