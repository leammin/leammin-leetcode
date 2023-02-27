package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

import java.util.List;

/**
 * @author Leammin
 * @date 2021-04-05
 */
class NAryTreeLevelOrderTraversalTest extends AbstractTest<NAryTreeLevelOrderTraversal> {
    @Override
    protected Testsuite<NAryTreeLevelOrderTraversal> testsuite() {
        NAryTreeLevelOrderTraversal.Node root = new NAryTreeLevelOrderTraversal.Node(1,
                List.of(new NAryTreeLevelOrderTraversal.Node(3,
                                List.of(new NAryTreeLevelOrderTraversal.Node(5),
                                        new NAryTreeLevelOrderTraversal.Node(6))),
                        new NAryTreeLevelOrderTraversal.Node(2),
                        new NAryTreeLevelOrderTraversal.Node(4)));

        return Testsuite.<NAryTreeLevelOrderTraversal>builder()
                .addExpected(t -> t.levelOrder(root), List.of(List.of(1), List.of(3, 2, 4), List.of(5, 6)))
                .build();
    }
}