package com.github.qichangfeng.javase.oop.school;

public class StudentTest {
    public static void doWork(Person person) {
        person.work();
    }
    public static void main(String[] args) {
        int[] scores = {88, 92, 76, 100, 85};

        Student s = new Student("张三", 18, scores);

        Person p1 = new Student("张三", 18, scores);
        Person p2 = new Teacher("李老师", 30);

        p1.work();
        p2.work();


        s.showInfo();

        System.out.println("总分：" + s.getTotalScore());
        System.out.println("平均分：" + s.getAverageScore());
        System.out.println("最高分：" + s.getMaxScore());
        System.out.println("最低分：" + s.getMinScore());
        s.work();

        doWork(new Student("张三", 18, scores));
        doWork(new Teacher("李四", 30));

    }
}
