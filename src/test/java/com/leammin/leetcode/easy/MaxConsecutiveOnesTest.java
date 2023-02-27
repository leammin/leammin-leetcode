package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-13
 */
class MaxConsecutiveOnesTest extends AbstractTest<MaxConsecutiveOnes> {
    @Override
    protected Testsuite<MaxConsecutiveOnes> testsuite() {
        return Testsuite.<MaxConsecutiveOnes>builder()
                .add(ExpectedTestcase.of(t -> t.findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}), 3))
                .build();
    }
}