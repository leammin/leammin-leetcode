package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-04-10
 */
class FactorialTrailingZeroesTest extends AbstractTest<FactorialTrailingZeroes> {
    @Override
    protected Testsuite<FactorialTrailingZeroes> testsuite() {
        return Testsuite.<FactorialTrailingZeroes>builder()
                .add(ExpectedTestcase.of(t -> t.trailingZeroes(3), 0))
                .add(ExpectedTestcase.of(t -> t.trailingZeroes(5), 1))
                .build();
    }
}