package com.example.utils;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Method;

public class StrUtils {

    public static void getMethodList(Class clazz) {
        Method[] methods = clazz.getMethods();
        for (int i = 0, len = methods.length; i < len; i++) {
            String name = methods[i].getName();
            Class<?>[] parameterTypes = methods[i].getParameterTypes();
            System.out.println("methodName:" + name + ", parameterType:" + JSON.toJSONString(parameterTypes));
        }
    }
}
