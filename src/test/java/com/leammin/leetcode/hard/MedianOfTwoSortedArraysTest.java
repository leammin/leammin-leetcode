package com.leammin.leetcode.hard;

import com.leammin.leetcode.undone.hard.MedianOfTwoSortedArrays;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-05-24
 */
class MedianOfTwoSortedArraysTest extends AbstractTest<MedianOfTwoSortedArrays> {
    @Override
    protected Testsuite<MedianOfTwoSortedArrays> testsuite() {
        return Testsuite.<MedianOfTwoSortedArrays>builder()
                .add(ExpectedTestcase.of(t -> t.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}), 2.0))
                .add(ExpectedTestcase.of(t -> t.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}), 2.5))
                .add(ExpectedTestcase.of(t -> t.findMedianSortedArrays(new int[]{0, 1, 2, 3}, new int[]{1, 2, 3, 4, 5}), 2.0))
                .add(ExpectedTestcase.of(t -> t.findMedianSortedArrays(new int[]{0, 1, 2, 3}, new int[]{2, 3, 4, 5}), 2.5))
                .add(ExpectedTestcase.of(t -> t.findMedianSortedArrays(new int[]{0, 1, 2, 3, 4}, new int[]{2, 3, 4, 5}), 3.0))
                .add(ExpectedTestcase.of(t -> t.findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 7}), 2.5))
                .add(ExpectedTestcase.of(t -> t.findMedianSortedArrays(new int[]{1, 2}, new int[]{1, 2}), 1.5))
                .build();
    }
}