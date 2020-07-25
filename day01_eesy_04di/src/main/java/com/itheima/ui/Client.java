package com.itheima.ui;

import com.itheima.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author:Administrator
 * 模拟一个表现层用于调用业务层
 */
public class Client {
    /**
     * 获取Spring的ioc核心容器并根据id获取对象
     * ApplicationContext 的三个常用实现类
     *      ClassPathXmlApplicationContext：他可以加在类路径下的配置文件，要求配置文件必须在类路径下，不在的话加载不了(更常用)
     *      FileSystemXmlApplicationContext：他可以加载磁盘任意路径下的配置文件（必须有访问权限）
     *      AnnotationConfigApplicationContext：它是用于读取注解创建容器
     *   核心容器的两个接口引发出的问题：
     *      ApplicationContext： 单例对象适用
     *          他在构建核心容器时创建对象采取的策略是采用立即加载的方式，也就是说，只要一读取完配置文件马上就创建配置文件中的对象。
     *      BeanFactory：  多例对象适用
     *          他在构建核心容器时创建对象采取的策略是采用延迟加载的方式，也就是说，什么时候根据id获取对象了，什么时候才真正的创建对象。
     * @param args
     */
    public static void main(String[] args) {
//        IAccountService as = new AccountServiceImpl();
        //1.获取核心容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new FileSystemXmlApplicationContext("F:\\learning\\Spring\\day01_eesy_03spring\\src\\main\\resources\\bean.xml");
        //2.根据id获取对象
//        IAccountService as = (IAccountService) ac.getBean("accountService");
//         as.saveAccount();
//        IAccountService as = (IAccountService) ac.getBean("accountService2");
//        as.saveAccount();
        IAccountService as = (IAccountService) ac.getBean("accountService3");
        as.saveAccount();
         //手动关闭容器
        ac.close();

     /*  // -----------------------BeanFactory------------------------
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory =new XmlBeanFactory(resource);
        IAccountService accountService = (IAccountService) factory.getBean("accountService");
        System.out.println(accountService);*/
    }
}
