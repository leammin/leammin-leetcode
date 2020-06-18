package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-17
 */
class BinarySearchTest extends AbstractTest<BinarySearch> {
    @Override
    protected Testsuite<BinarySearch> testsuite() {
        return Testsuite.<BinarySearch>builder()
                .add(ExpectedTestcase.of(t -> t.search(new int[]{-1,0,3,5,9,12}, 9), 4))
                .add(ExpectedTestcase.of(t -> t.search(new int[]{-1,0,3,5,9,12}, 2), -1))
                .build();
    }
}