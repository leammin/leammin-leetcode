package com.leammin.leetcode.hard;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.undone.hard.RecoverBinarySearchTree;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;
import com.leammin.leetcode.util.TreeNodeUtils;

/**
 * @author Leammin
 * @date 2019-09-22
 */
class RecoverBinarySearchTreeTest extends AbstractTest<RecoverBinarySearchTree> {
    @Override
    protected Testsuite<RecoverBinarySearchTree> testsuite() {
        return Testsuite.<RecoverBinarySearchTree>builder()
                .add(ExpectedTestcase.of(t -> {
                    TreeNode root = TreeNode.of(1, 3, null, null, 2);
                    t.recoverTree(root);
                    return TreeNodeUtils.isBst(root);
                }, true))
                .build();
    }
}