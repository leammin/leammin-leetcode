package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2023-01-20
 */
class MinMaxGameTest extends AbstractTest<MinMaxGame> {
    @Override
    protected Testsuite<MinMaxGame> testsuite() {
        return Testsuite.<MinMaxGame>builder()
                .addExpected(t -> t.minMaxGame(new int[]{1,3,5,2,4,8,2,2}), 1)
                .addExpected(t -> t.minMaxGame(new int[]{3}), 3)
                .build();
    }
}