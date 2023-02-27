package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

import java.util.List;

/**
 * @author Leammin
 * @date 2021-04-05
 */
class NAryTreePreorderTraversalTest extends AbstractTest<NAryTreePreorderTraversal> {
    @Override
    protected Testsuite<NAryTreePreorderTraversal> testsuite() {
        NAryTreePreorderTraversal.Node root = new NAryTreePreorderTraversal.Node(1,
                List.of(new NAryTreePreorderTraversal.Node(3,
                                List.of(new NAryTreePreorderTraversal.Node(5),
                                        new NAryTreePreorderTraversal.Node(6))),
                        new NAryTreePreorderTraversal.Node(2),
                        new NAryTreePreorderTraversal.Node(4)));

        return Testsuite.<NAryTreePreorderTraversal>builder()
                .addExpected(t -> t.preorder(root), List.of(1,3,5,6,2,4))
                .build();
    }
}