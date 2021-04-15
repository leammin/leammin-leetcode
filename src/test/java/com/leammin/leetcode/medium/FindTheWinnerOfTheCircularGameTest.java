package com.leammin.leetcode.medium;

import com.leammin.leetcode.undone.medium.FindTheWinnerOfTheCircularGame;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-04-11
 */
class FindTheWinnerOfTheCircularGameTest extends AbstractTest<FindTheWinnerOfTheCircularGame> {
    @Override
    protected Testsuite<FindTheWinnerOfTheCircularGame> testsuite() {
        return Testsuite.<FindTheWinnerOfTheCircularGame>builder()
                .addExpected(t -> t.findTheWinner(5, 2), 3)
                .addExpected(t -> t.findTheWinner(6, 5), 1)
                .build();
    }
}