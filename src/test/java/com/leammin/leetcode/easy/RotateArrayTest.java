package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

class RotateArrayTest extends AbstractTest<RotateArray> {

    @Override
    protected Testsuite<RotateArray> testsuite() {
        return Testsuite.<RotateArray>builder()
                .add(ExpectedTestcase.of(
                        t -> {
                            int[] nums = new int[]{1, 2, 3, 4, 5, 6,};
                            t.rotate(nums, 3);
                            return nums;
                        }, new int[]{4, 5, 6, 1, 2, 3,}
                ))
                .add(ExpectedTestcase.of(
                        t -> {
                            int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
                            t.rotate(nums, 4);
                            return nums;
                        }, new int[]{4, 5, 6, 7, 1, 2, 3,}
                ))
                .add(ExpectedTestcase.of(
                        t -> {
                            int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10,};
                            t.rotate(nums, 4);
                            return nums;
                        }, new int[]{7, 8, 9, 10, 1, 2, 3, 4, 5, 6,}
                ))
                .build();
    }
}