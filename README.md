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


## 2026-05-16 Day3

### 今天学了什么
基本扎实面向对象基础，完成常用API复盘

一点基础知识扫盲

### return

return 是方法把结果交还给调用者的方式。

return 会结束方法。
有返回值的方法，return 后面要跟一个值。
void 方法可以写 return;，但不能 return 值。
方法返回的值，外面要用变量接住，或者直接使用。
只写 change(a); 不会自动改变 a。
写 a = change(a); 才是用返回值更新 a。

### 基本数据类型

八大基本数据类型

```
byte     整数，范围最小
short    整数
int      整数，最常用
long     整数，范围更大
float    单精度小数
double   双精度小数，最常用
char     单个字符
boolean  true / false
```

​    变量里直接存值
​    赋值复制值
​    == 比较值
​    默认值不是 null

### 引用数据类型

​    String、数组、类、接口、对象
​    变量里存对象地址
​    赋值复制地址
​    == 比较地址
​    默认值是 null

Java 方法传参时，传进去的不是变量本身，而是变量里面的值的一份复制。

### final

final 即最终的、不能变的。

------

修饰变量时变量一旦赋值，不能再改。

常量通常这样写：

```java
public static final int MAX_SCORE = 100; 
```

为什么是 static final？

```java
static：属于类，不需要创建对象 final：不能被修改 
```

调用：

```java
System.out.println(Student.MAX_SCORE); 
```

------

修饰方法时方法不能被子类重写。

理解：final 方法 = 不允许子类改写

修饰类时类不能被继承。

```java
public final class String { } 
```

所以 Java 的 String 类不能被继承。

理解：final 类 = 到此为止，不能有子类

## API

### String

String是一个类

在比较字符串内容时不能用s1==s2

要用s1.equals(s2)

忽略大小写比较用s1.equalsIgnoreCase(s2)

```java
获取长度String str = "hello";

System.out.println(str.length());
```

```java
数组长度获取为arr.length//属性
字符串是str.length()//方法
```

遍历字符串

```java
charAt(index)
```

```java
String str = "hello";

for (int i = 0; i < str.length(); i++) {
    char c = str.charAt(i);
    System.out.println(c);
}
```

查找：判断是否包含

```java
String str = "hello java";

System.out.println(str.contains("java")); // true
```

```java
查找第一次出现的位置，没有则返回-1：
System.out.println(str.indexOf("java")); // 6
```

截取

```java
String str = "hello java";
//从指定位置截取到最后
String s1 = str.substring(6);
System.out.println(s1); // java
//截取指定范围
String s2 = str.substring(0, 5);
System.out.println(s2); // hello

substring(开始下标, 结束下标)
包含开始，不包含结束
```

替换

```java
String str = "hello java";

String newStr = str.replace("java", "mysql");

System.out.println(newStr); // hello mysql、

注意：String 不可变。
str.replace("java", "mysql");
System.out.println(str); // 还是 hello java
```



以下用法少见

分割

```java
String str = "张三,李四,王五";

String[] names = str.split(",");

for (int i = 0; i < names.length; i++) {
    System.out.println(names[i]);
}
```

此时输出

```java
张三
李四
王五
```

判断开头结尾

```java
String file = "test.java";

System.out.println(file.endsWith(".java")); // true
System.out.println(file.startsWith("test")); // true
```

去掉前后空格

```java
String str = "  hello  ";

System.out.println(str.trim()); // hello
```

### StringBuilder

在频繁拼接的场景中，String会创建很多用不上的新字符串，此时使用方法append（），会直接生成一个空间，拼接后续字符串

```java
StringBuilder sb = new StringBuilder();

for (int i = 0; i < 100; i++) {
    sb.append(i);
}

String result = sb.toString();//StringBuilder创建一个空间，toString（）方法为创建一个对象接受空间内内容
```

反转

```java
String str = "abc";

String reversed = new StringBuilder(str).reverse().toString();//链式编程

System.out.println(reversed); // cba
```

### 今天写了什么代码
- leetcode二刷35,66题，新攻破154题
- 在school包中再次熟悉多态框架，虽然还是感觉理解没到位，但目前的水平也很难再有新理解，选择推进学习

### 卡住的问题
- 对二分遍历的左右边界理解有待加强在154题一开始通过的代码中，我的代码最后可能使右边界一直减到-1，这不合法。
- 二刷66题“加一”时我没有写清连续进一的框架，它应该是先判断是否进一，当位变化之后要继续判断下一位并在合适的位置停止。
- 在继承的基础上改写并练习多态时出现结构性问题，需要明确整体结构后按先父类再子类的路径完成需求。

### 我现在的理解
- 在寻找元素这样的题目中，while条件更多的会用到=而非单独的大于或小于
- 153与154的区别在升序数组的元素会不会有重复，这会让最差情况的二分遍历的时间复杂度与直接遍历一样变成O（n），但在大部分正常情况下会是O（logn），有的需求里面不会写的隐性条件需要认真体会差距才能完成。

### 明天要复习或继续做
- 完成StringBuilder练习，进入ArrayList
- 能在不看思路与示例的情况下做出66题


## 2026.05.17  Day4

### ArrayList

普通数组：

```java
int[] arr = new int[3];
```

长度固定，创建之后不能变。

ArrayList：

```java
ArrayList<String> list = new ArrayList<>();//尖括号内为泛型，String即存字符串
```

可以不断 add，长度会变。

```java
ArrayList<Integer> nums = new ArrayList<>();//整数
```

集合里不能直接写基本数据类型而是包装类，常见对应关系如下

