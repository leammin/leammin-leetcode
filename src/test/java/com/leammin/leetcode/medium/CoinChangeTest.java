package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-08
 */
class CoinChangeTest extends AbstractTest<CoinChange> {
    @Override
    protected Testsuite<CoinChange> testsuite() {
        return Testsuite.<CoinChange>builder()
                .add(ExpectedTestcase.of(3, t -> t.coinChange(new int[]{1, 2, 5}, 11)))
                .add(ExpectedTestcase.of(-1, t -> t.coinChange(new int[]{2}, 3)))
                .add(ExpectedTestcase.of(4, t -> t.coinChange(new int[]{2, 5, 10, 1}, 27)))
                .add(ExpectedTestcase.of(20, t -> t.coinChange(new int[]{186,419,83,408}, 6249)))
                .build();
    }
}