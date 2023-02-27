package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-03-31
 */
class RemoveDuplicatesFromSortedArrayIiTest extends AbstractTest<RemoveDuplicatesFromSortedArrayIi> {
    @Override
    protected Testsuite<RemoveDuplicatesFromSortedArrayIi> testsuite() {
        return Testsuite.<RemoveDuplicatesFromSortedArrayIi>builder()
                .add(ExpectedTestcase.of(t -> t.removeDuplicates(new int[]{1,1,1,2,2,3}), 5))
                .add(ExpectedTestcase.of(t -> t.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}), 7))
                .add(ExpectedTestcase.of(t -> t.removeDuplicates(new int[]{0}), 1))
                .add(ExpectedTestcase.of(t -> t.removeDuplicates(new int[]{0, 0}), 2))
                .build();
    }
}