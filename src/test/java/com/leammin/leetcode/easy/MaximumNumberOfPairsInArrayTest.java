package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2023-02-16
 */
class MaximumNumberOfPairsInArrayTest extends AbstractTest<MaximumNumberOfPairsInArray> {
    @Override
    protected Testsuite<MaximumNumberOfPairsInArray> testsuite() {
        return Testsuite.<MaximumNumberOfPairsInArray>builder()
                .addExpected(t -> t.numberOfPairs(new int[]{1,3,2,1,3,2,2}), new int[]{3, 1})
                .addExpected(t -> t.numberOfPairs(new int[]{1,1}), new int[]{1,0})
                .addExpected(t -> t.numberOfPairs(new int[]{0}), new int[]{0,1})
                .build();
    }
}