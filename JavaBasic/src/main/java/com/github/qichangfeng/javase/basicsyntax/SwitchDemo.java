package com.github.qichangfeng.javase.basicsyntax;

import java.util.Scanner;

public class SwitchDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入月份");
        int num = sc.nextInt();
        String season = switch (num) {
            case 12, 1, 2-> "冬天";
            case 3, 4, 5 ->"春天";
            case 6, 7, 8 ->"夏天";
            case 9, 10, 11 ->"秋天";
            default ->"没有这个季节";

        };
        System.out.println(season);
    }
}
