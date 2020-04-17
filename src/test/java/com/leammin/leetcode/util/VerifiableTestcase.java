package com.leammin.leetcode.util;

import org.assertj.core.api.Assertions;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Leammin
 * @date 2019-05-02
 */
public interface VerifiableTestcase<PROBLEM, OUTPUT> extends Testcase<PROBLEM> {
    /**
     * 验证输出是否正确
     *
     * @param output 输出
     * @return 是否正确
     */
    boolean verify(OUTPUT output);

    /**
     * @param solution 解法
     * @return 执行解法后输出
     */
    OUTPUT run(PROBLEM solution);

    static <PROBLEM, OUTPUT> VerifiableTestcase<PROBLEM, OUTPUT> of(
            Function<Class<? extends PROBLEM>, PROBLEM> solutionProducer,
            Function<PROBLEM, OUTPUT> runner, Predicate<OUTPUT> verifier
    ) {
        return new VerifiableTestcase<PROBLEM, OUTPUT>() {
            @Override
            public boolean verify(OUTPUT output) {
                return verifier.test(output);
            }

            @Override
            public OUTPUT run(PROBLEM solution) {
                return runner.apply(solution);
            }

            @Override
            public PROBLEM solution(Class<? extends PROBLEM> clazz) {
                return solutionProducer.apply(clazz);
            }
        };
    }

    static <PROBLEM, OUTPUT> VerifiableTestcase<PROBLEM, OUTPUT> of(
            Function<PROBLEM, OUTPUT> runner, Predicate<OUTPUT> verifier
    ) {
        return of(TestcaseUtils.defaultSolutionProducer(), runner, verifier);
    }

    static <PROBLEM, OUTPUT> VerifiableTestcase<PROBLEM, OUTPUT> ofConsumer(
            Function<PROBLEM, OUTPUT> runner, Consumer<OUTPUT> verifier
    ) {
        return of(runner, output -> {
            verifier.accept(output);
            return true;
        });
    }

    @Override
    default long test(PROBLEM solution) {
        long before = System.nanoTime();
        OUTPUT output = run(solution);
        long time = System.nanoTime() - before;

        boolean result = verify(output);
        Assertions.assertThat(result).as(ClassUtils.getName(solution)).isTrue();

        return time;
    }
}
