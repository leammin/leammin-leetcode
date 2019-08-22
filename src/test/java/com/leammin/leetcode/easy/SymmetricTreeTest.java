package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.undone.easy.SymmetricTree;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

import static org.junit.jupiter.api.Assertions.*;

class SymmetricTreeTest extends AbstractTest<SymmetricTree> {

    @Override
    protected Testsuite<SymmetricTree> testsuite() {
        return Testsuite.<SymmetricTree>builder()
                .add(ExpectedTestcase.of(false, t -> t.isSymmetric(TreeNode.of(1,2,2,null,3,null,3))))
                .add(ExpectedTestcase.of(true, t -> t.isSymmetric(TreeNode.of(1,2,2,3,4,4,3))))
                .build();
    }
}