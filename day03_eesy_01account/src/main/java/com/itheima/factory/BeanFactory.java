package com.itheima.factory;

import com.itheima.service.IAccountService;
import com.itheima.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * @author:Administrator
 * 用于创建Service的代理对象工厂
 */
public class BeanFactory {
    private IAccountService accountService ;
    private TransactionManager txManager;
    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    /**
     * 获取service的代理对象
     * @return
     */
    public IAccountService getAccountService() {
        return (IAccountService)Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 增加事务
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue = null;
                        try {
                            //1.开启事务
                            txManager.beginTransaction();
                            //2.执行操作
                            rtValue = method.invoke(accountService,args);
                            //3.提交事务
                            txManager.commit();
                            //4.返回结果
                            return rtValue;
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
                });
    }

    public final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }
}
