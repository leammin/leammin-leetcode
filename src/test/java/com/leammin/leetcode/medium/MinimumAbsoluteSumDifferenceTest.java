package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-04-04
 */
class MinimumAbsoluteSumDifferenceTest extends AbstractTest<MinimumAbsoluteSumDifference> {
    @Override
    protected Testsuite<MinimumAbsoluteSumDifference> testsuite() {
        return Testsuite.<MinimumAbsoluteSumDifference>builder()
                .addExpected(t -> t.minAbsoluteSumDiff(new int[]{1,7,5}, new int[]{2,3,5}), 3)
                .addExpected(t -> t.minAbsoluteSumDiff(new int[]{2,4,6,8,10}, new int[]{2,4,6,8,10}), 0)
                .addExpected(t -> t.minAbsoluteSumDiff(new int[]{1,10,4,4,2,7}, new int[]{9,3,5,1,7,4}), 20)
                .addExpected(t -> t.minAbsoluteSumDiff(new int[]{95,1,2,3,4}, new int[]{100,2,3,4,5}), 8)
                .build();
    }
}