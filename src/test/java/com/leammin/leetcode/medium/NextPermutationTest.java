package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-01-09
 */
class NextPermutationTest extends AbstractTest<NextPermutation> {
    @Override
    protected Testsuite<NextPermutation> testsuite() {
        return Testsuite.<NextPermutation>builder()
                .add(ExpectedTestcase.of(t -> {
                    int[] nums = {1, 2, 3};
                    t.nextPermutation(nums);
                    return nums;
                }, new int[]{1, 3, 2}))
                .add(ExpectedTestcase.of(t -> {
                    int[] nums = {3, 2, 1};
                    t.nextPermutation(nums);
                    return nums;
                }, new int[]{1, 2, 3}))
                .add(ExpectedTestcase.of(t -> {
                    int[] nums = {1, 1, 5};
                    t.nextPermutation(nums);
                    return nums;
                }, new int[]{1, 5, 1}))
                .add(ExpectedTestcase.of(t -> {
                    int[] nums = {1,3,2};
                    t.nextPermutation(nums);
                    return nums;
                }, new int[]{2,1,3}))
                .add(ExpectedTestcase.of(t -> {
                    int[] nums = {2,2,7,5,4,3,2,2,1};
                    t.nextPermutation(nums);
                    return nums;
                }, new int[]{2,3,1,2,2,2,4,5,7}))
                .build();
    }
}