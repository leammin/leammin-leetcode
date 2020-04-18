package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-12-27
 */
class MaximumBinaryTreeTest extends AbstractTest<MaximumBinaryTree> {
    @Override
    protected Testsuite<MaximumBinaryTree> testsuite() {
        return Testsuite.<MaximumBinaryTree>builder()
                .add(ExpectedTestcase.of(s -> s.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5}), TreeNode.of(6, 3, 5, null, 2, 0, null, null, 1)))
                .build();
    }
}