package com.itheima.service.impl;

import com.itheima.service.IAccountService;

import java.util.Date;

/**
 * 账户的业务层实现类
 * @author Administrator
 */
public class AccountServiceImpl implements IAccountService {
    //如果是经常变化的数据并不适用于注入的方式
    private String name;
    private String age;
    private Date birthday;

    public AccountServiceImpl(String name, String age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了..."+name+"-->"+age+"-->"+birthday);
    }
}
