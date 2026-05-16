package com.github.qichangfeng.javase.oop.bank;

public class AliPay implements Payment{

    @Override
    public void pay(double money) {
        if(money<=0){
            System.out.println("输入金额不合法");
            return;
        }
        System.out.println("支付宝支出"+money+"元");
    }
}
