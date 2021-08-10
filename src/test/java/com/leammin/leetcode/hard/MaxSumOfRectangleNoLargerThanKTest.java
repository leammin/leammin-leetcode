package com.leammin.leetcode.hard;

import com.leammin.leetcode.undone.hard.MaxSumOfRectangleNoLargerThanK;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-04-22
 */
class MaxSumOfRectangleNoLargerThanKTest extends AbstractTest<MaxSumOfRectangleNoLargerThanK> {
    @Override
    protected Testsuite<MaxSumOfRectangleNoLargerThanK> testsuite() {
        return Testsuite.<MaxSumOfRectangleNoLargerThanK>builder()
            .addExpected(t -> t.maxSumSubmatrix(new int[][]{{1,0,1},{0,-2,3}}, 2), 2)
            .addExpected(t -> t.maxSumSubmatrix(new int[][]{{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}}, 8), 8)
            .build();
    }
}