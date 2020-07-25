package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author:Administrator
 * 使用junit单元测试测试我们的配置
 */
public class AccountServiceTest {
    @Test
    public void testFindAll(){
        //1.获取容器
        ApplicationContext ac =new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        //3.执行方法
        List<Account> accountList = as.findAllAccount();
        for (Account account : accountList) {
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne(){
        //1.获取容器
        ApplicationContext ac =new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        //3.执行方法
        Account account= as.findAccountById(1);
        System.out.println(account);
    }
    @Test
    public void testSave(){
        //1.获取容器
        ApplicationContext ac =new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        //3.执行方法
        Account account= new Account();
        account.setName("xu");
        account.setMoney(100.0);
        account.setUid(2);
        as.saveAccount(account);
    }
    @Test
    public void testUpdate(){
        //1.获取容器
        ApplicationContext ac =new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        //3.执行方法
        Account account= as.findAccountById(1);
        account.setName("heinihao");
        as.updateAccount(account);
    }
    @Test
    public void testDelete(){
        //1.获取容器
        ApplicationContext ac =new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        //3.执行方法
        as.deleteAccount(1);
    }
}