`int     -> Integer`
`double  -> Double`
`char    -> Character`
`boolean -> Boolean`

增：add

```java
ArrayList<String> list = new ArrayList<>();

list.add("Java");
list.add("MySQL");
list.add("Spring");
```

如果要在指定位置添加，则

```java
list.add(1, "Redis");
```

该下标不可越界，只能在0到加上该内容本身所能包含的范围

删：remove

```java
list.remove("MySQL");//按元素删除
```

```java
list.remove(0);//按下标删除
```

需要注意

```java
ArrayList<Integer> nums = new ArrayList<>();
nums.add(10);
nums.add(20);
nums.add(30);

nums.remove(1);//这里删除的是下标1，即20
//如果想删除数字20，形如
nums.remove(Integer.valueOf(20));
```

改：set

```java
list.set(1, "Redis");//把下标1的元素改成Redis
```

查：get

```java
String name = list.get(0);//获取下标0的元素
```

获取长度

```java
list.size()
```

判断是否包含

```java
boolean exists = list.contains("Java");//判断集合中是否包含此字符串
```

判断是否为空

```java
if (list.isEmpty()) {
    System.out.println("集合为空");
}
```

清空集合

```java
list.clear();
```

## 2026.05.18 Day5

###### 2026.5.18

![插入图片方法](E:\1\Documents\JavaSE\ScreenShot_2026-05-18_151019_687.png)

严肃学习插入图片

###  Math 类

Math 是数学工具类，里面的方法基本都是 static，所以直接用类名调用。

```java
Math.abs(-10);      // 绝对值，10 
Math.max(10, 20);   // 两者最大值，20 
Math.min(10, 20);   // 最小值，10 
Math.pow(2, 3);     // 2 的 3 次方，8.0 
Math.sqrt(16);      // 平方根，4.0 
Math.ceil(3.2);     // 向上取整，4.0 
Math.floor(3.8);    // 向下取整，3.0 
Math.round(3.5);    // 四舍五入，4 
Math.random();      // [0.0, 1.0) 随机小数
```

### System 类

获取当前时间毫秒值(UTF-8即东八区标准时)

```java
long start = System.currentTimeMillis(); 
// 执行一些代码 long end = System.currentTimeMillis(); System.out.println("耗时：" + (end - start) + "毫秒");
```

常用于简单统计代码运行时间。

数组拷贝

```java
int[] src = {1, 2, 3, 4, 5}; 
int[] dest = new int[5]; 
System.arraycopy(src, 0, dest, 0, 5);
//System.arraycopy(源数组, 源数组起始位置, 目标数组, 目标数组起始位置, 拷贝个数);
```

退出程序

```java
System.exit(0);
```

### Runtime 类

Runtime 表示 Java 程序运行时环境。

获取 Runtime 对象：

```java
Runtime runtime = Runtime.getRuntime();
```

常见方法：

```java
runtime.availableProcessors(); // 获取 CPU 线程数 
runtime.maxMemory();           // JVM 最大可用内存 
runtime.totalMemory();         // JVM 当前总内存 
runtime.freeMemory();          // JVM 当前空闲内存
```

### Object 类

Object 是 Java 中所有类的顶级父类。

也就是说，任何类默认都继承 Object。

```
public class Student { }
```

本质上可以理解为：

```
public class Student extends Object { }
```

所以所有对象都有 Object 里的方法

toString()

默认情况下，直接打印对象：

```
Student s = new Student(); System.out.println(s);
```

如果没有重写 toString()，输出通常类似：

```
com.xxx.Student@1b6d3586
```

这是类名 + 地址相关信息。

所以可以重写 toString()：

```java
public class Student {
	private String name;    
   	private int age;
	@Override
	public String toString() {
		return"Student{name='" + name + "', age=" + age + "}";
	} 
}
```

这样打印对象时更清楚。

equals()

默认的 equals() 比较的是对象地址，和 == 类似。

```java
Student s1 = new Student("张三", 18); 
Student s2 = new Student("张三", 18); 
System.out.println(s1 == s2);      // false 
System.out.println(s1.equals(s2)); // 默认也是 false
```

因为 s1 和 s2 是两个不同对象。

如果想按照内容比较，需要重写 equals()。

String 已经重写了 equals，所以字符串比较内容用 equals。 自定义类如果不重写 equals，默认比较地址。

###  Objects 类

Objects 是工具类，常用于安全比较和判空。

需要导包：

```java
import java.util.Objects;
```

安全比较

```java
Objects.equals(a, b);
```

它相对object里的equals的好处是可以避免空指针异常。

比如：

```java
String a = null; String b = "java"; 
System.out.println(Objects.equals(a, b)); // false
```

如果写：

```java
a.equals(b);
```

会报空指针异常，因为 a 是 null。

------

判断是否为空

```java
Objects.isNull(obj); Objects.nonNull(obj);
```

例子：

```java
String str = null; 
System.out.println(Objects.isNull(str));  // true 
System.out.println(Objects.nonNull(str)); // false
```

------

### 克隆

克隆就是复制一个对象。

原对象 -> 复制出一个新对象

浅克隆会复制对象本身，但如果对象里面有引用类型成员变量，引用对象不会被真正复制。基本数据类型的数据会保留，引用数据类型的数据会指向同一地址，被克隆的数据改变，克隆之后的数据也会一起改变。

深克隆会把对象内部引用的对象也一起复制。即创建一个新的引用数据类型对象，并按照被克隆的对象赋值。

所以两个对象完全独立。