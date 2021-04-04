package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-04-04
 */
class ClumsyFactorialTest extends AbstractTest<ClumsyFactorial> {
    @Override
    protected Testsuite<ClumsyFactorial> testsuite() {
        return Testsuite.<ClumsyFactorial>builder()
                .addExpected(t -> t.clumsy(4), 7)
                .addExpected(t -> t.clumsy(10), 12)
                .addExpected(t -> t.clumsy(8), 9)
                .addExpected(t -> t.clumsy(7), 6)
                .build();
    }
}