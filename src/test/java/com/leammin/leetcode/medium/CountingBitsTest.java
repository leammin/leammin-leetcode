package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-03-04
 */
class CountingBitsTest extends AbstractTest<CountingBits> {
    @Override
    protected Testsuite<CountingBits> testsuite() {
        return Testsuite.<CountingBits>builder()
                .add(ExpectedTestcase.of(t -> t.countBits(5), new int[]{0, 1, 1, 2, 1, 2}))
                .add(ExpectedTestcase.of(t -> t.countBits(2), new int[]{0, 1, 1}))
                .add(ExpectedTestcase.of(t -> t.countBits(0), new int[]{0}))
                .build();
    }
}