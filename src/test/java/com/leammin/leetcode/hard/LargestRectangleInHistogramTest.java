package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-05-30
 */
class LargestRectangleInHistogramTest extends AbstractTest<LargestRectangleInHistogram> {
    @Override
    protected Testsuite<LargestRectangleInHistogram> testsuite() {
        return Testsuite.<LargestRectangleInHistogram>builder()
                .add(ExpectedTestcase.of(t -> t.largestRectangleArea(new int[]{2,1,5,6,2,3}), 10))
                .add(ExpectedTestcase.of(t -> t.largestRectangleArea(new int[]{2,2,4,6,2,3}), 12))
                .add(ExpectedTestcase.of(t -> t.largestRectangleArea(new int[]{3,6,5,7,4,8,1,0}), 20))
                .build();
    }
}