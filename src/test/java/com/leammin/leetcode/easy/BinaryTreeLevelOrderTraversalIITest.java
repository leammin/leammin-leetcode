package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

import java.util.List;

/**
 * @author Leammin
 * @date 2019-09-30
 */
class BinaryTreeLevelOrderTraversalIITest extends AbstractTest<BinaryTreeLevelOrderTraversalII> {
    @Override
    protected Testsuite<BinaryTreeLevelOrderTraversalII> testsuite() {
        return Testsuite.<BinaryTreeLevelOrderTraversalII>builder()
                .add(ExpectedTestcase.of(
                        t -> t.levelOrderBottom(TreeNode.of(3, 9, 20, null, null, 15, 7)), List.of(
                                List.of(15,7),
                                List.of(9,20),
                                List.of(3)
                        )
                ))
                .build();
    }
}