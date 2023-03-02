package com.leammin.leetcode.util.test;

import com.leammin.leetcode.util.ClassUtils;
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
public interface ExpectedTestcase<PROBLEM, OUTPUT> extends Testcase<PROBLEM> {
    /**
     * @return 期望输出
     */
    OUTPUT expected();

    /**
     * @param solution 解法
     * @return 执行解法后输出
     */
    OUTPUT run(PROBLEM solution);

    default long test(PROBLEM solution) {
        OUTPUT expected = expected();

        long before = System.nanoTime();
        OUTPUT output = run(solution);
        long time = System.nanoTime() - before;

        Assertions.assertThat(output).as(ClassUtils.getName(solution)).isEqualTo(expected);

        return time;
    }

    static <PROBLEM, OUTPUT> ExpectedTestcase<PROBLEM, OUTPUT> create(
            Function<Class<? extends PROBLEM>, PROBLEM> solutionProducer,
            Function<PROBLEM, OUTPUT> runner, OUTPUT expected
    ) {
        Objects.requireNonNull(solutionProducer, "solutionProducer cannot be null");
        Objects.requireNonNull(runner, "runner cannot be null");
        return new ExpectedTestcase<>() {
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

    static <PROBLEM, OUTPUT> ExpectedTestcase<PROBLEM, OUTPUT> createSupplier(
            Function<Class<? extends PROBLEM>, PROBLEM> solutionProducer,
            Function<PROBLEM, OUTPUT> runner, Supplier<OUTPUT> expected
    ) {
        return create(solutionProducer, runner, expected.get());
    }

    static <PROBLEM, OUTPUT> ExpectedTestcase<PROBLEM, OUTPUT> of(
            Function<PROBLEM, OUTPUT> runner, OUTPUT expected
    ) {
        return create(TestcaseUtils.defaultSolutionProducer(), runner, expected);
    }

    static <PROBLEM, OUTPUT> ExpectedTestcase<PROBLEM, OUTPUT> ofSupplier(
            Function<PROBLEM, OUTPUT> runner, Supplier<OUTPUT> expected
    ) {
        return createSupplier(TestcaseUtils.defaultSolutionProducer(), runner, expected);
    }
}
