package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

import java.util.List;

/**
 * @author Leammin
 * @date 2019-10-13
 */
class BinaryTreePreorderTraversalTest extends AbstractTest<BinaryTreePreorderTraversal> {
    @Override
    protected Testsuite<BinaryTreePreorderTraversal> testsuite() {
        return Testsuite.<BinaryTreePreorderTraversal>builder()
                .add(ExpectedTestcase.of(t -> t.preorderTraversal(TreeNode.of(1, null, 2, 3)), List.of(1, 2, 3)))
                .add(ExpectedTestcase.of(t -> t.preorderTraversal(TreeNode.of(1,4,3,2)), List.of(1,4,2,3)))
                .build();
    }
}