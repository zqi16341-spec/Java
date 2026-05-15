# Java 学习记录

这个文件用来记录每天的 Java 学习过程、练习代码、卡住的问题和复习重点。

## 仓库导航

- `JavaBasic/README.md`：JavaSE 练习代码模块说明。
- `docs/javase/README.md`：JavaSE 各阶段文档索引。
- `docs/javase/01-basic-syntax/README.md`：基础语法。
- `docs/javase/02-array/README.md`：数组。
- `docs/javase/03-oop/README.md`：面向对象。
- `docs/javase/04-api/README.md`：常用 API。
- `docs/javase/05-leetcode/README.md`：力扣和算法练习。
- `docs/javase/06-projects/README.md`：综合练习和小项目。

## 记录模板

```md
## YYYY-MM-DD

### 今天学了什么
- 

### 今天写了什么代码
- 

### 卡住的问题
- 

### 我现在的理解
- 

### 明天要复习或继续做
- 
```

## 2026-05-14 Day1

### 今天学了什么
- 在前几日面向对象的基础上，完成了复盘总结，并学习了API中字符串的比较、遍历、截取、替换等操作。
- 刷了三道力扣的算法数组题，题序号为27、26、2784（5.14每日一题）

### 今天写了什么代码
- 今天的推进主要在于对前段时间面向对象以及更基础部分的复习与回顾，完成度比较高的代码只有三道算法题的方法部分


### 复盘面向对象

前段时间推进学习没能及时巩固基础加深理解，特于今日进行回顾与训练

#### 类与对象

类是模版，对象是具体实例

```java
public class Student{
    private String name;
    private int age;

    public void study() {
        System.out.println(name + "正在学习");
    }
}
```

这里Student为类名

name、age为成员变量

study 是成员方法，表示对象可以执行的行为。

创建对象：

```java
Student s = new Student();
```

new Student() 创建了一个 Student 对象。
s 是引用变量，用来指向这个对象。

对象有自己的属性与方法

#### 成员变量与局部变量

```java
public class Student {
    private String name;
    private int age;
}
```

成员变量属于对象

每new一个对象，就有一份自己的name与age。

```java
public void study(int hour) {
    String subject = "Java";
    System.out.println("学习" + subject + hour + "小时");
}
```

hour是参数，也是局部变量

subject是方法内部的局部变量

区别是成员变量写在类里，方法外，描述的是对象长期拥有的数据，而局部变量写在方法里，方法执行时临时使用

#### 构造方法

构造方法在new对象的时候自动调用

```java
public class Student {
    private String name;
    private int age;

    public Student() {//空参构造
    }
    
    public Student(String name, int age) {//有参构造
        this.name = name;
        this.age = age;
    }
    
}
```

构造方法名与类名一样，没有返回值类型，构造方法不能写 void。如果写了 void，就变成普通方法，不再是构造方法。

如果一个类没有写任何构造方法，Java 会默认提供一个空参构造。如果手动写了有参构造，Java 就不会再自动提供空参构造，需要自己补。

使用方法为

```java
Student s1 = new Student();
Student s2 = new Student("张三", 18);
```

#### this

this表示当前对象，最常用于区分成员变量与局部变量

```java
public Student(String name, int age) {
    this.name = name;
    this.age = age;
}
```

其中this.name是成员变量，name是构造方法参数

没有this的话相当于参数自己给自己赋值，成员变量没变

#### 封装

封装的基本写法为

private成员变量

对外提供 public getter/setter方法

```java
public class Student {
    private String name;
    private int age;

    public void setAge(int age) {
        if (age < 0 || age > 150) {
            System.out.println("年龄不合法");
            return;
        }
        this.age = age;
    }
    
    public int getAge() {
        return age;
    }

}
```

这样保护了成员变量不会被外部随意改动，而是被set方法检查是否合法之后变化。

#### static

```java
public class Student {
    private String name;
    private static String school = "北京邮电大学";
//静态成员变量所有对象共享一份
    public Student(String name) {
        this.name = name;
    }
    
    public void showInfo() {
        System.out.println(name);
        System.out.println(school);
    }
    
    public static void changeSchool(String newSchool) {
        school = newSchool;
    }

}
```

调用静态方法

```
Student.changeSchool("清华大学");
```

而不推荐s.changeSchool("清华大学");

static属于类，调用时可能还没有对象，所以static方法中不能直接使用非static成员变量

#### 继承

继承用于复用代码，在几个类有相同属性或方法的情况下，可以先创建具有这些相同属性或方法的父类，在创建子类时使之继承，格式如

class子类名 extends 父类名

子类继承父类的public方法；父类private成员变量，子类不能直接访问

```java
public class Person {
    private String name;
    private int age;

    public void eat() {
        System.out.println("吃饭");
    }
}
```

