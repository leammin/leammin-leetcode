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
                .add(ExpectedTestcase.of(t -> t.sumNumbers(TreeNode.of(1, 2, 3)), 25))
                .add(ExpectedTestcase.of(t -> t.sumNumbers(TreeNode.of(4, 9, 0, 5, 1)), 1026))
                .build();
    }
}