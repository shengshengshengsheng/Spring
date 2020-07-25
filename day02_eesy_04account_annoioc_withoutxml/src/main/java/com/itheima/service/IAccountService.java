package com.itheima.service;

import com.itheima.domain.Account;

import java.util.List;

/**
 * 账户的业务层接口
 * @author Administrator
 */
public interface IAccountService {
    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     * @param id
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 保存操作
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新操作
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除账户
     * @param id
     */
    void deleteAccount(Integer id);
}
