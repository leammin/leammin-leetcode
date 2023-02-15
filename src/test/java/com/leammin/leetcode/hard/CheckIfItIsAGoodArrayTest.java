package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2023-02-15
 */
class CheckIfItIsAGoodArrayTest extends AbstractTest<CheckIfItIsAGoodArray> {
    @Override
    protected Testsuite<CheckIfItIsAGoodArray> testsuite() {
        return Testsuite.<CheckIfItIsAGoodArray>builder()
                .addExpected(t -> t.isGoodArray(new int[]{12, 5, 7, 23}), true)
                .addExpected(t -> t.isGoodArray(new int[]{29, 6, 10}), true)
                .addExpected(t -> t.isGoodArray(new int[]{3, 6}), false)
                .addExpected(t -> t.isGoodArray(new int[]{6, 10, 15, 30}), true)
                .build();

    }
}