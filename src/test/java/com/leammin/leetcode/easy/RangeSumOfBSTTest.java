package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-12-27
 */
class RangeSumOfBSTTest extends AbstractTest<RangeSumOfBST> {
    @Override
    protected Testsuite<RangeSumOfBST> testsuite() {
        return Testsuite.<RangeSumOfBST>builder()
                .add(ExpectedTestcase.of(32, s -> s.rangeSumBST(TreeNode.of(10, 5, 15, 3, 7, null, 18), 7, 15)))
                .add(ExpectedTestcase.of(23, s -> s.rangeSumBST(TreeNode.of(10, 5, 15, 3, 7, 13, 18, 1, null, 6), 6, 10)))
                .build();
    }
}