package com.leammin.leetcode.medium;

import com.leammin.leetcode.undone.medium.MaximumXorOfTwoNumbersInAnArray;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-04-28
 */
class MaximumXorOfTwoNumbersInAnArrayTest extends AbstractTest<MaximumXorOfTwoNumbersInAnArray> {
    @Override
    protected Testsuite<MaximumXorOfTwoNumbersInAnArray> testsuite() {
        return Testsuite.<MaximumXorOfTwoNumbersInAnArray>builder()
            .addExpected(t -> t.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}), 28)
            .build();
    }
}