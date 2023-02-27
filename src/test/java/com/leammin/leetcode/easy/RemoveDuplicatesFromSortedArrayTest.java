package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-15
 */
class RemoveDuplicatesFromSortedArrayTest extends AbstractTest<RemoveDuplicatesFromSortedArray> {
    @Override
    protected Testsuite<RemoveDuplicatesFromSortedArray> testsuite() {
        return Testsuite.<RemoveDuplicatesFromSortedArray>builder()
                .add(ExpectedTestcase.of(t -> t.removeDuplicates(new int[]{1,1,2}), 2))
                .add(ExpectedTestcase.of(t -> t.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}), 5))
                .build();
    }
}