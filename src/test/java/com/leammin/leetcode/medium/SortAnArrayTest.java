package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-31
 */
class SortAnArrayTest extends AbstractTest<SortAnArray> {
    @Override
    protected Testsuite<SortAnArray> testsuite() {
        return Testsuite.<SortAnArray>builder()
                .add(ExpectedTestcase.of(t -> t.sortArray(new int[]{5, 2, 3, 1}), new int[]{1, 2, 3, 5}))
                .add(ExpectedTestcase.of(t -> t.sortArray(new int[]{5,1,1,2,0,0}), new int[]{0,0,1,1,2,5}))
                .add(ExpectedTestcase.of(t -> t.sortArray(new int[]{1, 2, 3, 5}), new int[]{1, 2, 3, 5}))
                .build();
    }
}