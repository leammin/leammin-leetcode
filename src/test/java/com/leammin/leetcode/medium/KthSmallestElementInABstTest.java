package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-17
 */
class KthSmallestElementInABstTest extends AbstractTest<KthSmallestElementInABst> {
    @Override
    protected Testsuite<KthSmallestElementInABst> testsuite() {
        return Testsuite.<KthSmallestElementInABst>builder()
                .add(ExpectedTestcase.of(t -> t.kthSmallest(TreeNode.of(3, 1, 4, null, 2), 1), 1))
                .add(ExpectedTestcase.of(t -> t.kthSmallest(TreeNode.of(5, 3, 6, 2, 4, null, null, 1), 3), 3))
                .build();
    }
}