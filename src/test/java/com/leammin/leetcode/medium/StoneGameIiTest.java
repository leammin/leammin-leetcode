package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2023-02-22
 */
class StoneGameIiTest extends AbstractTest<StoneGameIi> {
    @Override
    protected Testsuite<StoneGameIi> testsuite() {
        return Testsuite.<StoneGameIi>builder()
                .addExpected(t -> t.stoneGameII(new int[]{2,7,9,4,4}), 10)
                .addExpected(t -> t.stoneGameII(new int[]{1,2,3,4,5,100}), 104)
                .build();
    }
}