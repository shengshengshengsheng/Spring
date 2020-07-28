package com.itheima.dao;

import com.itheima.domain.Account;

/**
 * description:
 *
 * @author xuqiangsheng
 * @date 2020/7/28 8:14
 */
public interface IAccountDao {
    /**
     * 根据账户id查询账户
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    Account findAccountByName(String accountName);

    void updateAccount(Account account);
}
