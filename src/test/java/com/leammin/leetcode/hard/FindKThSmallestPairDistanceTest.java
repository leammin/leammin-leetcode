package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-19
 */
class FindKThSmallestPairDistanceTest extends AbstractTest<FindKThSmallestPairDistance> {
    @Override
    protected Testsuite<FindKThSmallestPairDistance> testsuite() {
        return Testsuite.<FindKThSmallestPairDistance>builder()
                .add(ExpectedTestcase.of(t -> t.smallestDistancePair(new int[]{1, 3, 1}, 1), 0))
                .add(ExpectedTestcase.of(t -> t.smallestDistancePair(new int[]{1, 6, 1}, 3), 5))
                .add(ExpectedTestcase.of(t -> t.smallestDistancePair(new int[]{1, 1, 1}, 2), 0))
                .add(ExpectedTestcase.of(t -> t.smallestDistancePair(new int[]{0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2,
                        3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9, 10,
                        10, 10, 10, 10}, 444), 2))
                .add(ExpectedTestcase.of(t -> t.smallestDistancePair(new int[]{62,100,4}, 2), 58))
                .build();

    }
}