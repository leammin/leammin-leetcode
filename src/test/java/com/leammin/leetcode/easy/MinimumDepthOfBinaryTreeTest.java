package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.undone.easy.MinimumDepthOfBinaryTree;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

import java.util.Collections;
import java.util.List;

/**
 * @author Leammin
 * @date 2019-10-02
 */
class MinimumDepthOfBinaryTreeTest extends AbstractTest<MinimumDepthOfBinaryTree> {

    @Override
    protected List<Class<? extends MinimumDepthOfBinaryTree>> solutions() {
        return Collections.singletonList(MinimumDepthOfBinaryTree.Solution2.class);
    }

    @Override
    protected Testsuite<MinimumDepthOfBinaryTree> testsuite() {
        return Testsuite.<MinimumDepthOfBinaryTree>builder()
                .add(ExpectedTestcase.of(2, t -> t.minDepth(TreeNode.of(3, 9, 20, null, null, 15, 7))))
                .add(ExpectedTestcase.of(2, t -> t.minDepth(TreeNode.of(1,2))))
                .build();
    }
}