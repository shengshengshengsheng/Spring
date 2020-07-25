package com.itheima.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * @author:Administrator
 * 该类是一个配置类他的作用和bean.xml的作用是一样的
 * Spring中的新注解
 *      @Configuration
 *          作用：指定当前类是一个配置类
 *          细节：当配置类作为AnnotationConfigApplicationContest对象创建的参数时该注解可以不写
 *      @ComponentScan
 *          作用：用于通过注解指定Spring在创建容器时要扫描的包
 *          属性：
 *              value:她和basePackages的作用是一样的，都是用于指定创建容器时要扫描的包
 *                    我们使用此注解@ComponentScan(basePackages = "com.itheima")
 *                    就等同于在xml中配置了<context:component-scan base-package="com.itheima"/>
 *      @Bean
 *          作用：用于将当前方法的返回值作为bean对象存入Spring的IOC容器中
 *          属性：
 *              name：用于指定bean的id，当不写name时默认值是当前方法的名称
 *          细节：
 *              当我们使用注解配置方法时，如果方法有参数，Spring框架会去容器中查找有没有可能的bean对象
 *              查找的方式和@Autowire注解的作用是一样的
 *      @Import
 *          作用：用于导入其他配置类
 *          属性：value：用于指定其他配置类的字节码
 *              当我们使用import的注解之后，有Import注解的配置类就是父配置类，而导入的都是子配置类
 *      @ProperSource
 *          作用：用于指定properties文件的位置
 *          属性：
 *              value：指定文件的名称和路径
 *              关键字：classpath表示类路径下
 *
 */
@Configuration
@Import(JdbcConfig.class)
@ComponentScan(basePackages = {"com.itheima"})
//@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

}
