package com.itheima.factory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author:Administrator
 * 一个创建Bean对象的工厂
 * Bean：在计算机英语中有可重用组件的含义。
 * javaBean：用java语言编写的可重用组件
 *      javaBean > 实体类
 *     他就是创建我们的service和dao对象
 *     第一个：需要一个配置文件来配置我们的service和dao
 *          配置的内容：唯一标识==全限定类名(key==value)
 *     第二个：通过读取配置文件中配置的内容反射创建对象
 *     配置文件可以是xml或者properties
 */
public class BeanFactory {
    //定义一个properties
    private static Properties props;
    //定义一个Map用于存放我们要创建的对象，我们称之为容器
    private static Map<String,Object> beans;

    //使用一个静态代码块为Properties对象赋值
    static {
        try{
            //实例化对象
            props = new Properties();
            //获取properties文件的流对象
            InputStream inputStream =BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(inputStream);
            //实例化容器
            beans = new HashMap<String, Object>();
            //取出配置文件中所有的keys
            Enumeration<Object> keys = props.keys();
            //遍历枚举值
            while (keys.hasMoreElements()){
                //取出每个key
                String key = keys.nextElement().toString();
                //根据key获取values
                String beanPath = props.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把key和value存入容器中
                beans.put(key,value);
            }
        }catch (Exception e){
            throw new ExceptionInInitializerError("初始化properties出错");
        }
    }

    /**
     * 根据bean的名称获取对象--此种方式获取的是单例对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }

    /** 
     *@descrpition: 通过bean的名称获取到bean对象--此种方式获取的是多例对象
     * @param beanName bean的名称
     * @return: java.lang.Object
     * @author: XuQiangsheng
     * @date: 2020/7/25 9:49
     */
    /*public static Object getBean(String beanName){
        Object bean = null;
        try{
            String beanPath = props.getProperty(beanName);
            //每次都会调用默认构造函数创建对象
            bean = Class.forName(beanPath).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bean;
    }*/

}
