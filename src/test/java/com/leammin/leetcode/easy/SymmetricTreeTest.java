package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

class SymmetricTreeTest extends AbstractTest<SymmetricTree> {

    @Override
    protected Testsuite<SymmetricTree> testsuite() {
        return Testsuite.<SymmetricTree>builder()
                .add(ExpectedTestcase.of(t -> t.isSymmetric(TreeNode.of(1,2,2,null,3,null,3)), false))
                .add(ExpectedTestcase.of(t -> t.isSymmetric(TreeNode.of(1,2,2,3,4,4,3)), true))
                .build();
    }
}