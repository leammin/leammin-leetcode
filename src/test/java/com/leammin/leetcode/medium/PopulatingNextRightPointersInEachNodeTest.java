package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.Node;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-16
 */
class PopulatingNextRightPointersInEachNodeTest extends AbstractTest<PopulatingNextRightPointersInEachNode> {
    @Override
    protected Testsuite<PopulatingNextRightPointersInEachNode> testsuite() {
        return Testsuite.<PopulatingNextRightPointersInEachNode>builder()
                .add(ExpectedTestcase.of(
                        () -> {
                            Node node7 = new Node(7);
                            Node node6 = new Node(6, null, null, node7);
                            Node node5 = new Node(5, null, null, node6);
                            Node node4 = new Node(4, null, null, node5);
                            Node node3 = new Node(3, node6, node7, null);
                            Node node2 = new Node(2, node4, node5, node3);
                            return new Node(1, node2, node3, null);
                        },
                        t -> t.connect(new Node(
                                1,
                                new Node(2, new Node(4), new Node(5), null),
                                new Node(3, new Node(6), new Node(7), null),
                                null
                        ))))
                .build();
    }
}