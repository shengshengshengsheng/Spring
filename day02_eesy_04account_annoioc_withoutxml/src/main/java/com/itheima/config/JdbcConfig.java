package com.itheima.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

/**
 * @author:Administrator
 * @date:2020/7/25
 * @description:
 */
@Configuration
public class JdbcConfig {
    private String driver;
    private String url;
    private String user;
    private String password;
    /**
     * 用于创建一个QueryRunner对象
     * @param dataSource
     * @return
     */
    @Bean(name = "runner")
    @Scope(value = "prototype")
    public QueryRunner createQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    @Bean(name = "dataSource")
    public DataSource createDataSource(){
        try{
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass("com.mysql.cj.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/eesy?autoReconnect=true&useSSL=false&serverTimezone=UTC");
            ds.setUser("root");
            ds.setPassword("123456");
            return ds;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
