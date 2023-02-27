package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2019-09-23
 */
class ConstructBinaryTreeFromPreorderAndInorderTraversalTest extends AbstractTest<ConstructBinaryTreeFromPreorderAndInorderTraversal> {
    @Override
    protected Testsuite<ConstructBinaryTreeFromPreorderAndInorderTraversal> testsuite() {
        return Testsuite.<ConstructBinaryTreeFromPreorderAndInorderTraversal>builder()
                .add(ExpectedTestcase.of(t -> t.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}), TreeNode.of(3, 9, 20, null, null, 15, 7)))
                .build();
    }
}