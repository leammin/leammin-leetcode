package com.leammin.leetcode.util;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

public interface OutputTestcase<PROBLEM, OUTPUT> extends Testcase<PROBLEM> {
    OUTPUT expected();

    OUTPUT run(PROBLEM problem);

    @Override
    default void test(PROBLEM problem) {
        OUTPUT output = run(problem);
        OUTPUT expected = expected();

    }

    static <PROBLEM, OUTPUT> OutputTestcase<PROBLEM, OUTPUT> of(OUTPUT expected, Function<PROBLEM, OUTPUT> runner) {
        Objects.requireNonNull(runner);
        return new OutputTestcase<PROBLEM, OUTPUT>() {
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

    static <PROBLEM, OUTPUT> OutputTestcase<PROBLEM, OUTPUT> of(Supplier<OUTPUT> expected, Function<PROBLEM, OUTPUT> runner) {
        Objects.requireNonNull(expected);
        return of(expected.get(), runner);
    }
}
