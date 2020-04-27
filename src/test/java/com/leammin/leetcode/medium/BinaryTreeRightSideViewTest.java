package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

import java.util.List;

/**
 * @author Leammin
 * @date 2020-04-22
 */
class BinaryTreeRightSideViewTest extends AbstractTest<BinaryTreeRightSideView> {
    @Override
    protected Testsuite<BinaryTreeRightSideView> testsuite() {
        return Testsuite.<BinaryTreeRightSideView>builder()
                .add(ExpectedTestcase.of(t -> t.rightSideView(TreeNode.of(1, 2, 3, null, 5, null, 4)), List.of(1, 3, 4)))
                .build();
    }
}