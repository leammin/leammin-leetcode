package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-10-02
 */
class BalancedBinaryTreeTest extends AbstractTest<BalancedBinaryTree> {
    @Override
    protected Testsuite<BalancedBinaryTree> testsuite() {
        return Testsuite.<BalancedBinaryTree>builder()
                .add(ExpectedTestcase.of(t -> t.isBalanced(TreeNode.of(3, 9, 20, null, null, 15, 7)), true))
                .add(ExpectedTestcase.of(t -> t.isBalanced(TreeNode.of(1,2,2,3,3,null,null,4,4)), false))
                .build();
    }
}