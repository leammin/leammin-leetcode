package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2019-08-26
 */
class LastStoneWeightTest extends AbstractTest<LastStoneWeight> {
    @Override
    protected Testsuite<LastStoneWeight> testsuite() {
        return Testsuite.<LastStoneWeight>builder()
                .add(ExpectedTestcase.of(t -> t.lastStoneWeight(new int[]{2, 2}), 0))
                .add(ExpectedTestcase.of(t -> t.lastStoneWeight(new int[]{10, 2}), 8))
                .add(ExpectedTestcase.of(t -> t.lastStoneWeight(new int[]{2, 10, 2}), 6))
                .add(ExpectedTestcase.of(t -> t.lastStoneWeight(new int[]{10, 2, 2, 10}), 0))
                .add(ExpectedTestcase.of(t -> t.lastStoneWeight(new int[]{10, 2, 2, 10, 15}), 1))
                .build();
    }
}