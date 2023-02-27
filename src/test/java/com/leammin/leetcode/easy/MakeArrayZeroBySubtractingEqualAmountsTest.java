package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2023-02-24
 */
class MakeArrayZeroBySubtractingEqualAmountsTest extends AbstractTest<MakeArrayZeroBySubtractingEqualAmounts> {
    @Override
    protected Testsuite<MakeArrayZeroBySubtractingEqualAmounts> testsuite() {
        return Testsuite.<MakeArrayZeroBySubtractingEqualAmounts>builder()
                .addExpected(t -> t.minimumOperations(new int[]{1, 5, 0, 3, 5}), 3)
                .addExpected(t -> t.minimumOperations(new int[]{0}), 0)
                .build();
    }
}