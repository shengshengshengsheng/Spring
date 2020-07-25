package com.itheima.test;

import com.itheima.config.JdbcConfig;
import com.itheima.config.SpringConfiguration;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author:Administrator
 * 使用junit单元测试测试我们的配置
 * Spring整合Junit的配置
 *      1.导入Spring整合junit的jar包(坐标)
 *      2.使用Junit提供的一个注解把原有的main方法替换了，替换成Spring提供的@Runwith
 *      3.告知Spring的运行器，Spring和IOC创建是基于xml还是基于注解的，并且说明位置
 *          @ContextConfiguration
 *              location:指定xml文件的位置，加上classpath关键字表示在类路径下
 *              classes：指定注解类所在的位置
 *      当我们使用Spring 5.x版本的时候，要求junit的jar包必须是4.12以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
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
