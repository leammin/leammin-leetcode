package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

import java.util.List;

/**
 * @author Leammin
 * @date 2020-06-15
 */
class PascalsTriangleIiTest extends AbstractTest<PascalsTriangleIi> {
    @Override
    protected Testsuite<PascalsTriangleIi> testsuite() {
        return Testsuite.<PascalsTriangleIi>builder()
                .add(ExpectedTestcase.of(t -> t.getRow(3), List.of(1, 3, 3, 1)))
                .build();
    }
}