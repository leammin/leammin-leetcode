package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

import java.util.List;

/**
 * @author Leammin
 * @date 2019-09-07
 */
class BinaryTreeZigzagLevelOrderTraversalTest extends AbstractTest<BinaryTreeZigzagLevelOrderTraversal> {
    @Override
    protected Testsuite<BinaryTreeZigzagLevelOrderTraversal> testsuite() {
        return Testsuite.<BinaryTreeZigzagLevelOrderTraversal>builder()
                .add(ExpectedTestcase.of(
                        t -> t.zigzagLevelOrder(TreeNode.of(3, 9, 20, null, null, 15, 7)), List.of(
                                List.of(3),
                                List.of(20, 9),
                                List.of(15, 7)
                        )
                ))
                .add(ExpectedTestcase.of(
                        t -> t.zigzagLevelOrder(TreeNode.of(1,2,3,4,null,null,5)), List.of(
                                List.of(1),
                                List.of(3, 2),
                                List.of(4, 5)
                        )
                ))
                .build();
    }
}