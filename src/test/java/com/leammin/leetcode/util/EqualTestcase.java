package com.leammin.leetcode.util;

import org.assertj.core.api.Assertions;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 通过 output 和 expected 来判断是否成功的测试用例
 *
 * @param <PROBLEM>
 * @param <OUTPUT>
 */
public interface EqualTestcase<PROBLEM, OUTPUT> extends Testcase<PROBLEM> {
    /**
     * @return 期望输出
     */
    OUTPUT expected();

    /**
     * @param solution 执行解法后输出
     * @return
     */
    OUTPUT run(PROBLEM solution);

    default long test(PROBLEM solution) {
        OUTPUT expected = expected();

        long before = System.nanoTime();
        OUTPUT output = run(solution);
        long time = System.nanoTime() - before;

        Assertions.assertThat(output).as(ClassUtils.getSolutionName(solution)).isEqualTo(expected);

        return time;
    }

    static <PROBLEM, OUTPUT> EqualTestcase<PROBLEM, OUTPUT> of(
            Function<Class<? extends PROBLEM>, PROBLEM> solutionProducer,
            OUTPUT expected,
            Function<PROBLEM, OUTPUT> runner) {
        Objects.requireNonNull(solutionProducer, "solutionProducer cannot be null");
        Objects.requireNonNull(runner, "runner cannot be null");
        return new EqualTestcase<PROBLEM, OUTPUT>() {
            @Override
            public PROBLEM solution(Class<? extends PROBLEM> clazz) {
                return solutionProducer.apply(clazz);
            }

            @Override
            public OUTPUT expected() {
                return expected;
            }

            @Override
            public OUTPUT run(PROBLEM problem) {
                return runner.apply(problem);
            }
        };
    }

    static <PROBLEM, OUTPUT> EqualTestcase<PROBLEM, OUTPUT> of(
            OUTPUT expected,
            Function<PROBLEM, OUTPUT> runner) {
        return of(TestcaseUtils.defaultSolutionProducer(), expected, runner);
    }

    static <PROBLEM, OUTPUT> EqualTestcase<PROBLEM, OUTPUT> of(
            Function<Class<? extends PROBLEM>, PROBLEM> solutionProducer,
            Supplier<OUTPUT> expectedSupplier,
            Function<PROBLEM, OUTPUT> runner) {
        Objects.requireNonNull(expectedSupplier);
        return of(solutionProducer, expectedSupplier.get(), runner);
    }

    static <PROBLEM, OUTPUT> EqualTestcase<PROBLEM, OUTPUT> of(
            Supplier<OUTPUT> expectedSupplier,
            Function<PROBLEM, OUTPUT> runner) {
        Objects.requireNonNull(expectedSupplier);
        return of(expectedSupplier.get(), runner);
    }
}
