package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-05-15
 */
class SubarraySumEqualsKTest extends AbstractTest<SubarraySumEqualsK> {
    @Override
    protected Testsuite<SubarraySumEqualsK> testsuite() {
        return Testsuite.<SubarraySumEqualsK>builder()
                .add(ExpectedTestcase.of(t -> t.subarraySum(new int[]{1,1,1}, 2), 2))
                .add(ExpectedTestcase.of(t -> t.subarraySum(new int[]{1}, 0), 0))
                .add(ExpectedTestcase.of(t -> t.subarraySum(new int[]{1,1}, 0), 0))
                .build();
    }
}