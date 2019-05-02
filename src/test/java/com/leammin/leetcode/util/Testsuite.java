package com.leammin.leetcode.util;

import com.google.common.collect.ImmutableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试套件，封装多个测试用例
 *
 * @author Leammin
 * @date 2019-04-07
 */
public class Testsuite<PROBLEM> {
    private static final Logger logger = LoggerFactory.getLogger(Testsuite.class);

    private final List<Testcase<PROBLEM>> cases;

    /**
     * 不允许直接实例化，请使用Builder
     *
     * @param cases 测试用例
     */
    private Testsuite(List<Testcase<PROBLEM>> cases) {
        this.cases = ImmutableList.copyOf(cases);
    }

    /**
     * 测试测试用例，并返回平均时间
     *
     * @param clazz 解法class对象
     * @return 平均时间
     */
    public long test(Class<? extends PROBLEM> clazz) {
        long totalTime = 0;
        for (int i = 0, casesSize = cases.size(); i < casesSize; i++) {
            Testcase<PROBLEM> testcase = cases.get(i);
            PROBLEM solution = testcase.solution(clazz);
            long time = testcase.test(solution);
            logger.debug("{} 测试用例-{} 耗时: {}ms", clazz.getSimpleName(), String.format("%02d", i + 1), time / 1000000.0);
            totalTime += time;
        }
        return totalTime / cases.size();
    }

    /**
     * @return 测试用例的数量
     */
    public int size() {
        return cases.size();
    }

    /**
     * @return 测试用例是否是空的
     */
    public boolean isEmpty() {
        return cases.isEmpty();
    }

    /**
     * 测试套件的Builder
     *
     * @param <PROBLEM> 问题
     * @return 测试套件的Builder
     */
    public static <PROBLEM> TestsuiteBuilder<PROBLEM> builder() {
        return new TestsuiteBuilder<>();
    }

    /**
     * 测试套件Builder
     *
     * @param <PROBLEM> 问题
     */
    public final static class TestsuiteBuilder<PROBLEM> {
        private final List<Testcase<PROBLEM>> cases = new ArrayList<>();

        /**
         * @return 创建测试套件
         */
        public Testsuite<PROBLEM> build() {
            return new Testsuite<>(cases);
        }

        /**
         * 增加测试用例
         *
         * @param testcase 测试用例
         * @return 自身
         */
        public TestsuiteBuilder<PROBLEM> add(Testcase<PROBLEM> testcase) {
            cases.add(testcase);
            return this;
        }
    }
}
