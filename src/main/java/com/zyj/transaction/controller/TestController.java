package com.zyj.transaction.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author zhongyj
 * @since 2021-01-11 15:21
 */
@Controller
public class TestController {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Transactional(rollbackFor = Exception.class)
    public void test() {
        jdbcTemplate.update("insert into person(name, age) values (?, ?)", "tom", 20);
        int i = 1 / 0;
    }

}
