package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-02-06
 */
class MaximumPointsYouCanObtainFromCardsTest extends AbstractTest<MaximumPointsYouCanObtainFromCards> {
    @Override
    protected Testsuite<MaximumPointsYouCanObtainFromCards> testsuite() {
        return Testsuite.<MaximumPointsYouCanObtainFromCards>builder()
                .add(ExpectedTestcase.of(t -> t.maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3), 12))
                .add(ExpectedTestcase.of(t -> t.maxScore(new int[]{2, 2, 2}, 2), 4))
                .add(ExpectedTestcase.of(t -> t.maxScore(new int[]{9, 7, 7, 9, 7, 7, 9}, 7), 55))
                .add(ExpectedTestcase.of(t -> t.maxScore(new int[]{1, 1000, 1}, 1), 1))
                .add(ExpectedTestcase.of(t -> t.maxScore(new int[]{1, 79, 80, 1, 1, 1, 200, 1}, 3), 202))
                .build();
    }
}