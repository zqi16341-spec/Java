package com.github.qichangfeng.javase.array;

import java.util.Random;

public class ArrayDemo{
    public static void main(String[] args) {
        int[] arr=new int[10];
        Random r=new Random();
        int attempts=0;//codex练习

        for (int i = 0; i < arr.length;) {
//            进入循环生成随机数
            int num=r.nextInt(101);
            attempts++;
//            计数器
            int count=0;
            for (int j = 0; j < i;j++) {//只需要与已存元素比较
                if(arr[j]==num){
                    count++;//存在则计数器自增
                    break;
                }
            }
            if(count==0){//不存在则赋值
                arr[i]=num;
                i++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println(attempts);
    }
}
