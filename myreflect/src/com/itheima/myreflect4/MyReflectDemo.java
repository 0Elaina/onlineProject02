package com.itheima.myreflect4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class MyReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        /*
        c1ass类中用于获取成员方法的方法
        Method[]getMethods()：                                                   返回所有公共成员方法对象的数组，包括继承的
        Method[]getDeclaredMethods()：                                           返回所有成员方法对象的数组，不包括继承的
        Method getMethod(String name, Class<?>... parameterTypes):               返回单个公共成员方法对象
        Method getDeclaredMethod(String name, Class<?>... parameterTypes):       返回单个成员方法对象

        Method类中用于创建对象的方法
        Object invoke(object obj,Object...args):        运行方法
        参数一：用obj对象调用该方法
        参数二：调用方法的传递的参数（如果没有就不写）
        返回值：方法的返回值（如果没有就不写）


        获取方法的修饰符
        获取方法的名字
        获取方法的形参
        获取方法的返回值
        获取方法的抛出的异常
         */
        Class class1 = Class.forName("com.itheima.myreflect4.Student");

        Method[] methods1 = class1.getMethods();
        Method[] methods2 = class1.getDeclaredMethods();

        Method method1 = class1.getMethod("sleep");
        System.out.println(method1);

        Method method2 = class1.getDeclaredMethod("eat", String.class);
        System.out.println(method2);

        //        获取方法的修饰符
        int modifiers = method2.getModifiers();
        System.out.println("modifiers: " + modifiers);

        //        获取方法的名字
        String methodName = method2.getName();
        System.out.println("methodName: " + methodName);

        //        获取方法的形参
        Parameter[] parameters = method2.getParameters();
        for(Parameter parameter: parameters){
            System.out.println("parameter: " + parameter);
        }

        //方法运行
        Student stu = new Student();
        method2.setAccessible(true);
        String returnResult = (String) method2.invoke(stu, "hamburger");
        //        获取方法的返回值
        System.out.println("return: " + returnResult);

        //        获取方法的抛出的异常
        Class[] exceptions = method2.getExceptionTypes();
        for(Class exception: exceptions){
            System.out.println("exception: " + exception);
        }
    }
}
