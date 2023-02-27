package com.leammin.leetcode.medium;

import com.leammin.leetcode.undone.medium.KthSmallestElementInASortedMatrix;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-07-02
 */
class KthSmallestElementInASortedMatrixTest extends AbstractTest<KthSmallestElementInASortedMatrix> {
    @Override
    protected Testsuite<KthSmallestElementInASortedMatrix> testsuite() {
        return Testsuite.<KthSmallestElementInASortedMatrix>builder()
                .add(ExpectedTestcase.of(t -> t.kthSmallest(new int[][]{
                        {1, 5, 9},
                        {10, 11, 13},
                        {12, 13, 15}
                }, 8), 13))
                .build();
    }
}