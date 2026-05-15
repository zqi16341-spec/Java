package com.github.qichangfeng.javase.basicsyntax;
//判断语句训练
import java.util.Scanner;

public class JudgementDemo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入体重：");
        double weight= sc.nextDouble();
        if (weight>0)
        System.out.println("请输入身高：");
        double height=sc.nextDouble();
        if(height>0)
        System.out.println("宁的bmi为"+weight/(height*height));
        double bmi=weight/(height*height);
        if(bmi<18){
            System.out.println("宁的身体偏瘦");
        }else if(bmi<25) {
            System.out.println("宁的身体状况良好");
        }else System.out.println("宁的体重偏大");

    }
}
