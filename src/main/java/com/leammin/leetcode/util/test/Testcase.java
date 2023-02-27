package com.leammin.leetcode.util.test;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.ToLongFunction;

/**
 * 单个测试用例
 *
 * @param <PROBLEM> 问题
 */
public interface Testcase<PROBLEM> {
    /**
     * 获取解法的实例
     *
     * @param clazz 解法的class对象
     * @return 解法实例
     */
    PROBLEM solution(Class<? extends PROBLEM> clazz);

    /**
     * 测试解法
     *
     * @param solution 解法实例
     * @return 执行时间
     */
    long test(PROBLEM solution);

    /**
     * 获取测试用例
     *
     * @param solutionProducer solution()方法的函数式实例
     * @param tester           test()方法的函数式实例
     * @param <PROBLEM>        问题
     * @return 测试用例实例
     */
    static <PROBLEM> Testcase<PROBLEM> create(
            Function<Class<? extends PROBLEM>, PROBLEM> solutionProducer,
            ToLongFunction<PROBLEM> tester) {
        Objects.requireNonNull(solutionProducer, "solutionProducer cannot be null");
        Objects.requireNonNull(tester, "tester cannot be null");
        return new Testcase<PROBLEM>() {
            @Override
            public PROBLEM solution(Class<? extends PROBLEM> clazz) {
                return solutionProducer.apply(clazz);
            }

            @Override
            public long test(PROBLEM solution) {
                return tester.applyAsLong(solution);
            }
        };
    }

    /**
     * 获取测试用例，默认直接调用无参构造方法获取解法实例
     *
     * @param tester    test()方法的函数式实例
     * @param <PROBLEM> 问题
     * @return 测试用例实例
     */
    static <PROBLEM> Testcase<PROBLEM> of(ToLongFunction<PROBLEM> tester) {
        return create(TestcaseUtils.defaultSolutionProducer(), tester);
    }
}
