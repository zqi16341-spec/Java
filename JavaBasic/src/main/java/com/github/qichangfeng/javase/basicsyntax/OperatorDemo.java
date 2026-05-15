package com.github.qichangfeng.javase.basicsyntax;

import java.util.Scanner;

public class OperatorDemo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int ge=num%10;
        int shi=num/10;
        boolean result = ge==7 || num%7==0 || shi==7;
        System.out.println(result);
    }
}
