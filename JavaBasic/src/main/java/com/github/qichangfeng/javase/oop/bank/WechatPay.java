package com.github.qichangfeng.javase.oop.bank;

public class WechatPay implements Payment{

    @Override
    public void pay(double money) {
        if(money<=0){
            System.out.println("输入金额不合法");
            return;
        }
        System.out.println("微信支出"+money+"元");
    }
}
