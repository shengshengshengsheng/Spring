package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * 账户的持久层实现类
 * @author Administrator
 */
public class AccountDaoImpl implements IAccountDao {
    private QueryRunner runner ;

    /*public AccountDaoImpl(QueryRunner runner) {
        this.runner = runner;
    }*/

    public List<Account> findAllAccount() {
        try {
            return runner.query("select * from account",new BeanListHandler<Account>(Account.class));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Account findAccountById(Integer id) {
        try {
            return runner.query("select * from account where id = ?",new BeanHandler<Account>(Account.class),id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void saveAccount(Account account) {
        try {
            runner.update("insert into account(uid,`name`,money) values (?,?,?)",account.getUid(),account.getName(),account.getMoney());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void updateAccount(Account account) {
        try {
            runner.update("update account set uid =?,name =?,money = ? where id = ?",account.getUid(),account.getName(),account.getMoney(),account.getId());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void deleteAccount(Integer id) {
        try {
            runner.update("delete from  account  where id = ?",id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }
}
