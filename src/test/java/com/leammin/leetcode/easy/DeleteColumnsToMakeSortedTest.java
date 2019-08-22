package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-08-22
 */
class DeleteColumnsToMakeSortedTest extends AbstractTest<DeleteColumnsToMakeSorted> {
    @Override
    protected Testsuite<DeleteColumnsToMakeSorted> testsuite() {
        return Testsuite.<DeleteColumnsToMakeSorted>builder()
                .add(ExpectedTestcase.of(0, t -> t.minDeletionSize(new String[]{"a", "b"})))
                .add(ExpectedTestcase.of(1, t -> t.minDeletionSize(new String[]{"cba", "daf", "ghi"})))
                .add(ExpectedTestcase.of(3, t -> t.minDeletionSize(new String[]{"zyx", "wvu", "tsr"})))
                .build();
    }
}