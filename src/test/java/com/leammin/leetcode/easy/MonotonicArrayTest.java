package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-02-28
 */
class MonotonicArrayTest extends AbstractTest<MonotonicArray> {
    @Override
    protected Testsuite<MonotonicArray> testsuite() {
        return Testsuite.<MonotonicArray>builder()
                .add(ExpectedTestcase.of(t -> t.isMonotonic(new int[]{1,2,2,3}), true))
                .add(ExpectedTestcase.of(t -> t.isMonotonic(new int[]{1,3,2,3}), false))
                .build();
    }
}