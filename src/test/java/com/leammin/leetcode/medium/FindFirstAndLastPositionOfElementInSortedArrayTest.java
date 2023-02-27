package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-04-01
 */
class FindFirstAndLastPositionOfElementInSortedArrayTest extends AbstractTest<FindFirstAndLastPositionOfElementInSortedArray> {
    @Override
    protected Testsuite<FindFirstAndLastPositionOfElementInSortedArray> testsuite() {
        return Testsuite.<FindFirstAndLastPositionOfElementInSortedArray>builder()
                .add(ExpectedTestcase.of(t -> t.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8), new int[]{3, 4}))
                .add(ExpectedTestcase.of(t -> t.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6), new int[]{-1, -1}))
                .add(ExpectedTestcase.of(t -> t.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 5), new int[]{0, 0}))
                .build();
    }
}