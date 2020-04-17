package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-10
 */
class DiameterOfBinaryTreeTest extends AbstractTest<DiameterOfBinaryTree> {
    @Override
    protected Testsuite<DiameterOfBinaryTree> testsuite() {
        return Testsuite.<DiameterOfBinaryTree>builder()
                .add(ExpectedTestcase.of(t -> t.diameterOfBinaryTree(TreeNode.of(1, 2, 3, 4, 5)), 3))
                .build();
    }
}