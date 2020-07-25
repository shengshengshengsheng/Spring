package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import com.itheima.utils.TransactionManager;

import java.util.List;

/**
 * 账户的业务层实现类
 *
 * @author Administrator
 */
public class AccountServiceImplOld implements IAccountService {
    private IAccountDao accountDao;
    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public List<Account> findAllAccount() {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            List<Account> accounts =accountDao.findAllAccount();
            //3.提交事务
            txManager.commit();
            //4.返回结果
            return accounts;
        } catch (Exception e) {
            //5.回滚事务
            txManager.rollback();
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            //6.释放资源
            txManager.release();
        }
    }

    public Account findAccountById(Integer id) {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            Account account = accountDao.findAccountById(id);
            //3.提交事务
            txManager.commit();
            //4.返回结果
            return account;
        } catch (Exception e) {
            //5.回滚事务
            txManager.rollback();
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            //6.释放资源
            txManager.release();
        }
    }

    public void saveAccount(Account account) {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            accountDao.saveAccount(account);
            //3.提交事务
            txManager.commit();
            //4.返回结果
        } catch (Exception e) {
            //5.回滚事务
            txManager.rollback();
            e.printStackTrace();
        } finally {
            //6.释放资源
            txManager.release();
        }
    }

    public void updateAccount(Account account) {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            accountDao.updateAccount(account);
            //3.提交事务
            txManager.commit();
            //4.返回结果
        } catch (Exception e) {
            //5.回滚事务
            txManager.rollback();
            e.printStackTrace();
        } finally {
            //6.释放资源
            txManager.release();
        }
    }

    public void deleteAccount(Integer id) {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            accountDao.deleteAccount(id);
            //3.提交事务
            txManager.commit();
            //4.返回结果
        } catch (Exception e) {
            //5.回滚事务
            txManager.rollback();
            e.printStackTrace();
        } finally {
            //6.释放资源
            txManager.release();
        }
    }

    public void transfer(String sourceName, String targetName, Double money) {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            //1.根据名称查询转出账户
            Account source=accountDao.findAccountByName(sourceName);
            //2.根据名称查询转入账户
            Account target=accountDao.findAccountByName(targetName);
            //3.转出账户扣钱
            source.setMoney(source.getMoney()-money);
            //4.转入账户加钱
            target.setMoney(target.getMoney()+money);
            //5.更新转出账户
            accountDao.updateAccount(source);
            int i = 1/0;
            //6.更新转入账户
            accountDao.updateAccount(target);
            //3.提交事务
            txManager.commit();
            //4.返回结果
        } catch (Exception e) {
            //5.回滚事务
            txManager.rollback();
            e.printStackTrace();
        } finally {
            //6.释放资源
            txManager.release();
        }

    }

    public void setAccountDao(AccountDaoImpl accountDao) {
        this.accountDao = accountDao;
    }
}
