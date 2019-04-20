package com.leammin.leetcode.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试套件，封装多个测试用例
 *
 * @author Leammin
 * @date 2019-04-07
 */
public class Testsuite<PROBLEM> {
    private final List<Testcase<PROBLEM>> cases;

    /**
     * 不允许直接实例化，请使用Builder
     *
     * @param cases 测试用例
     */
    private Testsuite(List<Testcase<PROBLEM>> cases) {
        this.cases = cases;
    }

    /**
     * 测试测试用例，并返回平均时间
     *
     * @param clazz 解法class对象
     * @return 平均时间
     */
    public long test(Class<? extends PROBLEM> clazz) {
        long time = 0;
        for (Testcase<PROBLEM> testcase : cases) {
            PROBLEM solution = testcase.solution(clazz);
            time += testcase.test(solution);
        }
        return time / cases.size();
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
    public static class TestsuiteBuilder<PROBLEM> {
        private final List<Testcase<PROBLEM>> cases = new ArrayList<>();
        private boolean built = false;

        /**
         * @return 创建测试套件
         */
        public Testsuite<PROBLEM> build() {
            built = true;
            return new Testsuite<>(cases);
        }

        /**
         * 增加测试用例
         *
         * @param testcase 测试用例
         * @return 自身
         */
        public TestsuiteBuilder<PROBLEM> add(Testcase<PROBLEM> testcase) {
            if (built) {
                throw new IllegalStateException("this builder is built");
            }
            cases.add(testcase);
            return this;
        }
    }
}
