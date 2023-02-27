package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2019-04-20
 */
class ContainsDuplicateTest extends AbstractTest<ContainsDuplicate> {
    @Override
    protected Testsuite<ContainsDuplicate> testsuite() {
        return Testsuite.<ContainsDuplicate>builder()
                .add(ExpectedTestcase.of(s -> s.containsDuplicate(new int[]{1, 2, 3, 1}), true))
                .add(ExpectedTestcase.of(s -> s.containsDuplicate(new int[]{1, 2, 3, 4, 5}), false))
                .add(ExpectedTestcase.of(s -> s.containsDuplicate(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 12}), true))
                .build();
    }
}