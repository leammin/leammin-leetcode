package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-02-05
 */
class GetEqualSubstringsWithinBudgetTest extends AbstractTest<GetEqualSubstringsWithinBudget> {
    @Override
    protected Testsuite<GetEqualSubstringsWithinBudget> testsuite() {
        return Testsuite.<GetEqualSubstringsWithinBudget>builder()
                .add(ExpectedTestcase.of(t -> t.equalSubstring("abcd", "bcdf", 3), 3))
                .add(ExpectedTestcase.of(t -> t.equalSubstring("abcd", "cdef", 3), 1))
                .add(ExpectedTestcase.of(t -> t.equalSubstring("abcd", "acde", 0), 1))
                .build();
    }

}