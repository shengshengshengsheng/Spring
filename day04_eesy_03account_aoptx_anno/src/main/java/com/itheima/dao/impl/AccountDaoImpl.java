package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 账户的持久层实现类
 * @author Administrator
 */
@Component("accountDao")
public class AccountDaoImpl implements IAccountDao {
    @Autowired
    private QueryRunner runner ;
    @Autowired
    private ConnectionUtils connectionUtils;

    public List<Account> findAllAccount() {
        try {
            return runner.query(connectionUtils.getThreadConnection(),"select * from account",new BeanListHandler<Account>(Account.class));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Account findAccountById(Integer id) {
        try {
            return runner.query(connectionUtils.getThreadConnection(),"select * from account where id = ?",new BeanHandler<Account>(Account.class),id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void saveAccount(Account account) {
        try {
            runner.update(connectionUtils.getThreadConnection(),"insert into account(uid,`name`,money) values (?,?,?)",account.getUid(),account.getName(),account.getMoney());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void updateAccount(Account account) {
        try {
            runner.update(connectionUtils.getThreadConnection(),"update account set uid =?,name =?,money = ? where id = ?",account.getUid(),account.getName(),account.getMoney(),account.getId());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void deleteAccount(Integer id) {
        try {
            runner.update(connectionUtils.getThreadConnection(),"delete from  account  where id = ?",id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Account findAccountByName(String accountName) {
        try {
            List<Account> accountList = runner.query(connectionUtils.getThreadConnection(),"select * from account where name = ?",new BeanListHandler<Account>(Account.class),accountName);
            if(accountList.size()==0){
                return null;
            }else if(accountList.size()==1){
                return accountList.get(0);
            }else {
                throw new RuntimeException("结果集不唯一");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }
}
