package com.github.qichangfeng.javase.oop.bank;

public class AliPay implements Payment{

    @Override
    public void pay(double money) {
        System.out.println("支付宝支出"+money+"元");
    }
}
