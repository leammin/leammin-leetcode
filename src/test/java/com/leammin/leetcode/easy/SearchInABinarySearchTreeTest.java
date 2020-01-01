package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-01-01
 */
class SearchInABinarySearchTreeTest extends AbstractTest<SearchInABinarySearchTree> {
    @Override
    protected Testsuite<SearchInABinarySearchTree> testsuite() {
        return Testsuite.<SearchInABinarySearchTree>builder()
                .add(ExpectedTestcase.of(TreeNode.of(2, 1, 3), s -> s.searchBST(TreeNode.of(4, 2, 7, 1, 3), 2)))
                .build();
    }
}