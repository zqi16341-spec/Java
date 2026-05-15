package com.github.qichangfeng.javase.array;
//算法练习1：寻找数组中是否有匹配的元素,如果有的话输出第一个索引
import java.util.Random;
import java.util.Scanner;
//方法一：计数器count
//方法二：flag标记
public class FindDemo {
    public static void main(String[] args) {
//        Random r=new Random();
//        int randomIndex=r.nextint(arr.length);获取随机一个数的索引
//        为创建随机变量语句
        Scanner sc=new Scanner(System.in);
        int[] arr={10,20,30,40,50,10};
        int count=0;
        System.out.println("请输入一个整数");
        int num=sc.nextInt();
        for (int i = 0; i < arr.length; i++) {
            if(num==arr[i]){
                System.out.println("索引为"+i);
                count++;
                break;
            }
        }
        if(count==0){
            System.out.println("没有这个数");
        }
    }
}
