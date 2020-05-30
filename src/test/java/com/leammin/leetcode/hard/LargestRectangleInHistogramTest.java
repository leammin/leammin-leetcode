package com.leammin.leetcode.hard;

import com.leammin.leetcode.undone.hard.LargestRectangleInHistogram;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-05-30
 */
class LargestRectangleInHistogramTest extends AbstractTest<LargestRectangleInHistogram> {
    @Override
    protected Testsuite<LargestRectangleInHistogram> testsuite() {
        return Testsuite.<LargestRectangleInHistogram>builder()
                .add(ExpectedTestcase.of(t -> t.largestRectangleArea(new int[]{2,1,5,6,2,3}), 10))
                .build();
    }
}