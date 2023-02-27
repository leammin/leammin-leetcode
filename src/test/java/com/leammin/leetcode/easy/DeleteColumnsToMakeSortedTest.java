package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2019-08-22
 */
class DeleteColumnsToMakeSortedTest extends AbstractTest<DeleteColumnsToMakeSorted> {
    @Override
    protected Testsuite<DeleteColumnsToMakeSorted> testsuite() {
        return Testsuite.<DeleteColumnsToMakeSorted>builder()
                .add(ExpectedTestcase.of(t -> t.minDeletionSize(new String[]{"a", "b"}), 0))
                .add(ExpectedTestcase.of(t -> t.minDeletionSize(new String[]{"cba", "daf", "ghi"}), 1))
                .add(ExpectedTestcase.of(t -> t.minDeletionSize(new String[]{"zyx", "wvu", "tsr"}), 3))
                .build();
    }
}