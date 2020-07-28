package com.itheima.jdbcTemplate;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * description:JdbcTemplate的基于Dao的CRUD操作
 *
 * @author xuqiangsheng
 * @date 2020/7/28 8:07
 */
public class JdbcTemplateDemo4 {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        IAccountDao accountDao = (IAccountDao)ac.getBean("accountDao");
        //3.执行查询一个操作
        Account account = accountDao.findAccountById(5);
        System.out.println(account);
        account.setMoney(5000D);
        //执行更新操作
        accountDao.updateAccount(account);

    }
}
