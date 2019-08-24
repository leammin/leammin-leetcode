package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-08-24
 */
class DivideTwoIntegersTest extends AbstractTest<DivideTwoIntegers> {
    @Override
    protected Testsuite<DivideTwoIntegers> testsuite() {
        return Testsuite.<DivideTwoIntegers>builder()
                .add(ExpectedTestcase.of(3, t -> t.divide(10, 3)))
                .add(ExpectedTestcase.of(3, t -> t.divide(24, 8)))
                .add(ExpectedTestcase.of(165191049, t -> t.divide(Integer.MAX_VALUE, 13)))
                .add(ExpectedTestcase.of(Integer.MAX_VALUE, t -> t.divide(Integer.MAX_VALUE, 1)))
                .add(ExpectedTestcase.of(122, t -> t.divide(1351, 11)))
                .add(ExpectedTestcase.of(-5, t -> t.divide(-11, 2)))
                .add(ExpectedTestcase.of(Integer.MAX_VALUE, t -> t.divide(-11, 0)))
                .add(ExpectedTestcase.of(15, t -> t.divide(255, 16)))
                .add(ExpectedTestcase.of(0, t -> t.divide(15, 16)))
                .add(ExpectedTestcase.of(1, t -> t.divide(15, 15)))
                .add(ExpectedTestcase.of(-1, t -> t.divide(15, -15)))
                .add(ExpectedTestcase.of(-1, t -> t.divide(-15, 15)))
                .add(ExpectedTestcase.of(15, t -> t.divide(15, 1)))
                .add(ExpectedTestcase.of(0, t -> t.divide(3, 12)))
                .add(ExpectedTestcase.of(0, t -> t.divide(Integer.MAX_VALUE, Integer.MIN_VALUE)))
                .add(ExpectedTestcase.of(1073741824, t -> t.divide(Integer.MIN_VALUE, -2)))
                .add(ExpectedTestcase.of(-1073741824, t -> t.divide(Integer.MIN_VALUE, 2)))
                .add(ExpectedTestcase.of(-1073741823, t -> t.divide(Integer.MIN_VALUE + 2, 2)))
                .add(ExpectedTestcase.of(-32768, t -> t.divide(Integer.MIN_VALUE, 65536)))
                .add(ExpectedTestcase.of(-441, t -> t.divide(Integer.MIN_VALUE, 4860461)))
                .add(ExpectedTestcase.of(Integer.MIN_VALUE, t -> t.divide(Integer.MIN_VALUE, 1)))
                .add(ExpectedTestcase.of(Integer.MAX_VALUE, t -> t.divide(Integer.MIN_VALUE, -1)))
                .add(ExpectedTestcase.of(-1, t -> t.divide(Integer.MIN_VALUE, 2147473647)))
                .add(ExpectedTestcase.of(-1, t -> t.divide(Integer.MIN_VALUE, Integer.MAX_VALUE)))
                .add(ExpectedTestcase.of(0, t -> t.divide(1631631, Integer.MAX_VALUE)))
                .add(ExpectedTestcase.of(-1, t -> t.divide(-Integer.MAX_VALUE, Integer.MAX_VALUE)))
                .add(ExpectedTestcase.of(1, t -> t.divide(Integer.MIN_VALUE, Integer.MIN_VALUE)))
                .add(ExpectedTestcase.of(-2, t -> t.divide(Integer.MIN_VALUE, 1073741823)))
                .add(ExpectedTestcase.of(2, t -> t.divide(Integer.MIN_VALUE, -1073741823)))
                .add(ExpectedTestcase.of(-2, t -> t.divide(Integer.MIN_VALUE, 1073741824)))
                .add(ExpectedTestcase.of(2, t -> t.divide(Integer.MIN_VALUE, -1073741824)))
                .add(ExpectedTestcase.of(-1, t -> t.divide(Integer.MIN_VALUE, 1073741825)))
                .add(ExpectedTestcase.of(1, t -> t.divide(Integer.MIN_VALUE, -1073741825)))

                .build();
    }
}