package com.itheima.myreflect3;

import java.lang.reflect.Field;

public class MyReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        /*
        class类中用于获取成员变量的方法
        Field[] getFields():                        返回所有公共成员变量对象的数组
        Field[] getDeclaredFields():                返回所有成员变量对象的数组
        Field getField(String name):                返回单个公共成员变量对象
        FieldgetDeclaredField(String name):          返回单个成员变量对象

        Fie1d类中用于创建对象的方法
        void set(Object obj,Object value):          赋值
        Object get(object obj)                      获取值
         */
        Class class1 = Class.forName("com.itheima.myreflect3.Student");

        Field[] fileds1 = class1.getFields();
        Field[] fields2 = class1.getDeclaredFields();

        Field field1 = class1.getField("name");
        System.out.println(field1);

        Field field2 = class1.getDeclaredField("age");
        System.out.println(field2);

        Field field3 = class1.getDeclaredField("gender");
        System.out.println(field3);
        System.out.println();
        System.out.println("------------------------");
        System.out.println();

        //获取权限修饰符
        int modifiers = field1.getModifiers();
        System.out.println("modifiers: " + modifiers);
        //获取成员变量的名字
        String fieldName = field1.getName();
        System.out.println("fieldName: " + fieldName);
        //获取成员变量的数据类型
        Class<?> fieldType = field1.getType();
        System.out.println("fieldType: " + fieldType);
        //获取成员变量记录的值
        Student stu = new Student("zhangsan", 23, "man");
        field3.setAccessible(true);
        String gender = (String) field3.get(stu);
        System.out.println("gender: " + gender);
        //修改成员变量记录的值
        field3.set(stu, "woman");
        System.out.println(stu);
    }
}
