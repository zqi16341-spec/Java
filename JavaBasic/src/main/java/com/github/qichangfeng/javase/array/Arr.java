package com.github.qichangfeng.javase.array;

import java.util.Scanner;
//数组常用：排序，搜索，在寻找最值或相似场景中，不能使用数组元素以外的元素初始化max等数据
//在需要交换位置的场景中，需要引入临时变量temp，令temp=a，a=b，b=temp来实现
public class Arr {
    public static void main(String[] args) {
//        静态初始化数组
        int[] num ={1,2,3};
        String[] name=new String[]{"abc","def"};
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
//        动态初始化数组及打印
        int[] arr=new int[3];
        Scanner sc=new Scanner(System.in);
        for (int i = 0; i < arr.length ;i++) {
            System.out.println("请输入一个整数：");
            int num2=sc.nextInt();
            arr[i]=num2;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }


    }
}
