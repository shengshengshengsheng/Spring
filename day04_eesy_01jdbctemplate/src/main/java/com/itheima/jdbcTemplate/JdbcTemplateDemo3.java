package com.itheima.jdbcTemplate;

import com.itheima.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * description:JdbcTemplate的CRUD操作
 *
 * @author xuqiangsheng
 * @date 2020/7/28 8:07
 */
public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        JdbcTemplate jt = (JdbcTemplate)ac.getBean("jdbcTemplate");
        //3.执行操作
        jt.execute("insert into account(uid, name, money) values (6,'dd',1000)");
       //保存
        jt.update("insert into account(uid, name, money) values (?,?,?)",7,"dd",100);
        //更新
        jt.update("update account set uid=?,name=?,money=? where id=?",7,"dd",100,5);
        //删除
        jt.update("delete from account where id=?",5);
        //查询所有
        List<Account> accountList = jt.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(accountList.size());
        //查询一个
        List<Account> accountList2 = jt.query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class),6);
        Account account = accountList2.size()>0?accountList2.get(0):null;
        System.out.println(account);
        //查询返回一行一列(使用聚合函数但是不加group by子句)
        Long count = jt.queryForObject("select count(*) from account where id>?", Long.class, 5);
        System.out.println(count);
    }
}
