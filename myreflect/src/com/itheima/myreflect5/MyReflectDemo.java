package com.itheima.myreflect5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class MyReflectDemo {
    public static void main(String[] args) throws IllegalAccessException, IOException {
        //对于任意一个对象，都可以把对象所有的字段名和值，保存到文件中去
        Student student = new Student("zhangsan", 15, "man");
        Teacher teacher = new Teacher("liyan", 4000);

        saveObject(student);
    }

    public static void saveObject(Object object) throws IllegalAccessException, IOException {
        Class class1 = object.getClass();

        BufferedWriter bw = new BufferedWriter(new FileWriter
                ("myreflect/src/com/itheima/myreflect5/saveTarget.txt"));
        Field[] fields = class1.getDeclaredFields();
        for(Field field : fields) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = field.get(object);
            String message = fieldName + ":" + value;
            bw.write(message);
            bw.newLine();
        }
        bw.close();
    }
}
