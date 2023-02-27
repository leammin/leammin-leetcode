package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-04-11
 */
class MinimumSidewayJumpsTest extends AbstractTest<MinimumSidewayJumps> {
    @Override
    protected Testsuite<MinimumSidewayJumps> testsuite() {
        return Testsuite.<MinimumSidewayJumps>builder()
                .addExpected(t -> t.minSideJumps(new int[]{0,1,2,3,0}), 2)
                .addExpected(t -> t.minSideJumps(new int[]{0,1,1,3,3,0}), 0)
                .addExpected(t -> t.minSideJumps(new int[]{0,2,1,0,3,0}), 2)
                .build();
    }
}