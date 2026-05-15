package com.github.qichangfeng.javase.oop;

public class AnimalTest {
    public static void main(String[] args) {
        Animal a1 = new Dog("旺财", 3);
        Animal a2 = new Cat("小花", 2);
        Animal a3 = new Bird("小鸟", 1);

        a1.eat();
        a1.speak();

        a2.eat();
        a2.speak();

        a3.eat();
        a3.speak();

        Flyable f = new Bird("啾啾", 1);
        f.fly();
    }
}
