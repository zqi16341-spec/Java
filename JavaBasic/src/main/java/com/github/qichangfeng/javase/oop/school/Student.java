package com.github.qichangfeng.javase.oop.school;

public class Student extends Person{
    private int[] scores;

    public Student(){
        super();
    }

    public Student(String name,int age,int[]scores){
        super(name , age);
        setScores(scores);
    }

    @Override
    public void work() {
        System.out.println(getName()+"在上课");
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

    public void showInfo(){
        System.out.println("姓名为：" + this.getName());
        System.out.println("年龄为：" + this.getAge()) ;
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
