package com.github.qichangfeng.javase.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListPractice {
    public static void main(String[] args) {
        ArrayList<CollectionStudent> students = createStudents();

        System.out.println("所有学生：");
        printStudents(students);

        System.out.println("最高分学生：");
        CollectionStudent top = getTopStudent(students);
        top.showInfo();

        System.out.println("删除低于60分的学生后：");
        removeFailedStudents(students);
        printStudents(students);

        System.out.println("修改张三的分数后：");
        updateScoreByName(students, "张三", 95);
        printStudents(students);
    }

    public static ArrayList<CollectionStudent> createStudents() {
        // TODO 1: 创建 ArrayList<CollectionStudent>
        ArrayList<CollectionStudent> students =new ArrayList<>();
        // TODO 2: 添加 5 个学生：
        // 张三 18 80
        students.add(new CollectionStudent("张三",18,80));
        // 李四 19 55
        students.add(new CollectionStudent("李四",19,55));
        // 王五 20 90
        students.add(new CollectionStudent("王五",20,90));
        // 赵六 21 45
        students.add(new CollectionStudent("赵六",21,45));
        // 小明 18 70
        students.add(new CollectionStudent("小明",18,70));
        // TODO 3: return 集合
        return students;
    }

    public static void printStudents(ArrayList<CollectionStudent> students) {
        // TODO 4: 使用普通 for 遍历 students
        for (int i = 0; i < students.size(); i++) {
            students.get(i).showInfo();
        }
        // 提示：students.get(i).showInfo();
    }

    public static CollectionStudent getTopStudent(ArrayList<CollectionStudent> students) {
        // TODO 5: 找最高分学生并返回
        // 提示：
        // 1. 先假设第 0 个学生是最高分
        CollectionStudent top = students.get(0);
        // 2. 从第 1 个学生开始遍历
        for (int i = 1; i < students.size(); i++) {
            if(students.get(i).getScore()>top.getScore()){
                // 3. 如果当前学生分数更高，就更新最高分学生
                top=students.get(i);
            }
        }

        return top;
    }

    public static void removeFailedStudents(ArrayList<CollectionStudent> students) {
        // TODO 6: 使用 Iterator 删除 score < 60 的学生
        Iterator<CollectionStudent> it = students.iterator();
        while (it.hasNext()) {
             CollectionStudent student = it.next();
             if(student.getScore()<60){
                 it.remove();
             }
        }
    }

    public static void updateScoreByName(ArrayList<CollectionStudent> students, String name, int newScore) {
        // TODO 7: 根据姓名修改分数
        // 提示：
        // 1. 遍历集合
        for (int i = 0; i < students.size(); i++) {
            // 2. 使用 student.getName().equals(name) 判断名字
            if(students.get(i).getName().equals(name)){
                // 3. 找到后调用 student.setScore(newScore)
                students.get(i).setScore(newScore);
                break;
            }
        }
    }
}
