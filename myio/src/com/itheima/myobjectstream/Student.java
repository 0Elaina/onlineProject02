package com.itheima.myobjectstream;

import java.io.Serial;
import java.io.Serializable;

/*
 * Serializable接口里面是没有抽象方法，标记型接口
 * 一旦实现了这个接口，那么就表示当前的student类可以被序列化
 */
public class Student implements Serializable{
    @Serial
    private static final long serialVersionUID = -5890135746201264030L;

    private String name;
    private int age;
    //transient：瞬态关键字
    //作用：不会把当前属性序列化到本地文件当中
    private transient String address;

    public Student(){}

    public Student(String name, int age, String address){
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){}

    public String toString(){
        return "Student{name = " + name + ", age = " + age + ", address = " + address + "}";
    }
}
