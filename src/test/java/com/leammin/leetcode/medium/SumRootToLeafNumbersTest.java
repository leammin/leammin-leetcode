package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-10-05
 */
class SumRootToLeafNumbersTest extends AbstractTest<SumRootToLeafNumbers> {
    @Override
    protected Testsuite<SumRootToLeafNumbers> testsuite() {
        return Testsuite.<SumRootToLeafNumbers>builder()
                .add(ExpectedTestcase.of(25, t -> t.sumNumbers(TreeNode.of(1, 2, 3))))
                .add(ExpectedTestcase.of(1026, t -> t.sumNumbers(TreeNode.of(4, 9, 0, 5, 1))))
                .build();
    }
}