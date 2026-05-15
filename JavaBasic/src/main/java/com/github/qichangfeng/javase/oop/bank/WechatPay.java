package com.github.qichangfeng.javase.oop.bank;

public class WechatPay implements Payment{

    @Override
    public void pay(double money) {
        System.out.println("微信支出"+money+"元");
    }
}
