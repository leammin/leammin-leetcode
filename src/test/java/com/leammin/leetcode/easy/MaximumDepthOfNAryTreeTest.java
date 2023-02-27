package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

import java.util.List;

/**
 * @author Leammin
 * @date 2021-04-05
 */
class MaximumDepthOfNAryTreeTest extends AbstractTest<MaximumDepthOfNAryTree> {
    @Override
    protected Testsuite<MaximumDepthOfNAryTree> testsuite() {
        MaximumDepthOfNAryTree.Node root = new MaximumDepthOfNAryTree.Node(1,
                List.of(new MaximumDepthOfNAryTree.Node(3,
                                List.of(new MaximumDepthOfNAryTree.Node(5),
                                        new MaximumDepthOfNAryTree.Node(6))),
                        new MaximumDepthOfNAryTree.Node(2),
                        new MaximumDepthOfNAryTree.Node(4)));

        return Testsuite.<MaximumDepthOfNAryTree>builder()
                .addExpected(t -> t.maxDepth(root), 3)
                .build();
    }
}