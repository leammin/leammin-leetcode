package com.leammin.leetcode.util;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Function;

/**
 * @author Leammin
 * @date 2019-04-07
 */
class TestcaseUtils {
    /**
     * @param <PROBLEM> 问题
     * @return 直接调用无参构造方法获取解法实例
     */
    static <PROBLEM> Function<Class<? extends PROBLEM>, PROBLEM> defaultSolutionProducer() {
        return clazz -> {
            try {
                return clazz.getDeclaredConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
