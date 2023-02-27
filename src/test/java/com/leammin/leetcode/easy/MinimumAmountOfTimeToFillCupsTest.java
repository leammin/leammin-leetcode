package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2023-02-12
 */
class MinimumAmountOfTimeToFillCupsTest extends AbstractTest<MinimumAmountOfTimeToFillCups> {
    @Override
    protected Testsuite<MinimumAmountOfTimeToFillCups> testsuite() {
        return Testsuite.<MinimumAmountOfTimeToFillCups>builder()
                .addExpected(t -> t.fillCups(new int[]{1,4,2}), 4)
                .addExpected(t -> t.fillCups(new int[]{5,4,4}), 7)
                .addExpected(t -> t.fillCups(new int[]{5,0,0}), 5)
                .build();
    }
}