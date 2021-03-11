package com.yunchen.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableAutoConfiguration
@PropertySource(value = "classpath:common-${spring.profiles.active}.properties")
@ComponentScan(basePackages = {"com.yunchen.api", "com.yunchen.common"})
@MapperScan({"com.yunchen.common.mapper"})
public class AppApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }
}
