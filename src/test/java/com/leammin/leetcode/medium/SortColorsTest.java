package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-25
 */
class SortColorsTest extends AbstractTest<SortColors> {
    @Override
    protected Testsuite<SortColors> testsuite() {
        return Testsuite.<SortColors>builder()
                .add(ExpectedTestcase.of(new int[]{0, 0, 1, 1, 2, 2}, t -> {
                    int[] nums = {2, 0, 2, 1, 1, 0};
                    t.sortColors(nums);
                    return nums;
                }))
                .add(ExpectedTestcase.of(new int[]{0, 1, 2}, t -> {
                    int[] nums = {1, 2, 0};
                    t.sortColors(nums);
                    return nums;
                }))
                .build();
    }
}