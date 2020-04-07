package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-04-03
 */
class SearchInRotatedSortedArrayTest extends AbstractTest<SearchInRotatedSortedArray> {
    @Override
    protected Testsuite<SearchInRotatedSortedArray> testsuite() {
        return Testsuite.<SearchInRotatedSortedArray>builder()
                .add(ExpectedTestcase.of(4, t->t.search(new int[]{4,5,6,7,0,1,2}, 0)))
                .add(ExpectedTestcase.of(-1, t->t.search(new int[]{4,5,6,7,0,1,2}, 3)))
                .add(ExpectedTestcase.of(1, t->t.search(new int[]{1,3}, 3)))
                .build();
    }
}