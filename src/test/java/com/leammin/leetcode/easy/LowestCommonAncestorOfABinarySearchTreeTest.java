package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-02-17
 */
class LowestCommonAncestorOfABinarySearchTreeTest extends AbstractTest<LowestCommonAncestorOfABinarySearchTree> {
    @Override
    protected Testsuite<LowestCommonAncestorOfABinarySearchTree> testsuite() {
        return Testsuite.<LowestCommonAncestorOfABinarySearchTree>builder()
                .add(ExpectedTestcase.of(t -> t.lowestCommonAncestor(TreeNode.of(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5),
                        TreeNode.of(2), TreeNode.of(8)).val, 6))
                .add(ExpectedTestcase.of(t -> t.lowestCommonAncestor(TreeNode.of(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5),
                        TreeNode.of(2), TreeNode.of(4)).val, 2))
                .build();
    }
}