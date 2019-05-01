package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.EqualTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-04-20
 */
class ContainsDuplicateTest extends AbstractTest<ContainsDuplicate> {
    @Override
    protected Testsuite<ContainsDuplicate> testsuite() {
        return Testsuite.<ContainsDuplicate>builder()
                .add(EqualTestcase.of(true, s -> s.containsDuplicate(new int[]{1, 2, 3, 1})))
                .add(EqualTestcase.of(false, s -> s.containsDuplicate(new int[]{1, 2, 3, 4, 5})))
                .add(EqualTestcase.of(true, s -> s.containsDuplicate(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 12})))
                .build();
    }
}