package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-02-04
 */
class MaximumAverageSubarrayITest extends AbstractTest<MaximumAverageSubarrayI> {
    @Override
    protected Testsuite<MaximumAverageSubarrayI> testsuite() {
        return Testsuite.<MaximumAverageSubarrayI>builder()
                .add(ExpectedTestcase.of(t -> t.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4), 12.75))
                .build();
    }
}