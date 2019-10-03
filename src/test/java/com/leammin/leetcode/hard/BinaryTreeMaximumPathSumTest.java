package com.leammin.leetcode.hard;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-10-03
 */
class BinaryTreeMaximumPathSumTest extends AbstractTest<BinaryTreeMaximumPathSum> {
    @Override
    protected Testsuite<BinaryTreeMaximumPathSum> testsuite() {
        return Testsuite.<BinaryTreeMaximumPathSum>builder()
                .add(ExpectedTestcase.of(6, t -> t.maxPathSum(TreeNode.of(1, 2, 3))))
                .add(ExpectedTestcase.of(42, t -> t.maxPathSum(TreeNode.of(-10, 9, 20, null, null, 15, 7))))
                .add(ExpectedTestcase.of(-3, t -> t.maxPathSum(TreeNode.of(-3))))
                .add(ExpectedTestcase.of(48, t -> t.maxPathSum(TreeNode.of(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1))))
                .build();
    }
}