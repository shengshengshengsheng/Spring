package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * 账户的业务层实现类
 * @author Administrator
 * 曾经xml的配置如下：
 *   <bean id="accountService" class="com.itheima.service.impl.AccountServiceImpl"
 *   scope = "" init-method = "" destory-method = "">
 *      <property name ="" value="" /ref=""></property>
 *   </bean>
 *   用于创建对象的
 *      他们的作用就和在xml配置文件中编写一个<bean></bean>标签实现的功能是一样的
 *      @Component
 *          作用：用于把当前类对象存入到Spring容器当中
 *          属性：
 *              values：用于指定bean的id，当我们不写value标签时它的默认值是当前类名且首字母改小写
 *      @Controller 一般用在表现层
 *      @Service 一般用在业务层
 *      @Repository 一般用在持久层
 *          以上三个注解他们的作用和属性与@Component是一模一样的
 *          他们三个是Spring框架为我们提供的明确的三层使用的注解，使我们的三层对象更加清晰
 *
 *   用于注入数据的
 *      他们的作用就和在xml配置文件中编写一个<property></property>标签实现的功能是一样的
 *      @Autowired
 *          作用：自动按照类型注入，只要容器中有唯一的bean对象类型和要注入的变量类型匹配就可以注入成功
 *               如果IOC容器中没有任何bean的类型和要注入的变量类型匹配则报错
 *               如果IOC容器中有多个类型匹配时
 *          出现的位置：
 *              可以是变量上，也可以是方法上
 *          细节：
 *              在使用注解注入时，set方法就不是必须的了。
 *      @Qualifier
 *          作用：在按照类型注入的基础之上再按照名称注入。他在给类成员注入时不能单独使用，必须配合着@Autowired使用，但是在方法参数注入时可以
 *          属性：
 *              value：用于指定bean的id
 *      @Resource
 *          作用：直接按照bean的id注入，可以独立使用
 *          属性：
 *              name：用于指定bean的id
 *          @Resource(name = "accountDao1") == @Autowired(有两个相同类型匹配时不知道注入哪个需要配合Qualifier使用)+@Qualifier(value = "accountDao1")
 *      以上三个注解都只能注入其他bean类型的数据，而基本数据类型和String类型无法使用上述注解实现。
 *      另外：集合类型的注入只能通过xml来实现
 *
 *      @Value
 *          作用：用于注入基本类型和String类型的数据
 *          属性：
 *              value：用于指定数据的值，他可以使用Spring中的SpEL（也就Spring的EL表达式）
 *                  SpEL的写法：${表达式}
 *   用于改变作用范围的
 *      他们的作用就和在<bean></bean>标签中使用scope属性实现的功能是一样的
 *      @Scope
 *          作用：用于指定bean的作用范围
 *          属性：
 *              value：指定范围的取值。常用取值：singleton单例 prototype多例
 *   与生命周期相关的
 *      他们的作用就和在<bean></bean>标签中使用init-method和destory-method属性实现的功能是一样的
 *      @PreDestory
 *          作用：用于指定销毁方法
 *      @PostConstruct
 *          作用：用于指定初始化方法
 */
@Component(value = "accountService")
@Scope(value = "prototype")
public class AccountServiceImpl implements IAccountService {
//    @Autowired
//    @Qualifier(value = "accountDao1")
    @Resource(name = "accountDao1")
    private IAccountDao accountDao;
    public void saveAccount() {
        accountDao.saveAccount();
    }

    @PostConstruct
    public void init() {
        System.out.println("初始化方法执行了");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("销毁方法执行了");
    }
}
