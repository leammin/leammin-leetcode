package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.undone.medium.DeleteNodeInABst;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;
import com.leammin.leetcode.util.VerifiableTestcase;
import org.assertj.core.api.Assertions;

/**
 * @author Leammin
 * @date 2020-06-30
 */
class DeleteNodeInABstTest extends AbstractTest<DeleteNodeInABst> {
    @Override
    protected Testsuite<DeleteNodeInABst> testsuite() {
        return Testsuite.<DeleteNodeInABst>builder()
                .add(VerifiableTestcase.ofConsumer(t -> t.deleteNode(TreeNode.of(5,3,6,2,4,null,7), 3),
                        r -> Assertions.assertThat(r).isIn(TreeNode.of(5,4,6,2,null,null,7), TreeNode.of(5,2,6,null,4,null,7))))
                .build();
    }
}