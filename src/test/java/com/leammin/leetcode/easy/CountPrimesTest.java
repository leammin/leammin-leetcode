package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-08-22
 */
class CountPrimesTest extends AbstractTest<CountPrimes> {
    @Override
    protected Testsuite<CountPrimes> testsuite() {
        return Testsuite.<CountPrimes>builder()
                .add(ExpectedTestcase.of(4, t -> t.countPrimes(10)))
                .add(ExpectedTestcase.of(1229, t -> t.countPrimes(10000)))
                .build();
    }
}