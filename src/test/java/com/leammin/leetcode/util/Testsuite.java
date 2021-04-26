package com.leammin.leetcode.util;

import com.google.common.collect.ImmutableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * 测试套件，封装多个测试用例
 *
 * @author Leammin
 * @date 2019-04-07
 */
public class Testsuite<PROBLEM> {
    private static final Logger logger = LoggerFactory.getLogger(Testsuite.class);

    private final List<Testcase<PROBLEM>> cases;
    private final int[] defaultCaseIndexes;

    /**
     * 不允许直接实例化，请使用Builder
     *
     * @param cases 测试用例
     */
    private Testsuite(List<Testcase<PROBLEM>> cases) {
        this(cases, new int[0]);
    }

    /**
     * 不允许直接实例化，请使用Builder
     *
     * @param cases          测试用例
     * @param defaultIndexes 默认执行测试用例的下标，为空表示执行所有测试用例
     */
    private Testsuite(List<Testcase<PROBLEM>> cases, int[] defaultIndexes) {
        this.cases = ImmutableList.copyOf(cases);
        this.defaultCaseIndexes = Arrays.copyOf(defaultIndexes, defaultIndexes.length);
    }

    /**
     * 测试测试用例，并返回执行时间
     *
     * @param solutionClass 解法class对象
     * @return 执行时间
     */
    public long test(Class<? extends PROBLEM> solutionClass) {
        return test(solutionClass, defaultCaseIndexes);
    }

    /**
     * 测试测试用例，并返回执行时间
     *
     * @param solutionClass 解法class对象
     * @param caseIndexes   执行测试用例的下标，为空表示执行所有测试用例
     * @return 执行时间
     */
    public long test(Class<? extends PROBLEM> solutionClass, int... caseIndexes) {
        if (isEmpty()) {
            return 0;
        }
        int[] indexes = caseIndexes(caseIndexes);
        long totalTime = 0;
        if (indexes.length == 0) {
            for (int i = 0, casesSize = cases.size(); i < casesSize; i++) {
                long time = testCase(solutionClass, i);
                totalTime += time;
            }
        } else {
            for (int i : indexes) {
                long time = testCase(solutionClass, i);
                totalTime += time;
            }
        }

        return totalTime;
    }

    private long testCase(Class<? extends PROBLEM> solutionClass, int i) {
        // 预热，先执行一遍，不做计时。
        runTest(solutionClass, i);
        long time = runTest(solutionClass, i);
        logger.debug("{} Testcase-{} Running Time: {}ms",
                solutionClass.getSimpleName(),
                String.format("%02d", i),
                BigDecimal.valueOf(time).divide(BigDecimal.valueOf(1000000), 6, RoundingMode.HALF_UP));
        return time;
    }

    private long runTest(Class<? extends PROBLEM> solutionClass, int i) {
        Testcase<PROBLEM> testcase = cases.get(i);
        try {
            return testcase.test(testcase.solution(solutionClass));
        } catch (Error error) {
            logger.error("{} Testcase-{} Running Error!",
                    solutionClass.getSimpleName(),
                    String.format("%02d", i)
            );
            throw error;
        }
    }

    private int[] caseIndexes(int[] caseIndexes) {
        if (caseIndexes == null || caseIndexes.length == 0) {
            return new int[0];
        }
        int[] indexes = new int[caseIndexes.length];
        int size = size();
        for (int i = 0; i < caseIndexes.length; i++) {
            indexes[i] = (caseIndexes[i] % size + size) % size;
        }
        return indexes;
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

        public Testsuite<PROBLEM> build(int... indexes) {
            List<Testcase<PROBLEM>> list = new ArrayList<>(indexes.length);
            return new Testsuite<>(list, indexes);
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

        public <OUTPUT> TestsuiteBuilder<PROBLEM> addExpected(Function<PROBLEM, OUTPUT> runner, OUTPUT expected) {
            return add(ExpectedTestcase.of(runner, expected));
        }


        public <OUTPUT> TestsuiteBuilder<PROBLEM> addAnyExpected(Function<PROBLEM, OUTPUT> runner, Iterable<OUTPUT> anyExpected) {
            return add(AnyExpectedTestcase.of(runner, anyExpected));
        }
    }
}
