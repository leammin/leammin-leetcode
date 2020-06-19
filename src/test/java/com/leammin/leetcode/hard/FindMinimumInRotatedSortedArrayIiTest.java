package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-18
 */
class FindMinimumInRotatedSortedArrayIiTest extends AbstractTest<FindMinimumInRotatedSortedArrayIi> {
    @Override
    protected Testsuite<FindMinimumInRotatedSortedArrayIi> testsuite() {
        return Testsuite.<FindMinimumInRotatedSortedArrayIi>builder()
                .add(ExpectedTestcase.of(t -> t.findMin(new int[]{1,3,5}), 1))
                .add(ExpectedTestcase.of(t -> t.findMin(new int[]{2,2,2,0,1}), 0))
                .add(ExpectedTestcase.of(t -> t.findMin(new int[]{2,2,2,2,2,2,2,0,1,2,2}), 0))
                .add(ExpectedTestcase.of(t -> t.findMin(new int[]{2,2,2,2,2,2,2,0,2,2,2}), 0))
                .add(ExpectedTestcase.of(t -> t.findMin(new int[]{2,2,0,1,2,2,2,2,2,2,2}), 0))
                .add(ExpectedTestcase.of(t -> t.findMin(new int[]{2,2,0,2,2,2,2,2,2,2,2}), 0))
                .add(ExpectedTestcase.of(t -> t.findMin(new int[]{2,2,2,2,2,2,2,2,2,2,2}), 2))
                .add(ExpectedTestcase.of(t -> t.findMin(new int[]{2,3,4,5,1}), 1))
                .add(ExpectedTestcase.of(t -> t.findMin(new int[]{1,2,0,0,1}), 0))
                .build();
    }
}