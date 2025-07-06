package com.itheima.a04mytreemap;

import java.util.TreeMap;

public class A02_TreeMapDemo2 {
    public static void main(String[] args) {
        Student s1 = new Student("zhangsan", 18);
        Student s2 = new Student("lisi", 22);
        Student s3 = new Student("wangwu", 23);

        TreeMap<Student, String> tm = new TreeMap<Student, String>();

        tm.put(s1, "hebei");
        tm.put(s2, "heilongjiang");
        tm.put(s3, "xinjiang");

        System.out.println(tm);
    }
}

class Student implements Comparable<Student>{
    private String name;
    private int age;

    public Student(){}

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    @Override
    public int compareTo(Student o){
        int result = this.getAge() - o.getAge();
        result = result == 0 ? this.getName().compareTo(o.getName()) : result;
        return result;
    }

    @Override
    public String toString(){
        return "Student{name = " + name + ", age = " + age + "}";
    }
}
