package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-12
 */
class FindPivotIndexTest extends AbstractTest<FindPivotIndex> {
    @Override
    protected Testsuite<FindPivotIndex> testsuite() {
        return Testsuite.<FindPivotIndex>builder()
                .add(ExpectedTestcase.of(t -> t.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}), 3))
                .add(ExpectedTestcase.of(t -> t.pivotIndex(new int[]{1, 2, 3}), -1))
                .build();
    }
}