package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-10-03
 */
class FlattenBinaryTreeToLinkedListTest extends AbstractTest<FlattenBinaryTreeToLinkedList> {
    @Override
    protected Testsuite<FlattenBinaryTreeToLinkedList> testsuite() {
        return Testsuite.<FlattenBinaryTreeToLinkedList>builder()
                .add(ExpectedTestcase.of(
                        t -> {
                            TreeNode root = TreeNode.of(1, 2, 5, 3, 4, null, 6);
                            t.flatten(root);
                            return root;
                        }, TreeNode.of(1, null, 2, null, 3, null, 4, null, 5, null, 6)
                ))
                .build();
    }
}