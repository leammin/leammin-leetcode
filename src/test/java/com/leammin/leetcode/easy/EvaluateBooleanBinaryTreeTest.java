package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2023-02-06
 */
class EvaluateBooleanBinaryTreeTest extends AbstractTest<EvaluateBooleanBinaryTree> {
    @Override
    protected Testsuite<EvaluateBooleanBinaryTree> testsuite() {
        return Testsuite.<EvaluateBooleanBinaryTree>builder()
                .addExpected(t -> t.evaluateTree(TreeNode.of(2,1,3,null,null,0,1)), true)
                .addExpected(t -> t.evaluateTree(TreeNode.of(0)), false)
                .build();
    }
}