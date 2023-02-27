package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-17
 */
class BestSightseeingPairTest extends AbstractTest<BestSightseeingPair> {
    @Override
    protected Testsuite<BestSightseeingPair> testsuite() {
        return Testsuite.<BestSightseeingPair>builder()
                .add(ExpectedTestcase.of(t -> t.maxScoreSightseeingPair(new int[]{8,1,5,2,6}), 11))
                .build();
    }
}