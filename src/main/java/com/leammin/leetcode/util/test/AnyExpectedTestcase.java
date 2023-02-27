package com.leammin.leetcode.util.test;

import com.leammin.leetcode.util.ClassUtils;
import org.assertj.core.api.Assertions;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 通过 output 和 任意一个expected 来判断是否成功的测试用例
 *
 * @param <PROBLEM>
 * @param <OUTPUT>
 */
public interface AnyExpectedTestcase<PROBLEM, OUTPUT> extends Testcase<PROBLEM> {
    /**
     * @return 期望输出
     */
    Iterable<OUTPUT> anyExpected();

    /**
     * @param solution 解法
     * @return 执行解法后输出
     */
    OUTPUT run(PROBLEM solution);

    default long test(PROBLEM solution) {
        Iterable<OUTPUT> anyExpected = anyExpected();

        long before = System.nanoTime();
        OUTPUT output = run(solution);
        long time = System.nanoTime() - before;

        Assertions.assertThat(output).as(ClassUtils.getName(solution)).isIn(anyExpected);

        return time;
    }

    static <PROBLEM, OUTPUT> AnyExpectedTestcase<PROBLEM, OUTPUT> create(
            Function<Class<? extends PROBLEM>, PROBLEM> solutionProducer,
            Function<PROBLEM, OUTPUT> runner, Iterable<OUTPUT> anyExpected
    ) {
        Objects.requireNonNull(solutionProducer, "solutionProducer cannot be null");
        Objects.requireNonNull(runner, "runner cannot be null");
        return new AnyExpectedTestcase<>() {
            @Override
            public PROBLEM solution(Class<? extends PROBLEM> clazz) {
                return solutionProducer.apply(clazz);
            }

            @Override
            public Iterable<OUTPUT> anyExpected() {
                return anyExpected;
            }

            @Override
            public OUTPUT run(PROBLEM problem) {
                return runner.apply(problem);
            }
        };
    }

    static <PROBLEM, OUTPUT> AnyExpectedTestcase<PROBLEM, OUTPUT> createSupplier(
            Function<Class<? extends PROBLEM>, PROBLEM> solutionProducer,
            Function<PROBLEM, OUTPUT> runner, Supplier<Iterable<OUTPUT>> anyExpected
    ) {
        return create(solutionProducer, runner, anyExpected.get());
    }

    static <PROBLEM, OUTPUT> AnyExpectedTestcase<PROBLEM, OUTPUT> of(
            Function<PROBLEM, OUTPUT> runner, Iterable<OUTPUT> anyExpected
    ) {
        return create(TestcaseUtils.defaultSolutionProducer(), runner, anyExpected);
    }

    static <PROBLEM, OUTPUT> AnyExpectedTestcase<PROBLEM, OUTPUT> ofSupplier(
            Function<PROBLEM, OUTPUT> runner, Supplier<Iterable<OUTPUT>> anyExpected
    ) {
        return createSupplier(TestcaseUtils.defaultSolutionProducer(), runner, anyExpected);
    }
}
