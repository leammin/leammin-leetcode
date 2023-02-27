package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-04-11
 */
class SignOfTheProductOfAnArrayTest extends AbstractTest<SignOfTheProductOfAnArray> {
    @Override
    protected Testsuite<SignOfTheProductOfAnArray> testsuite() {
        return Testsuite.<SignOfTheProductOfAnArray>builder()
                .addExpected(t -> t.arraySign(new int[]{-1,-2,-3,-4,3,2,1}), 1)
                .build();
    }
}