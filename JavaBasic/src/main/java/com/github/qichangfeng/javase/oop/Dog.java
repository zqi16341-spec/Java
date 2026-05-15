package com.github.qichangfeng.javase.oop;

public class Dog extends Animal{
    public Dog(String name,int age){
        super(name,age);
    }

    public Dog() {
    }

    @Override
    public void speak() {
        System.out.println(getName()+"汪汪叫");
    }
    public  void watchHome(){
        System.out.println(getName()+"在看门");
    }
}
