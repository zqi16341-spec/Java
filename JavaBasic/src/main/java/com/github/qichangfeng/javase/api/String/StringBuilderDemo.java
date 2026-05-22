package com.github.qichangfeng.javase.api.String;

public class StringBuilderDemo {
    public static void main(String[] args) {
        String text = "java";
        String phone = "13812345678";
        String sentence = "hello world java";

        System.out.println("反转结果：" + reverse(text));
        System.out.println("手机号脱敏：" + maskPhone(phone));
        System.out.println("拼接结果：" + joinWords(sentence));
        System.out.println("是否回文：" + isPalindrome("上海自来水来自海上"));
    }

    public static String reverse(String text) {
        // TODO 1: 使用 StringBuilder 把 text 反转并返回
        // 提示：new StringBuilder(text).reverse().toString()
        return new StringBuilder(text).reverse().toString();
    }

    public static String maskPhone(String phone) {
        // TODO 2: 手机号脱敏
        // 输入：13812345678
        // 输出：138****5678
        // 提示：substring(0, 3) + "****" + substring(7)
        return new StringBuilder(phone).substring(0,3)+"****"+new StringBuilder(phone).substring(7);
    }

    public static String joinWords(String sentence) {
        // TODO 3: 用 StringBuilder 重新拼接字符串
        // 输入：hello world java
        // 输出：hello-world-java
        // 提示：先 split(" ")，再循环 append
        StringBuilder sb = new StringBuilder();
        String[] text =sentence.split(" ");
        for (int i = 0; i < text.length; i++) {
            sb.append(text[i]);
            if(i!=text.length-1){
                sb.append("-");
            }

        }
        return sb.toString();
    }

    public static boolean isPalindrome(String text) {
        // TODO 4: 判断是否回文
        // 思路：反转后的字符串和原字符串 equals 比较
        return     new StringBuilder(text).reverse().toString().equals(text);
    }
}
