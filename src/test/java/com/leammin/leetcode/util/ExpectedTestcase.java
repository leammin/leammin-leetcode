package com.leammin.leetcode.util;

import org.assertj.core.api.Assertions;

import java.util.Objects;
import java.util.function.Function;

/**
 * 通过 output 和 expected 来判断是否成功的测试用例
 *
 * @param <PROBLEM>
 * @param <OUTPUT>
 */
public interface ExpectedTestcase<PROBLEM, OUTPUT> extends Testcase<PROBLEM> {
    /**
     * @return 期望输出
     */
    OUTPUT expected();

    static <PROBLEM, OUTPUT> ExpectedTestcase<PROBLEM, OUTPUT> of(
            Function<Class<? extends PROBLEM>, PROBLEM> solutionProducer,
            OUTPUT expected,
            Function<PROBLEM, OUTPUT> runner
    ) {
        Objects.requireNonNull(solutionProducer, "solutionProducer cannot be null");
        Objects.requireNonNull(runner, "runner cannot be null");
        return new ExpectedTestcase<PROBLEM, OUTPUT>() {
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

    default long test(PROBLEM solution) {
        OUTPUT expected = expected();

        long before = System.nanoTime();
        OUTPUT output = run(solution);
        long time = System.nanoTime() - before;

        Assertions.assertThat(output).as(ClassUtils.getName(solution)).isEqualTo(expected);

        return time;
    }

    static <PROBLEM, OUTPUT> ExpectedTestcase<PROBLEM, OUTPUT> of(
            OUTPUT expected,
            Function<PROBLEM, OUTPUT> runner
    ) {
        return of(TestcaseUtils.defaultSolutionProducer(), expected, runner);
    }

    /**
     * @param solution 解法
     * @return 执行解法后输出
     */
    OUTPUT run(PROBLEM solution);
}
