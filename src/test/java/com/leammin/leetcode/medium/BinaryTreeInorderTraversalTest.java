package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

import java.util.List;

/**
 * @author Leammin
 * @date 2020-01-04
 */
class BinaryTreeInorderTraversalTest extends AbstractTest<BinaryTreeInorderTraversal> {
    @Override
    protected Testsuite<BinaryTreeInorderTraversal> testsuite() {
        return Testsuite.<BinaryTreeInorderTraversal>builder()
                .add(ExpectedTestcase.of(List.of(1, 3, 2), s -> s.inorderTraversal(TreeNode.of(1, null, 2, 3))))
                .build();
    }
}