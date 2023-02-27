package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

import java.util.List;

/**
 * @author Leammin
 * @date 2020-01-04
 */
class AllElementsInTwoBinarySearchTreesTest extends AbstractTest<AllElementsInTwoBinarySearchTrees> {
    @Override
    protected Testsuite<AllElementsInTwoBinarySearchTrees> testsuite() {
        return Testsuite.<AllElementsInTwoBinarySearchTrees>builder()
                .add(ExpectedTestcase.of(s -> s.getAllElements(TreeNode.of(2, 1, 4), TreeNode.of(1, 0, 3)), List.of(0, 1, 1, 2, 3, 4)))
                .add(ExpectedTestcase.of(s -> s.getAllElements(TreeNode.of(0, -10, 10), TreeNode.of(5, 1, 7, 0, 2)), List.of(-10, 0, 0, 1, 2, 5, 7, 10)))
                .add(ExpectedTestcase.of(s -> s.getAllElements(TreeNode.of(), TreeNode.of(5, 1, 7, 0, 2)), List.of(0, 1, 2, 5, 7)))
                .add(ExpectedTestcase.of(s -> s.getAllElements(TreeNode.of(0, -10, 10), TreeNode.of()), List.of(-10, 0, 10)))
                .add(ExpectedTestcase.of(s -> s.getAllElements(TreeNode.of(1, null, 8), TreeNode.of(8, 1)), List.of(1, 1, 8, 8)))
                .build();
    }
}