package com.itheima.domain;

import java.io.Serializable;

/**
 * 账户的实体类
 * @author Administrator
 */
public class Account implements Serializable {
    private Integer id;

    private Integer uid;

    private String name;

    private Double money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
