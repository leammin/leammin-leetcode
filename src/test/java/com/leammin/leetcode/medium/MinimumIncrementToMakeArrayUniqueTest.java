package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-22
 */
class MinimumIncrementToMakeArrayUniqueTest extends AbstractTest<MinimumIncrementToMakeArrayUnique> {
    @Override
    protected Testsuite<MinimumIncrementToMakeArrayUnique> testsuite() {
        return Testsuite.<MinimumIncrementToMakeArrayUnique>builder()
                .add(ExpectedTestcase.of(t -> t.minIncrementForUnique(new int[]{1, 2, 2}), 1))
                .add(ExpectedTestcase.of(t -> t.minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7}), 6))
                .build();
    }
}