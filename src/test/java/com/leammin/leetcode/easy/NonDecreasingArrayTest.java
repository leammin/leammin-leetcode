package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-02-08
 */
class NonDecreasingArrayTest extends AbstractTest<NonDecreasingArray> {
    @Override
    protected Testsuite<NonDecreasingArray> testsuite() {
        return Testsuite.<NonDecreasingArray>builder()
                .add(ExpectedTestcase.of(t -> t.checkPossibility(new int[]{4, 2, 3}), true))
                .add(ExpectedTestcase.of(t -> t.checkPossibility(new int[]{4, 2, 1}), false))
                .add(ExpectedTestcase.of(t -> t.checkPossibility(new int[]{3, 4, 2, 3}), false))
                .add(ExpectedTestcase.of(t -> t.checkPossibility(new int[]{5,7,1,8}), true))
                .add(ExpectedTestcase.of(t -> t.checkPossibility(new int[]{-1,4,2,3}), true))
                .build();
    }
}