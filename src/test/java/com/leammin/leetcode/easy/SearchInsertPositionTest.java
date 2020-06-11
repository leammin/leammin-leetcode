package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-12
 */
class SearchInsertPositionTest extends AbstractTest<SearchInsertPosition> {
    @Override
    protected Testsuite<SearchInsertPosition> testsuite() {
        return Testsuite.<SearchInsertPosition>builder()
                .add(ExpectedTestcase.of(t -> t.searchInsert(new int[]{1, 3, 5, 6}, 5), 2))
                .add(ExpectedTestcase.of(t -> t.searchInsert(new int[]{1, 3, 5, 6}, 2), 1))
                .add(ExpectedTestcase.of(t -> t.searchInsert(new int[]{1, 3, 5, 6}, 7), 4))
                .add(ExpectedTestcase.of(t -> t.searchInsert(new int[]{1, 3, 5, 6}, 0), 0))
                .build();
    }
}