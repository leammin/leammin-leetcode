package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-04-04
 */
class TrappingRainWaterTest extends AbstractTest<TrappingRainWater> {
    @Override
    protected Testsuite<TrappingRainWater> testsuite() {
        return Testsuite.<TrappingRainWater>builder()
                .add(ExpectedTestcase.of(t -> t.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}), 6))
                .build();
    }
}