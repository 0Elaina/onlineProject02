package com.itheima.a02myhashmap;

import java.util.HashMap;
import java.util.Objects;

public class A01_HashMapDemo1 {
    public static void main(String[] args) {
        /*
        需求：创建一个HashMap集合，键是学生对象(Student)，值是籍贯(String)。
        存储三个键值对元素，并遍历
        要求：同姓名，同龄认为是同一个学生
         */
        HashMap<Student, String> map = new HashMap<>();

        Student s1 = new Student("zhangsan", 18);
        Student s2 = new Student("lisi", 19);
        Student s3 = new Student("wangwu", 20);
        Student s4 = new Student("wangwu", 20);

        map.put(s1, "anhui");
        map.put(s2, "shandong");
        map.put(s3, "henan");
        map.put(s4, "guangdong");

        map.forEach((key, value) -> System.out.println(key + " : " + value));

    }
}

class Student {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String toString(){
        return "Student{name = " + name + ", age = " + age + "}";
    }
}
