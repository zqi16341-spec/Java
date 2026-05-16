package com.github.qichangfeng.javase.oop.bank;

public class BankCardPay implements Payment{

    @Override
    public void pay(double money) {
        if(money<=0){
            System.out.println("输入金额不合法");
            return;
        }
        System.out.println("银行卡支出"+money+"元");
    }
}
