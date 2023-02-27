package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-15
 */
class MoveZeroesTest extends AbstractTest<MoveZeroes> {
    @Override
    protected Testsuite<MoveZeroes> testsuite() {
        return Testsuite.<MoveZeroes>builder()
                .add(ExpectedTestcase.of(t -> {
                    int[] nums = {0, 1, 0, 3, 12};
                    t.moveZeroes(nums);
                    return nums;
                }, new int[]{1, 3, 12, 0, 0}))
                .build();
    }
}