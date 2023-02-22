package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2023-02-21
 */
class MinimumNumberOfTapsToOpenToWaterAGardenTest extends AbstractTest<MinimumNumberOfTapsToOpenToWaterAGarden> {
    @Override
    protected Testsuite<MinimumNumberOfTapsToOpenToWaterAGarden> testsuite() {
        return Testsuite.<MinimumNumberOfTapsToOpenToWaterAGarden>builder()
                .addExpected(t -> t.minTaps(5, new int[]{3,4,1,1,0,0}), 1)
                .addExpected(t -> t.minTaps(3, new int[]{0,0,0,0}), -1)
                .addExpected(t -> t.minTaps(7, new int[]{1,2,1,0,2,1,0,1}), 3)
                .addExpected(t -> t.minTaps(8, new int[]{4,0,0,0,4,0,0,0,4}), 1)
                .build();
    }
}