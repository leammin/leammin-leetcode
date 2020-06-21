package com.leammin.leetcode.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Execute {
    /**
     * @return 是否执行此解法，默认执行
     */
    boolean value() default true;

    /**
     * @return 将执行的测试用例下标，默认执行所有测试用例
     */
    int[] cases() default {};
}
