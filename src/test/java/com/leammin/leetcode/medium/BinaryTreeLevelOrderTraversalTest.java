package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

import java.util.List;

/**
 * @author Leammin
 * @date 2019-09-30
 */
class BinaryTreeLevelOrderTraversalTest extends AbstractTest<BinaryTreeLevelOrderTraversal> {
    @Override
    protected Testsuite<BinaryTreeLevelOrderTraversal> testsuite() {
        return Testsuite.<BinaryTreeLevelOrderTraversal>builder()
                .add(ExpectedTestcase.of(
                        t -> t.levelOrder(TreeNode.of(3, 9, 20, null, null, 15, 7)), List.of(
                                List.of(3),
                                List.of(9,20),
                                List.of(15,7)
                        )
                ))
                .build();
    }
}