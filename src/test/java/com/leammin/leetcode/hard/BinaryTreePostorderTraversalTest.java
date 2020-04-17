package com.leammin.leetcode.hard;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

import java.util.List;

/**
 * @author Leammin
 * @date 2019-10-06
 */
class BinaryTreePostorderTraversalTest extends AbstractTest<BinaryTreePostorderTraversal> {
    @Override
    protected Testsuite<BinaryTreePostorderTraversal> testsuite() {
        return Testsuite.<BinaryTreePostorderTraversal>builder()
                .add(ExpectedTestcase.of(t -> t.postorderTraversal(TreeNode.of(1, null, 2, 3)), List.of(3, 2, 1)))
                .add(ExpectedTestcase.of(t -> t.postorderTraversal(TreeNode.of(3, 1, 2)), List.of(1,2,3)))
                .build();
    }
}