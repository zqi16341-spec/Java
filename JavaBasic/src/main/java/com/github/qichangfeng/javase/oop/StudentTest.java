package com.github.qichangfeng.javase.oop;

public class StudentTest {
    public static void main(String[] args) {
        int[] scores = {88, 92, 76, 100, 85};

        Student s = new Student("张三", 18, scores);

        s.showInfo();

        System.out.println("总分：" + s.getTotalScore());
        System.out.println("平均分：" + s.getAverageScore());
        System.out.println("最高分：" + s.getMaxScore());
        System.out.println("最低分：" + s.getMinScore());
    }
}
