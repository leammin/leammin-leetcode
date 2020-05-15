package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-05-14
 */
class SumOfTwoIntegersTest extends AbstractTest<SumOfTwoIntegers> {
    @Override
    protected Testsuite<SumOfTwoIntegers> testsuite() {
        return Testsuite.<SumOfTwoIntegers>builder()
                .add(ExpectedTestcase.of(t -> t.getSum(1,2), 3))
                .add(ExpectedTestcase.of(t -> t.getSum(-2,3), 1))
                .add(ExpectedTestcase.of(t -> t.getSum(-5,3), -2))
                .build();
    }
}