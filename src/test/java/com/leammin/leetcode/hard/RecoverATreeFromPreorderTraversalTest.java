package com.leammin.leetcode.hard;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-18
 */
class RecoverATreeFromPreorderTraversalTest extends AbstractTest<RecoverATreeFromPreorderTraversal> {
    @Override
    protected Testsuite<RecoverATreeFromPreorderTraversal> testsuite() {
        return Testsuite.<RecoverATreeFromPreorderTraversal>builder()
                .add(ExpectedTestcase.of(t -> t.recoverFromPreorder("1-2--3--4-5--6--7"), TreeNode.of(1, 2, 5, 3, 4, 6, 7)))
                .add(ExpectedTestcase.of(t -> t.recoverFromPreorder("1-2--3---4-5--6---7"), TreeNode.of(1, 2, 5, 3, null, 6, null, 4, null, 7)))
                .add(ExpectedTestcase.of(t -> t.recoverFromPreorder("1-401--349---90--88"), TreeNode.of(1, 401, null, 349, 88, 90)))
                .build();
    }
}