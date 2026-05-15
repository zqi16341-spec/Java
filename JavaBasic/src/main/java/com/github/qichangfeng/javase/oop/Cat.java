package com.github.qichangfeng.javase.oop;

public class Cat extends Animal{
    public Cat(String name, int age) {
        super(name, age);
    }

    public Cat() {
    }

    @Override
    public void speak() {
        System.out.println(getName()+"喵喵叫");
    }
    public void catchMouse(){
        System.out.println(getName()+"正在抓老鼠");
    }
}
