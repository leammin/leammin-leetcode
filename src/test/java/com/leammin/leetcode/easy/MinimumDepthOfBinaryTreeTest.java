package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

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
                .add(ExpectedTestcase.of(t -> t.minDepth(TreeNode.of(3, 9, 20, null, null, 15, 7)), 2))
                .add(ExpectedTestcase.of(t -> t.minDepth(TreeNode.of(1,2)), 2))
                .build();
    }
}