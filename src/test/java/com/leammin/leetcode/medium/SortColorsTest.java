package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-25
 */
class SortColorsTest extends AbstractTest<SortColors> {
    @Override
    protected Testsuite<SortColors> testsuite() {
        return Testsuite.<SortColors>builder()
                .add(ExpectedTestcase.of(t -> {
                    int[] nums = {2, 0, 2, 1, 1, 0};
                    t.sortColors(nums);
                    return nums;
                }, new int[]{0, 0, 1, 1, 2, 2}))
                .add(ExpectedTestcase.of(t -> {
                    int[] nums = {1, 2, 0};
                    t.sortColors(nums);
                    return nums;
                }, new int[]{0, 1, 2}))
                .build();
    }
}