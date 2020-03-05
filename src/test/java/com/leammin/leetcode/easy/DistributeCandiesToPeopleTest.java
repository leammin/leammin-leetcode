package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-05
 */
class DistributeCandiesToPeopleTest extends AbstractTest<DistributeCandiesToPeople> {
    @Override
    protected Testsuite<DistributeCandiesToPeople> testsuite() {
        return Testsuite.<DistributeCandiesToPeople>builder()
                .add(ExpectedTestcase.of(new int[]{1, 2, 3, 1}, t -> t.distributeCandies(7, 4)))
                .add(ExpectedTestcase.of(new int[]{5, 2, 3}, t -> t.distributeCandies(10, 3)))
                .add(ExpectedTestcase.of(new int[]{18, 21, 24, 22, 15}, t -> t.distributeCandies(100, 5)))
                .add(ExpectedTestcase.of(new int[]{1, 2, 3, 4, 0}, t -> t.distributeCandies(10, 5)))
                .add(ExpectedTestcase.of(new int[]{100014472, 99980504, 99984976, 99989448, 99993920, 99998392,
                                100002864, 100007336, 100011808, 100016280},
                        t -> t.distributeCandies(1000000000, 10)))
                .build();
    }
}