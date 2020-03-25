package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-24
 */
class TheMasseuseLcciTest extends AbstractTest<TheMasseuseLcci> {
    @Override
    protected Testsuite<TheMasseuseLcci> testsuite() {
        return Testsuite.<TheMasseuseLcci>builder()
                .add(ExpectedTestcase.of(4, t -> t.massage(new int[]{1, 2, 3, 1})))
                .add(ExpectedTestcase.of(12, t -> t.massage(new int[]{2, 7, 9, 3, 1})))
                .add(ExpectedTestcase.of(12, t -> t.massage(new int[]{2, 1, 4, 5, 3, 1, 1, 3})))
                .build();
    }
}