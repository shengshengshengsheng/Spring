package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author:Administrator
 * 使用junit单元测试测试我们的配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="classpath:bean.xml" )
public class AccountServiceTest {
    @Autowired
    private IAccountService as;
    @Test
    public void testFindAll(){
        //3.执行方法
        List<Account> accountList = as.findAllAccount();
        for (Account account : accountList) {
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne(){
        //3.执行方法
        Account account= as.findAccountById(1);
        System.out.println(account);
    }
    @Test
    public void testSave(){
        //3.执行方法
        Account account= new Account();
        account.setName("xu");
        account.setMoney(100.0);
        account.setUid(2);
        as.saveAccount(account);
    }
    @Test
    public void testUpdate(){
        //3.执行方法
        Account account= as.findAccountById(1);
        account.setName("heinihao");
        as.updateAccount(account);
    }
    @Test
    public void testDelete(){
        //3.执行方法
        as.deleteAccount(1);
    }
}
