package com.yunchen.admin.controller;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    public String index() {
        List<String> data = Lists.newArrayList("hello", "blog");
        log.info("dash wgit");
        return data.toString();
    }
}
