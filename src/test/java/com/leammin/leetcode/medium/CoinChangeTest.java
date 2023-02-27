package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-08
 */
class CoinChangeTest extends AbstractTest<CoinChange> {
    @Override
    protected Testsuite<CoinChange> testsuite() {
        return Testsuite.<CoinChange>builder()
                .add(ExpectedTestcase.of(t -> t.coinChange(new int[]{1, 2, 5}, 11), 3))
                .add(ExpectedTestcase.of(t -> t.coinChange(new int[]{2}, 3), -1))
                .add(ExpectedTestcase.of(t -> t.coinChange(new int[]{2, 5, 10, 1}, 27), 4))
                .add(ExpectedTestcase.of(t -> t.coinChange(new int[]{186,419,83,408}, 6249), 20))
                .build();
    }
}