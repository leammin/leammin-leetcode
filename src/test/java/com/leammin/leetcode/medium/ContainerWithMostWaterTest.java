package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-04-18
 */
class ContainerWithMostWaterTest extends AbstractTest<ContainerWithMostWater> {
    @Override
    protected Testsuite<ContainerWithMostWater> testsuite() {
        return Testsuite.<ContainerWithMostWater>builder()
                .add(ExpectedTestcase.of(t -> t.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}), 49))
                .add(ExpectedTestcase.of(t -> t.maxArea(new int[]{2,1}), 1))
                .add(ExpectedTestcase.of(t -> t.maxArea(new int[]{4,8,3,3,3,3,3}), 18))
                .build();
    }
}