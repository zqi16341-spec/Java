package com.github.qichangfeng.javase.oop.bank;

public class BankCardPay implements Payment{

    @Override
    public void pay(double money) {
        System.out.println("银行卡支出"+money+"元");
    }
}
