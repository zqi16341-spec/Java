package com.github.qichangfeng.javase.oop.zoo;

public abstract class Animal {

    private String name;
    private int age;

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
        if(age<0||age>20){

            System.out.println("输入年龄不合法");
            return;
        }
        this.age = age;
    }

    public Animal(){

    }
    public Animal(String name,int age){
        setAge(age);
        setName(name);
    }

    public void eat(){
        System.out.println(name+"正在吃饭");
    }

    public abstract void speak();


}