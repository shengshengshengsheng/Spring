package com.itheima.ui;

import com.itheima.dao.IAccountDao;
import com.itheima.service.impl.AccountServiceImpl;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author:Administrator
 * 模拟一个表现层用于调用业务层
 */
public class Client {
    /**
     *  @param args
     */
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        IAccountService as2 = (IAccountService) ac.getBean("accountService");
        System.out.println(as==as2);
//        System.out.println(as);
//        IAccountDao ad = (IAccountDao) ac.getBean("accountDao");
//        System.out.println(ad);
         as.saveAccount();
    }
}
