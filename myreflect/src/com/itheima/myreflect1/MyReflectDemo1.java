package com.itheima.myreflect1;

public class MyReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        /*
        获取class对象的三种方式：
        1.Class.forName("全类名");
        2.类名.class
        3.对象.getClass();
         */

        Class class1 = Class.forName("com.itheima.myreflect1.Student");

        Class class2 = Student.class;

        Student stu = new Student();
        Class class3 = stu.getClass();

        System.out.println(class1 == class2);
        System.out.println(class1 == class3);
    }
}
