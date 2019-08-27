package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-08-26
 */
class LastStoneWeightTest extends AbstractTest<LastStoneWeight> {
    @Override
    protected Testsuite<LastStoneWeight> testsuite() {
        return Testsuite.<LastStoneWeight>builder()
                .add(ExpectedTestcase.of(0, t -> t.lastStoneWeight(new int[]{2, 2})))
                .add(ExpectedTestcase.of(8, t -> t.lastStoneWeight(new int[]{10, 2})))
                .add(ExpectedTestcase.of(6, t -> t.lastStoneWeight(new int[]{2, 10, 2})))
                .add(ExpectedTestcase.of(0, t -> t.lastStoneWeight(new int[]{10, 2, 2, 10})))
                .add(ExpectedTestcase.of(1, t -> t.lastStoneWeight(new int[]{10, 2, 2, 10, 15})))
                .build();
    }
}