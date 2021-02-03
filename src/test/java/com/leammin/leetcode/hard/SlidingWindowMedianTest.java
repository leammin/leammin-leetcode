package com.leammin.leetcode.hard;

import com.leammin.leetcode.undone.hard.SlidingWindowMedian;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-02-03
 */
class SlidingWindowMedianTest extends AbstractTest<SlidingWindowMedian> {
    @Override
    protected Testsuite<SlidingWindowMedian> testsuite() {
        return Testsuite.<SlidingWindowMedian>builder()
                .add(ExpectedTestcase.of(t -> t.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3), new double[]{1, -1, -1, 3, 5, 6}))
                .add(ExpectedTestcase.of(t -> t.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 1), new double[]{1, 3, -1, -3, 5, 3, 6, 7}))
                .add(ExpectedTestcase.of(t -> t.medianSlidingWindow(new int[]{2147483647, 2147483647}, 2), new double[]{2147483647.0}))
                .build();
    }
}