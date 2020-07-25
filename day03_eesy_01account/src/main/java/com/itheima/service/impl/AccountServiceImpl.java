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
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    public void saveAccount(Account account) {
            accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
            accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer id) {

            accountDao.deleteAccount(id);

    }

    public void transfer(String sourceName, String targetName, Double money) {
        System.out.println("transfer方法执行了");
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
//            int i = 1/0;
            //6.更新转入账户
            accountDao.updateAccount(target);
    }

    public void setAccountDao(AccountDaoImpl accountDao) {
        this.accountDao = accountDao;
    }
}
