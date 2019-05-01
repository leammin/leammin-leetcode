package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.EqualTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-05-01
 */
class ConvertSortedArrayToBinarySearchTreeTest extends AbstractTest<ConvertSortedArrayToBinarySearchTree> {

    @Override
    protected Testsuite<ConvertSortedArrayToBinarySearchTree> testsuite() {
        return Testsuite.<ConvertSortedArrayToBinarySearchTree>builder()
                .add(EqualTestcase.of(TreeNode.of(0, -3, 9, -10, null, 5),
                        s -> s.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9})))
                .build();
    }
}