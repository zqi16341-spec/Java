package com.github.qichangfeng.javase.basicsyntax;
//Scanner初见用法，运算符+-*/(加减乘除)%(取余)
import java.util.Scanner;

public class VariableDemo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入第一个数字");
        int num1=sc.nextInt();
        System.out.println(num1);
        System.out.println("输入第二个数字");
        int num2=sc.nextInt();
        System.out.println(num2);
        System.out.println("两数之和为");
        System.out.println(num1+num2);


    }
}
