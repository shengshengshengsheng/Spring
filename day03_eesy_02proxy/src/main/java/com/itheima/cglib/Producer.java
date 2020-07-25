package com.itheima.cglib;

/**
 * @author:Administrator
 * 一个生产者
 */
public class Producer {
    /**
     * 销售
     * @param money
     */
    public void saleProduct(double money){
        System.out.println("销售商品,并拿到钱:"+money);
    }

    /**
     * 售后
     * @param money
     */
    public void afterService(double money){
        System.out.println("售后服务,并拿到钱:"+money);
    }
}
