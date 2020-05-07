package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-05-07
 */
class SubtreeOfAnotherTreeTest extends AbstractTest<SubtreeOfAnotherTree> {
    @Override
    protected Testsuite<SubtreeOfAnotherTree> testsuite() {
        return Testsuite.<SubtreeOfAnotherTree>builder()
                .add(ExpectedTestcase.of(t -> t.isSubtree(TreeNode.of(3, 4, 5, 1, 2), TreeNode.of(4, 1, 2)), true))
                .add(ExpectedTestcase.of(t -> t.isSubtree(TreeNode.of(3, 4, 5, 1, 2, null, null, null, null, 0), TreeNode.of(4, 1, 2)), false))
                .add(ExpectedTestcase.of(t -> t.isSubtree(TreeNode.of(3, 4, 5, 1, null, 2), TreeNode.of(3, 1, 2)), false))
                .build();
    }
}