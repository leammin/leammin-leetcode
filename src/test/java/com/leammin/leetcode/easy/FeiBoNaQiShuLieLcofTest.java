package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-08-21
 */
class FeiBoNaQiShuLieLcofTest extends AbstractTest<FeiBoNaQiShuLieLcof> {
    @Override
    protected Testsuite<FeiBoNaQiShuLieLcof> testsuite() {
        return Testsuite.<FeiBoNaQiShuLieLcof>builder()
                .addExpected(t -> t.fib(2), 1)
                .addExpected(t -> t.fib(5), 5)
                .addExpected(t -> t.fib(36), 14930352)
                .addExpected(t -> t.fib(72), 8390086)
                .build();
    }
}