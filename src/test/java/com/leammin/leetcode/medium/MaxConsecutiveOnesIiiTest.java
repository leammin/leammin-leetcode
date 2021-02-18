package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-02-19
 */
class MaxConsecutiveOnesIiiTest extends AbstractTest<MaxConsecutiveOnesIii> {
    @Override
    protected Testsuite<MaxConsecutiveOnesIii> testsuite() {
        return Testsuite.<MaxConsecutiveOnesIii>builder()
                .add(ExpectedTestcase.of(t -> t.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2), 6))
                .add(ExpectedTestcase.of(t -> t.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3), 10))
                .build();
    }
}