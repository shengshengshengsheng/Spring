package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * @author:Administrator
 * 账户的持久层实现类
 */
@Repository(value = "accountDao2")
public class AccountDaoImpl2 implements IAccountDao {
    public void saveAccount() {
        System.out.println("保存了账户");
    }
}
