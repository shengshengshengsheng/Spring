package com.itheima.cglib;

/**
 * 对生产厂家要求的接口
 * @author Administrator
 */
public interface IProducer {
    /**
     * 销售
     * @param money
     */
    void saleProduct(double money);

    /**
     * 售后
     * @param money
     */
    void afterService(double money);
}
