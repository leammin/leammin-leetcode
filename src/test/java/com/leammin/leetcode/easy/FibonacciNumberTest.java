package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-04-03
 */
class FibonacciNumberTest extends AbstractTest<FibonacciNumber> {
    @Override
    protected Testsuite<FibonacciNumber> testsuite() {
        return Testsuite.<FibonacciNumber>builder()
                .addExpected(t -> t.fib(2), 1)
                .addExpected(t -> t.fib(3), 2)
                .addExpected(t -> t.fib(4), 3)
                .build();
    }
}