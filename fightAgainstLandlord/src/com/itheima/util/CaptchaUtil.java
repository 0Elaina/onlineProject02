package com.itheima.util;

import java.time.Instant;
import java.util.Random;

public class CaptchaUtil {
    public static String getCaptcha() {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        while (sb.toString().length() < 4) {
            int num = r.nextInt(123);
            if (getRightNum(num)) sb.append((char) num);
        }
        return sb.toString();
    }

    public static boolean getRightNum(int num) {
        return (num >= 97 && num <= 122) || (num >= 65 && num <= 90) || (num >= 48 && num <= 57);
    }
}
