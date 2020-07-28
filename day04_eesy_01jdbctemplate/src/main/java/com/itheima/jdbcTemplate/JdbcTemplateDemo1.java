package com.itheima.jdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * description:JdbcTemplate的最新用法
 *
 * @author xuqiangsheng
 * @date 2020/7/28 8:07
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //准备数据源,Spring的内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/eesy?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=GMT%2B8&useSSL=false");
        ds.setUsername("root");
        ds.setPassword("123456");
        //1.创建JdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
        //2.执行操作
        jdbcTemplate.execute("insert into account(uid, name, money) values (5,'cc',1000)");
    }
}
