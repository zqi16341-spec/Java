package com.github.qichangfeng.javase.oop;

public class Student {
    private String name;
    private int age;
    private int[] scores;

    public Student(){

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age<0||age>150) {
            System.out.println("年龄不合法");
            return;
        }
        this.age = age;
    }

    public int[] getScores() {
        return scores;
    }

    public void setScores(int[] scores) {
        if(scores==null){
            System.out.println("成绩输入格式错误");
            return;
        }
        this.scores = scores;
    }

    public Student(String name, int age, int[] scores) {
        this.name = name;
        setAge(age);
        setScores(scores);
    }
    public void showInfo(){
        System.out.println("姓名为：" + this.name);
        System.out.println("年龄为：" + this.age) ;
        System.out.print("成绩为：");
        if(scores==null||scores.length==0){
            System.out.println("[]");
            return ;
        }
            System.out.print("[");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i]);
            if (i !=scores.length-1){
                System.out.print(",");
            }
        }
        System.out.println("]");


    }
    public int getTotalScore(){
        if(scores==null||scores.length==0){
            return 0;
        }
        int sum=0;
        for (int i = 0; i < scores.length; i++) {
            sum=sum+scores[i];
        }
        return sum;
    }
    public  double getAverageScore(){
        if(scores==null||scores.length==0){
            return 0;
        }

        return  getTotalScore()*1.0/scores.length;

    }
    public int getMaxScore(){
        if(scores==null||scores.length==0){
            return 0;
        }
        int max=scores[0];
        for (int i = 1; i <scores.length ; i++) {
            if(max<scores[i]){
                max=scores[i];
            }
        }
        return max;
    }
    public int getMinScore(){
        if(scores==null||scores.length==0){
            return 0;
        }
        int min=scores[0];
        for (int i = 1; i <scores.length ; i++) {
            if(min>scores[i]){
                min=scores[i];
            }
        }
        return min;
    }
}
