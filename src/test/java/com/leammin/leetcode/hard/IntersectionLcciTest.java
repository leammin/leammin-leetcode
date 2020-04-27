package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-04-13
 */
class IntersectionLcciTest extends AbstractTest<IntersectionLcci> {
    @Override
    protected Testsuite<IntersectionLcci> testsuite() {
        return Testsuite.<IntersectionLcci>builder()
                .add(ExpectedTestcase.of(t -> t.intersection(new int[]{0, 0}, new int[]{1, 0}, new int[]{1, 1}, new int[]{0, -1}), new double[]{0.5, 0}))
                .add(ExpectedTestcase.of(t -> t.intersection(new int[]{0, 0}, new int[]{3, 3}, new int[]{1, 1}, new int[]{2, 2}), new double[]{1, 1}))
                .add(ExpectedTestcase.of(t -> t.intersection(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{2, 1}), new double[]{}))
                .build();
    }
}