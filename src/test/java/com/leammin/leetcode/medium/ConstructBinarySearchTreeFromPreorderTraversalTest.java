package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2019-12-30
 */
class ConstructBinarySearchTreeFromPreorderTraversalTest extends AbstractTest<ConstructBinarySearchTreeFromPreorderTraversal> {
    @Override
    protected Testsuite<ConstructBinarySearchTreeFromPreorderTraversal> testsuite() {
        return Testsuite.<ConstructBinarySearchTreeFromPreorderTraversal>builder()
                .add(ExpectedTestcase.of(s -> s.bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12}), TreeNode.of(8, 5, 10, 1, 7, null, 12)))
                .build();
    }
}