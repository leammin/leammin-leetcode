package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.undone.easy.LeafSimilarTrees;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-05-10
 */
class LeafSimilarTreesTest extends AbstractTest<LeafSimilarTrees> {
    @Override
    protected Testsuite<LeafSimilarTrees> testsuite() {
        return Testsuite.<LeafSimilarTrees>builder()
            .addExpected(t -> t.leafSimilar(TreeNode.of(3, 5, 1, 6, 2, 9, 8, null, null, 7, 4),
                TreeNode.of(3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8)), true)
            .build();
    }
}