package com.itheima.utils;

import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author:Administrator
 * 和事务管理相关的工具类,它包含了开启事务，提交事务，回滚事务和释放资源
 */
@Component("txManager")
@Aspect
public class TransactionManager {
    @Autowired
    private ConnectionUtils connectionUtils;
    @Pointcut("execution(* com.itheima.service.impl.*.*(..))")
    private void pt1(){}

    /**
     * 开启事务
     */
    @Before("pt1()")
    public void beginTransaction(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    /**
     * 提交事务
     */
    @AfterReturning("pt1()")
    public void commit(){
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    /**
     * 回滚事务
     */
    @AfterThrowing("pt1()")
    public void rollback(){
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    /**
     * 释放连接
     */
    @After("pt1()")
    public void release(){
        try {
            //还回连接池
            connectionUtils.getThreadConnection().close();
            //把连接和线程解绑
            connectionUtils.removeConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
