package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-05-27
 */
class SubarraySumsDivisibleByKTest extends AbstractTest<SubarraySumsDivisibleByK> {
    @Override
    protected Testsuite<SubarraySumsDivisibleByK> testsuite() {
        return Testsuite.<SubarraySumsDivisibleByK>builder()
                .add(ExpectedTestcase.of(t -> t.subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5), 7))
                .add(ExpectedTestcase.of(t -> t.subarraysDivByK(new int[]{-2}, 6), 0))
                .build();
    }
}