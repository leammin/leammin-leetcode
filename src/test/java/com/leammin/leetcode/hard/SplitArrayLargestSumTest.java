package com.leammin.leetcode.hard;

import com.leammin.leetcode.undone.hard.SplitArrayLargestSum;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-22
 */
class SplitArrayLargestSumTest extends AbstractTest<SplitArrayLargestSum> {
    @Override
    protected Testsuite<SplitArrayLargestSum> testsuite() {
        return Testsuite.<SplitArrayLargestSum>builder()
                .add(ExpectedTestcase.of(t -> t.splitArray(new int[]{7,2,5,10,8}, 2), 18))
                .add(ExpectedTestcase.of(t -> t.splitArray(new int[]{1,2,3,4,5}, 5), 5))
                .add(ExpectedTestcase.of(t -> t.splitArray(new int[]{1,2,3,4,5}, 5), 5))
                .add(ExpectedTestcase.of(t -> t.splitArray(new int[]{1,3,2,4,6}, 3), 6))
                .add(ExpectedTestcase.of(t -> t.splitArray(new int[]{1,2147483646}, 1), 2147483647))
                .build();
    }

}