package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.undone.easy.MergeTwoBinaryTrees;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-12-27
 */
class MergeTwoBinaryTreesTest extends AbstractTest<MergeTwoBinaryTrees> {
    @Override
    protected Testsuite<MergeTwoBinaryTrees> testsuite() {
        return Testsuite.<MergeTwoBinaryTrees>builder()
                .add(ExpectedTestcase.of(TreeNode.of(3, 4, 5, 5, 4, null, 7),
                        s -> s.mergeTrees(TreeNode.of(1, 3, 2, 5), TreeNode.of(2, 1, 3, null, 4, null, 7))))
                .build();
    }
}