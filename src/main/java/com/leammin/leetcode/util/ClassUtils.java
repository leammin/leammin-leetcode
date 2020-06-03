package com.leammin.leetcode.util;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Leammin
 * @date 2019-04-07
 */
public class ClassUtils {
    private ClassUtils() {
    }

    /**
     * 根据参数获取实例
     * @param clazz 类型class对象
     * @param args 参数
     * @param <T> 泛型
     * @return 实例
     */
    @SuppressWarnings("unchecked")
    public static <T> T newInstance(Class<? extends T> clazz, Object ... args) {
        Class<?>[] argClasses = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            argClasses[i] = args[i].getClass();
        }
        try {
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                constructor.setAccessible(true);
                if (constructor.getParameterCount() != args.length) {
                    continue;
                }
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                boolean equals = true;
                for (int i = 0; i < parameterTypes.length; i++) {
                    Class<?> argClass = argClasses[i];
                    if (parameterTypes[i].isPrimitive() && org.apache.commons.lang3.ClassUtils.isPrimitiveOrWrapper(argClass)) {
                        argClass = org.apache.commons.lang3.ClassUtils.wrapperToPrimitive(argClass);
                    }
                    if (parameterTypes[i] != argClass) {
                        equals = false;
                        break;
                    }
                }
                if (!equals) {
                    continue;
                }
                return (T) constructor.newInstance(args);
            }
            throw new NoSuchMethodException();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * @param solution 解法class
     * @return 解法名称：问题名称$解法
     */
    public static String getName(Class<?> solution) {
        String name = solution.getName();
        name = name.substring(name.lastIndexOf(".") + 1);
        return name;
    }

    /**
     * @param solution 解法
     * @return 解法名称：问题名称$解法
     */
    public static String getName(Object solution) {
        return getName(solution.getClass());
    }
}
