package com.github.qichangfeng.javase.oop.zoo;

public class Bird extends Animal implements Flyable{
    public Bird() {
    }

    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void speak() {
        System.out.println(getName()+"叫唧唧");
    }

    @Override
    public void fly() {
        System.out.println(getName()+"即将起飞");
    }
}
