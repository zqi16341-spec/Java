package com.github.qichangfeng.javase.oop.bank;

import jdk.swing.interop.SwingInterOpUtils;

public class Test {

    public static void checkout(Payment payment, double money) {
        System.out.println("开始结账");
        payment.pay(money);
        System.out.println("结账结束");
    }

    public static void main(String[] args) {

        Payment p1 = new AliPay();
        Payment p2 = new WechatPay();
        Payment p3 = new BankCardPay();

        p1.pay(100);
        p2.pay(200);
        p3.pay(300);

    checkout(new AliPay(),100);

//        checkout(new AliPay(), 100);
//        checkout(new WechatPay(), 200);
//        checkout(new BankCardPay(), 300);


    }
}
