package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-02-04
 */
class CanPlaceFlowersTest extends AbstractTest<CanPlaceFlowers> {
    @Override
    protected Testsuite<CanPlaceFlowers> testsuite() {
        return Testsuite.<CanPlaceFlowers>builder()
                .add(ExpectedTestcase.of(t -> t.canPlaceFlowers(new int[]{1,0,0,0,1}, 1), true))
                .add(ExpectedTestcase.of(t -> t.canPlaceFlowers(new int[]{1,0,0,0,1}, 2), false))
                .build();
    }
}