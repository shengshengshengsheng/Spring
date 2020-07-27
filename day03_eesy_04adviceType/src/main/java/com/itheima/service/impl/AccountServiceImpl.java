package com.itheima.service.impl;

import com.itheima.service.IAccountService;

/**
 * description:账户的业务层实现类
 *
 * @author xuqiangsheng
 * @date 2020/7/27 9:00
 */
public class AccountServiceImpl implements IAccountService {
    public void saveAccount() {
        System.out.println("执行了保存账户");
    }

    public void updateAccount(int i) {
        System.out.println("执行了更新"+i);
    }

    public int deleteAccount(int i) {
        System.out.println("执行了删除"+i);
        return 0;
    }
}
