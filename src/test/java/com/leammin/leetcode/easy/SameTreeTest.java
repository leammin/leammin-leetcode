package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-09-22
 */
class SameTreeTest extends AbstractTest<SameTree> {
    @Override
    protected Testsuite<SameTree> testsuite() {
        return Testsuite.<SameTree>builder()
                .add(ExpectedTestcase.of(true, t -> t.isSameTree(TreeNode.of(1, 2, 3), TreeNode.of(1, 2, 3))))
                .add(ExpectedTestcase.of(false, t -> t.isSameTree(TreeNode.of(1, 2), TreeNode.of(1, null, 2))))
                .add(ExpectedTestcase.of(false, t -> t.isSameTree(TreeNode.of(1, 2, 1), TreeNode.of(1, 1, 2))))
                .build();
    }
}