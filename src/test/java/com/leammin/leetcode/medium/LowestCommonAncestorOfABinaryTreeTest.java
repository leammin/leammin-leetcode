package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-05-11
 */
class LowestCommonAncestorOfABinaryTreeTest extends AbstractTest<LowestCommonAncestorOfABinaryTree> {
    @Override
    protected Testsuite<LowestCommonAncestorOfABinaryTree> testsuite() {
        return Testsuite.<LowestCommonAncestorOfABinaryTree>builder()
                .add(ExpectedTestcase.of(t -> t.lowestCommonAncestor(TreeNode.of(3,5,1,6,2,0,8,null,null,7,4), TreeNode.of(5), TreeNode.of(1)).val, 3))
                .add(ExpectedTestcase.of(t -> t.lowestCommonAncestor(TreeNode.of(3,5,1,6,2,0,8,null,null,7,4), TreeNode.of(5), TreeNode.of(4)).val, 5))
                .build();
    }
}