```java
public class Student extends Person {
    public void study() {
        System.out.println("学习");
    }
}
```
使用时
```text
Student s = new Student();
s.eat();
s.study();
```


eat 方法来自父类，study 方法是子类自己的方法。

注意：

Java 只支持单继承，一个类只能直接继承一个父类。

子类可以继承父类的 public 和 protected 成员。

父类的 private 成员子类不能直接访问，但可以通过父类提供的 getter/setter 间接访问。

所有类默认都直接或间接继承 Object 类。

#### super

`super` 表示父类对象的引用，常用于访问父类构造方法或父类方法。

```java
public class Student extends Person {
    public Student(String name, int age) {
        super(name, age);
    }
}
```

方法重写
子类可以重写父类的方法，用自己的实现替换父类的实现。

```java
@Override
public void eat() {
    System.out.println("学生在食堂吃饭");
}
```

重写要求：

方法名相同。

参数列表相同。

返回值类型兼容。

子类权限不能比父类更低。（public>protected>默认>private）
### 卡住的问题
- 容易用双重循环解决本来可以一层循环的问题。（26题可以用初始化常量的方式完成比较步骤）
- count 变量的作用域还需要判断。（计数器应在循环内还是循环外初始化取决于计数器的作用）
- 判断时机要注意：必须先统计完整，再判断。 （2784题中，判断应在循环以外完成）
- 边界情况容易漏，尤其是循环不执行但最后返回 true 的情况。（2784题中，数组为{1}等特殊情况）
#### 我现在的理解
- “遍历”不一定需要循环，
- 输出的“数量”类变量初始化并不一定从零开始。

##### 明天要复习或继续做
- 继续按当前 JavaSE 进度记录练习面向对象相关。
- 推进API与学习。
- 复盘面向对象后半部分内容，完善前半部分细节。

## 2026-05-15 Day2

### 今天学了什么

### 多态

父类引用指向子类对象

`Animal a = new Dog();`

多态的编译看左边，运行看右边：能调用什么方法看父类有没有，实际执行那个方法看子类有没有重写



### 抽象类

抽象类用于不够具体的父类：有此方法，但不用调用父类方法或需要规定格式。

- 抽象类不能new对象
- 抽象类用abstract修饰
- 子类必须重写抽象方法
- 抽象方法没有方法体

### 接口

作用相当于一个只有方法的抽象父类

```java
public interface Swimmable {
    void swim();
}
```

```java
public class Duck implements Flyable, Swimmable {
    @Override
    public void fly() {
        System.out.println("鸭子会飞");
    }

    @Override
    public void swim() {
        System.out.println("鸭子会游泳");
    }
}
```



- 需要类用implements实现接口
- 一个类可以实现多个接口
- 抽象方法默认public abstract

### 内部类

即写在一个类里面的类

常见匿名内部类，一般用于只用一次的接口实现，尤其和接口一起用

```java
public interface Swim {
    void swim();
}
```

```java
Swim s = new Swim() {
    @Override
    public void swim() {
        System.out.println("匿名对象在游泳");
    }
};

s.swim();
```

即临时创建一个实现了swim接口的对象



### 今天写了什么代码
- 今天完成了codex根据目前情况设置的zoo与bank练习，实践了面向对象的相关内容，详见package com.github.qichangfeng.javase.oop
- 今天刷的力扣题号为35、66、153（5.15每日一题），重复了二分遍历的思路与学习

### 卡住的问题
- 在一开始写二分遍历时非常卡手，原因是对于自己初始化的变量mid概念含糊不清
- int[] 默认值是 0。（66题中极端情况999...+1可以new新数组之后只输入首位为1，不用遍历填入0）
- 对于left与right两个标志性下标位置敏感度不够高，在不同的遍历逻辑中并不一定要同时从两边缩减界限，要依据情况判断（153中只有确定 mid 不可能是答案时，才能排除 mid，对mid进行加减操作）

### 我现在的理解
- if / else 只控制自己大括号里的代码，大括号外的代码会继续顺序执行。（35题中逻辑错误，只要没有return，循环内语句会顺序执行）
- Java 中 ^ 不是次方，而是按位异或。以后或许要少创造符号而是创造思路，争取熟练应用工具。
- mid 是下标，不是中间值。 nums[mid] 才是中间位置上的值。
- 二分要根据“答案是否可能是 mid”决定边界怎么更新。
- 二分不是只能找某个 target，二分也可以用来找： 第一个满足条件的位置、最后一个满足条件的位置、最小值所在区间、插入位置、边界


### 明天要复习或继续做
- 对多态需要更多使用理解，重刷5.14的26、27两题以及5.15的153
- 有余力的情况下推进集合学习