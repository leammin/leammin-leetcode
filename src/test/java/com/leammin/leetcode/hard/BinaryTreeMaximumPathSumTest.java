package com.leammin.leetcode.hard;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2019-10-03
 */
class BinaryTreeMaximumPathSumTest extends AbstractTest<BinaryTreeMaximumPathSum> {
    @Override
    protected Testsuite<BinaryTreeMaximumPathSum> testsuite() {
        return Testsuite.<BinaryTreeMaximumPathSum>builder()
                .add(ExpectedTestcase.of(t -> t.maxPathSum(TreeNode.of(1, 2, 3)), 6))
                .add(ExpectedTestcase.of(t -> t.maxPathSum(TreeNode.of(-10, 9, 20, null, null, 15, 7)), 42))
                .add(ExpectedTestcase.of(t -> t.maxPathSum(TreeNode.of(-3)), -3))
                .add(ExpectedTestcase.of(t -> t.maxPathSum(TreeNode.of(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1)), 48))
                .build();
    }
}