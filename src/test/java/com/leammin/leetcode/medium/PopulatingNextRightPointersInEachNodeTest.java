package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-16
 */
class PopulatingNextRightPointersInEachNodeTest extends AbstractTest<PopulatingNextRightPointersInEachNode> {
    @Override
    protected Testsuite<PopulatingNextRightPointersInEachNode> testsuite() {
        return Testsuite.<PopulatingNextRightPointersInEachNode>builder()
                .add(ExpectedTestcase.ofSupplier(
                        t -> t.connect(new PopulatingNextRightPointersInEachNode.Node(
                                1,
                                new PopulatingNextRightPointersInEachNode.Node(2, new PopulatingNextRightPointersInEachNode.Node(4), new PopulatingNextRightPointersInEachNode.Node(5), null),
                                new PopulatingNextRightPointersInEachNode.Node(3, new PopulatingNextRightPointersInEachNode.Node(6), new PopulatingNextRightPointersInEachNode.Node(7), null),
                                null
                        )), () -> {
                            PopulatingNextRightPointersInEachNode.Node node7 = new PopulatingNextRightPointersInEachNode.Node(7);
                            PopulatingNextRightPointersInEachNode.Node node6 = new PopulatingNextRightPointersInEachNode.Node(6, null, null, node7);
                            PopulatingNextRightPointersInEachNode.Node node5 = new PopulatingNextRightPointersInEachNode.Node(5, null, null, node6);
                            PopulatingNextRightPointersInEachNode.Node node4 = new PopulatingNextRightPointersInEachNode.Node(4, null, null, node5);
                            PopulatingNextRightPointersInEachNode.Node node3 = new PopulatingNextRightPointersInEachNode.Node(3, node6, node7, null);
                            PopulatingNextRightPointersInEachNode.Node node2 = new PopulatingNextRightPointersInEachNode.Node(2, node4, node5, node3);
                            return new PopulatingNextRightPointersInEachNode.Node(1, node2, node3, null);
                        }
                ))
                .build();
    }
}