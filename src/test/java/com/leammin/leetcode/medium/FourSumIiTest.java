package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-28
 */
class FourSumIiTest extends AbstractTest<FourSumIi> {
    @Override
    protected Testsuite<FourSumIi> testsuite() {
        return Testsuite.<FourSumIi>builder()
                .add(ExpectedTestcase.of(t -> t.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}), 2))
                .build();
    }
}