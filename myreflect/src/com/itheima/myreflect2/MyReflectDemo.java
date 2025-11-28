package com.itheima.myreflect2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

public class MyReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        /*
        C1ass类中用于获取构造方法的方法
        Constructor<?>[] getConstructors()                                      返回所有公共构造方法对象的数组
        Constructor<?>[]getDeclaredConstructors()                               返回所有已声明构造方法对象的数组
        Constructor<T> getConstructor(Class<?>... parameterTypes)               返回单个公共构造方法对象
        Constructor<T>getDeclaredconstructor(Class<?>... parameterTypes)        返回单个已声明构造方法对象

        Constructor类中用于创建对象的方法
        T newInstance(object...initargs)                                        根据指定的构造方法创建对象
        setAccessible(boolean flag)                                             设置为true，表示取消访问检查
         */

        Class class1 = Class.forName("com.itheima.myreflect2.Student");

        Constructor[] constructors1 = class1.getConstructors();
        Constructor[] constructors2 = class1.getDeclaredConstructors();

        Constructor constructor1 = class1.getConstructor();
        System.out.println(constructor1);

        Constructor constructor2 = class1.getConstructor(String.class);
        System.out.println(constructor2);

        Constructor constructor3 = class1.getDeclaredConstructor(int.class);
        System.out.println(constructor3);

        Constructor constructor4 = class1.getDeclaredConstructor(String.class, int.class);
        System.out.println(constructor4);

        int modifiers = constructor4.getModifiers();
        System.out.println(modifiers);
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println();

        Parameter[] parameters = constructor4.getParameters();
        for(Parameter parameter: parameters){
            System.out.println(parameter);
        }

        //暴力反射: 表示临时取消权限校验
        constructor4.setAccessible(true);
        Student stu = (Student) constructor4.newInstance("zhangsan", 23);
        System.out.println(stu);
    }
}
