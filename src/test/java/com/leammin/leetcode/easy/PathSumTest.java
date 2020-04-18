package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-10-02
 */
class PathSumTest extends AbstractTest<PathSum> {
    @Override
    protected Testsuite<PathSum> testsuite() {
        return Testsuite.<PathSum>builder()
                .add(ExpectedTestcase.of(t -> t.hasPathSum(TreeNode.of(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1), 22), true))
                .add(ExpectedTestcase.of(t -> t.hasPathSum(TreeNode.of(1,2), 1), false))
                .build();
    }
}

