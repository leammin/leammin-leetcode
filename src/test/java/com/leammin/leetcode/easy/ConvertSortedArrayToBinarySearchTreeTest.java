package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;
import com.leammin.leetcode.util.TreeNodeUtils;
import com.leammin.leetcode.util.test.VerifiableTestcase;

/**
 * @author Leammin
 * @date 2019-05-01
 */
class ConvertSortedArrayToBinarySearchTreeTest extends AbstractTest<ConvertSortedArrayToBinarySearchTree> {
    @Override
    protected Testsuite<ConvertSortedArrayToBinarySearchTree> testsuite() {
        return Testsuite.<ConvertSortedArrayToBinarySearchTree>builder()
                .add(VerifiableTestcase.of(s -> s.sortedArrayToBST(new int[]{}), TreeNodeUtils::isAvl))
                .add(VerifiableTestcase.of(s -> s.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}), TreeNodeUtils::isAvl))
                .add(VerifiableTestcase.of(s -> s.sortedArrayToBST(new int[]{
                        -10, -3, -1, 0, 5, 9, 10, 11, 13, 28, 30,
                        31, 32, 33, 59, 100, 156, 258, 1024, 1025}), TreeNodeUtils::isAvl))
                .build();
    }
}