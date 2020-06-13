package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-13
 */
class TwoSumIiInputArrayIsSortedTest extends AbstractTest<TwoSumIiInputArrayIsSorted> {
    @Override
    protected Testsuite<TwoSumIiInputArrayIsSorted> testsuite() {
        return Testsuite.<TwoSumIiInputArrayIsSorted>builder()
                .add(ExpectedTestcase.of(t -> t.twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{1, 2}))
                .build();
    }

}