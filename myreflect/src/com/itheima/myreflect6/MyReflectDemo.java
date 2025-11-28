package com.itheima.myreflect6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class MyReflectDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //反射可以跟配置文件结合的方式，动态的创建对象，并调用方法

        //读取配置文件中的信息
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("myreflect/src/com/itheima/myreflect6/prop.properties");
        prop.load(fis);
        fis.close();

        String className = prop.get("classname").toString();
        String methodName = prop.get("method").toString();

        Class class1 = Class.forName(className);
        Method method = class1.getMethod(methodName);

        Constructor constructor = class1.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        Student stu = (Student) constructor.newInstance("zhangsan", 23);
        method.invoke(stu);
    }
}
