package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-05-29
 */
class HouseRobberTest extends AbstractTest<HouseRobber> {
    @Override
    protected Testsuite<HouseRobber> testsuite() {
        return Testsuite.<HouseRobber>builder()
                .add(ExpectedTestcase.of(t -> t.rob(new int[]{1, 2, 3, 1}), 4))
                .add(ExpectedTestcase.of(t -> t.rob(new int[]{2, 7, 9, 3, 1}), 12))
                .build();
    }
}