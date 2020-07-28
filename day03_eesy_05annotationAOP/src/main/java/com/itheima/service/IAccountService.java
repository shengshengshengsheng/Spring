package com.itheima.service;

/**
 * description:账户的业务层接口
 *
 * @author xuqiangsheng
 * @date 2020/7/27 8:58
 */
public interface IAccountService {
    /**
     * 模拟保存账户
     */
    void saveAccount();

    /**
     * 模拟更新账户
     * @param i
     */
    void updateAccount(int i);

    /**
     * 删除账户
     * @param i
     * @return 删除的条数
     */
    int deleteAccount(int i);
}
