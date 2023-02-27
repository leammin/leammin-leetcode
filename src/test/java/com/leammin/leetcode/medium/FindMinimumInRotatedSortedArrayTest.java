package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-15
 */
class FindMinimumInRotatedSortedArrayTest extends AbstractTest<FindMinimumInRotatedSortedArray> {
    @Override
    protected Testsuite<FindMinimumInRotatedSortedArray> testsuite() {
        return Testsuite.<FindMinimumInRotatedSortedArray>builder()
                .add(ExpectedTestcase.of(t -> t.findMin(new int[]{3,4,5,1,2}), 1))
                .add(ExpectedTestcase.of(t -> t.findMin(new int[]{4,5,6,7,0,1,2}), 0))
                .add(ExpectedTestcase.of(t -> t.findMin(new int[]{1,2,3,4,5}), 1))
                .add(ExpectedTestcase.of(t -> t.findMin(new int[]{2,1}), 1))
                .add(ExpectedTestcase.of(t -> t.findMin(new int[]{3,4,5,1,2}), 1))
                .add(ExpectedTestcase.of(t -> t.findMin(new int[]{1}), 1))
                .build();
    }
}