package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-12-29
 */
class InvertBinaryTreeTest extends AbstractTest<InvertBinaryTree> {
    @Override
    protected Testsuite<InvertBinaryTree> testsuite() {
        return Testsuite.<InvertBinaryTree>builder()
                .add(ExpectedTestcase.of(TreeNode.of(4, 7, 2, 9, 6, 3, 1), s -> s.invertTree(TreeNode.of(4, 2, 7, 1, 3, 6, 9))))
                .build();
    }
}