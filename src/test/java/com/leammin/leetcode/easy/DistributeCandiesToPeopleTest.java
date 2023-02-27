package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-05
 */
class DistributeCandiesToPeopleTest extends AbstractTest<DistributeCandiesToPeople> {
    @Override
    protected Testsuite<DistributeCandiesToPeople> testsuite() {
        return Testsuite.<DistributeCandiesToPeople>builder()
                .add(ExpectedTestcase.of(t -> t.distributeCandies(7, 4), new int[]{1, 2, 3, 1}))
                .add(ExpectedTestcase.of(t -> t.distributeCandies(10, 3), new int[]{5, 2, 3}))
                .add(ExpectedTestcase.of(t -> t.distributeCandies(100, 5), new int[]{18, 21, 24, 22, 15}))
                .add(ExpectedTestcase.of(t -> t.distributeCandies(10, 5), new int[]{1, 2, 3, 4, 0}))
                .add(ExpectedTestcase.of(t -> t.distributeCandies(1000000000, 10), new int[]{100014472, 99980504, 99984976, 99989448, 99993920, 99998392,
                                100002864, 100007336, 100011808, 100016280}
                ))
                .build();
    }
}