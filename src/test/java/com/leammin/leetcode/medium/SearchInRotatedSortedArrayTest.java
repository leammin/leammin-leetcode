package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-04-03
 */
class SearchInRotatedSortedArrayTest extends AbstractTest<SearchInRotatedSortedArray> {
    @Override
    protected Testsuite<SearchInRotatedSortedArray> testsuite() {
        return Testsuite.<SearchInRotatedSortedArray>builder()
                .add(ExpectedTestcase.of(t->t.search(new int[]{4,5,6,7,0,1,2}, 0), 4))
                .add(ExpectedTestcase.of(t->t.search(new int[]{4,5,6,7,0,1,2}, 3), -1))
                .add(ExpectedTestcase.of(t->t.search(new int[]{1,3}, 3), 1))
                .build();
    }
}