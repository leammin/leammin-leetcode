package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2019-08-24
 */
class DivideTwoIntegersTest extends AbstractTest<DivideTwoIntegers> {
    @Override
    protected Testsuite<DivideTwoIntegers> testsuite() {
        return Testsuite.<DivideTwoIntegers>builder()
                .add(ExpectedTestcase.of(t -> t.divide(10, 3), 3))
                .add(ExpectedTestcase.of(t -> t.divide(24, 8), 3))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MAX_VALUE, 13), 165191049))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MAX_VALUE, 1), Integer.MAX_VALUE))
                .add(ExpectedTestcase.of(t -> t.divide(1351, 11), 122))
                .add(ExpectedTestcase.of(t -> t.divide(-11, 2), -5))
                .add(ExpectedTestcase.of(t -> t.divide(-11, 0), Integer.MAX_VALUE))
                .add(ExpectedTestcase.of(t -> t.divide(255, 16), 15))
                .add(ExpectedTestcase.of(t -> t.divide(15, 16), 0))
                .add(ExpectedTestcase.of(t -> t.divide(15, 15), 1))
                .add(ExpectedTestcase.of(t -> t.divide(15, -15), -1))
                .add(ExpectedTestcase.of(t -> t.divide(-15, 15), -1))
                .add(ExpectedTestcase.of(t -> t.divide(15, 1), 15))
                .add(ExpectedTestcase.of(t -> t.divide(3, 12), 0))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MAX_VALUE, Integer.MIN_VALUE), 0))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MIN_VALUE, -2), 1073741824))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MIN_VALUE, 2), -1073741824))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MIN_VALUE + 2, 2), -1073741823))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MIN_VALUE, 65536), -32768))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MIN_VALUE, 4860461), -441))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MIN_VALUE, 1), Integer.MIN_VALUE))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MIN_VALUE, -1), Integer.MAX_VALUE))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MIN_VALUE, 2147473647), -1))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MIN_VALUE, Integer.MAX_VALUE), -1))
                .add(ExpectedTestcase.of(t -> t.divide(1631631, Integer.MAX_VALUE), 0))
                .add(ExpectedTestcase.of(t -> t.divide(-Integer.MAX_VALUE, Integer.MAX_VALUE), -1))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MIN_VALUE, Integer.MIN_VALUE), 1))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MIN_VALUE, 1073741823), -2))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MIN_VALUE, -1073741823), 2))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MIN_VALUE, 1073741824), -2))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MIN_VALUE, -1073741824), 2))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MIN_VALUE, 1073741825), -1))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MIN_VALUE, -1073741825), 1))

                .build();
    }
}