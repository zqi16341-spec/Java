package com.github.qichangfeng.javase.oop.school;

public class Teacher extends Person{
    public Teacher() {
    }

    public Teacher(String name,int age){
        super(name,age);
    }


    @Override
    public void work() {
        System.out.println(getName()+"在上课");
    }
}
