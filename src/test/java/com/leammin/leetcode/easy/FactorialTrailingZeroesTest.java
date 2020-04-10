package com.leammin.leetcode.easy;

import com.leammin.leetcode.undone.easy.FactorialTrailingZeroes;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-04-10
 */
class FactorialTrailingZeroesTest extends AbstractTest<FactorialTrailingZeroes> {
    @Override
    protected Testsuite<FactorialTrailingZeroes> testsuite() {
        return Testsuite.<FactorialTrailingZeroes>builder()
                .add(ExpectedTestcase.of(0, t -> t.trailingZeroes(3)))
                .add(ExpectedTestcase.of(1, t -> t.trailingZeroes(5)))
                .build();
    }
}