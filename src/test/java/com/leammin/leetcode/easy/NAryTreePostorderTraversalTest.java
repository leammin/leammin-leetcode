package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

import java.util.List;

/**
 * @author Leammin
 * @date 2021-04-05
 */
class NAryTreePostorderTraversalTest extends AbstractTest<NAryTreePostorderTraversal> {
    @Override
    protected Testsuite<NAryTreePostorderTraversal> testsuite() {
        NAryTreePostorderTraversal.Node root = new NAryTreePostorderTraversal.Node(1,
                List.of(new NAryTreePostorderTraversal.Node(3,
                                List.of(new NAryTreePostorderTraversal.Node(5),
                                        new NAryTreePostorderTraversal.Node(6))),
                        new NAryTreePostorderTraversal.Node(2),
                        new NAryTreePostorderTraversal.Node(4)));

        return Testsuite.<NAryTreePostorderTraversal>builder()
                .addExpected(t -> t.postorder(root), List.of(5,6,3,2,4,1))
                .build();
    }
}