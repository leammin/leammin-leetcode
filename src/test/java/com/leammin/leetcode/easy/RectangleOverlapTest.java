package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-18
 */
class RectangleOverlapTest extends AbstractTest<RectangleOverlap> {
    @Override
    protected Testsuite<RectangleOverlap> testsuite() {
        return Testsuite.<RectangleOverlap>builder()
                .add(ExpectedTestcase.of(t -> t.isRectangleOverlap(new int[]{0, 0, 2, 2}, new int[]{1, 1, 3, 3}), true))
                .add(ExpectedTestcase.of(t -> t.isRectangleOverlap(new int[]{0, 0, 1, 1}, new int[]{1, 0, 2, 1}), false))
                .add(ExpectedTestcase.of(t -> t.isRectangleOverlap(new int[]{-7, -3, 10, 5}, new int[]{-6, -5, 5, 10}), true))
                .build();
    }
}