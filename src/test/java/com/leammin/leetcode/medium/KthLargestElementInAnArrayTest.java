package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-31
 */
class KthLargestElementInAnArrayTest extends AbstractTest<KthLargestElementInAnArray> {
    @Override
    protected Testsuite<KthLargestElementInAnArray> testsuite() {
        return Testsuite.<KthLargestElementInAnArray>builder()
                .add(ExpectedTestcase.of(t -> t.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2), 5))
                .add(ExpectedTestcase.of(t -> t.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4), 4))
                .build();
    }
}