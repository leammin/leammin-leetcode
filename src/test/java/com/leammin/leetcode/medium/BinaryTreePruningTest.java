package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-12-29
 */
class BinaryTreePruningTest extends AbstractTest<BinaryTreePruning> {
    @Override
    protected Testsuite<BinaryTreePruning> testsuite() {
        return Testsuite.<BinaryTreePruning>builder()
                .add(ExpectedTestcase.of(s -> s.pruneTree(TreeNode.of(1, null, 0, 0, 1)), TreeNode.of(1, null, 0, null, 1)))
                .add(ExpectedTestcase.of(s -> s.pruneTree(TreeNode.of(1,0,1,0,0,0,1)), TreeNode.of(1,null,1,null,1)))
                .add(ExpectedTestcase.of(s -> s.pruneTree(TreeNode.of(1,1,0,1,1,0,1,0)), TreeNode.of(1,1,0,1,1,null,1)))
                .build();
    }
}