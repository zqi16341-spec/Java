package com.github.qichangfeng.javase.collection;

public class CollectionStudent {
    private String name;
    private int age;
    private int score;

    // TODO 1: 空参构造方法
    public  CollectionStudent(){

    }



    // TODO 2: 有参构造方法 CollectionStudent(String name, int age, int score)
    // 提示：可以调用 setter，复用年龄和分数的过滤逻辑
    public CollectionStudent(String name, int age, int score) {
        this.name = name;
        setScore(score);
        setAge(age);
    }

    // TODO 3: name 的 getter / setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    // TODO 4: age 的 getter / setter
    // 要求：age 小于 0 或大于 150 时，打印“年龄不合法”，不赋值

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age<0||age>150) {
            System.out.println("年龄不合法");
            return;
        }
        this.age=age;
    }


    // TODO 5: score 的 getter / setter
    // 要求：score 小于 0 或大于 100 时，打印“分数不合法”，不赋值

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        if(score<0||score>100) {
            System.out.println("分数不合法");
            return;
        }
        this.score = score;
    }


    // TODO 6: showInfo()
    // 输出格式示例：张三，18岁，90分
    public void showInfo(){
        System.out.println(getName()+","+getAge()+"岁,"+getScore()+"分");
    }
}
