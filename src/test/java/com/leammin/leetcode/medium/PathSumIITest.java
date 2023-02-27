package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

import java.util.List;

/**
 * @author Leammin
 * @date 2019-10-02
 */
class PathSumIITest extends AbstractTest<PathSumII> {
    @Override
    protected Testsuite<PathSumII> testsuite() {
        return Testsuite.<PathSumII>builder()
                .add(ExpectedTestcase.of(
                        t -> t.pathSum(TreeNode.of(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1), 22), List.of(
                                List.of(5, 4, 11, 2),
                                List.of(5, 8, 4, 5)
                        )
                ))
                .build();
    }
}