package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;
import com.leammin.leetcode.util.test.VerifiableTestcase;
import org.assertj.core.api.Assertions;

/**
 * @author Leammin
 * @date 2020-06-28
 */
class FindDuplicateSubtreesTest extends AbstractTest<FindDuplicateSubtrees> {
    @Override
    protected Testsuite<FindDuplicateSubtrees> testsuite() {
        return Testsuite.<FindDuplicateSubtrees>builder()
                .add(VerifiableTestcase.ofConsumer(t -> t.findDuplicateSubtrees(TreeNode.of(1, 2, 3, 4, null, 2, 4, null, null, 4)),
                        r -> Assertions.assertThat(r).containsExactlyInAnyOrder(TreeNode.of(2, 4), TreeNode.of(4))))
                .add(VerifiableTestcase.ofConsumer(t -> t.findDuplicateSubtrees(TreeNode.of(0, 0, 0, 0, null, null, 0, null, null, null, 0)),
                        r -> Assertions.assertThat(r).containsExactlyInAnyOrder(TreeNode.of(0))))
                .build();
    }
}