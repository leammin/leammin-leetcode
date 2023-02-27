package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;
import com.leammin.leetcode.util.TreeNodeUtils;
import com.leammin.leetcode.util.test.VerifiableTestcase;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Leammin
 * @date 2020-01-01
 */
class InsertIntoABinarySearchTreeTest extends AbstractTest<InsertIntoABinarySearchTree> {
    @Override
    protected Testsuite<InsertIntoABinarySearchTree> testsuite() {
        return Testsuite.<InsertIntoABinarySearchTree>builder()
                .add(VerifiableTestcase.of(
                        s -> s.insertIntoBST(TreeNode.of(4, 2, 7, 1, 3), 5), root -> TreeNodeUtils.isBst(root) &&
                                TreeNodeUtils.serialize(root)
                                        .stream()
                                        .filter(Objects::nonNull)
                                        .collect(Collectors.toSet())
                                        .equals(Set.of(4, 2, 7, 1, 3, 5))
                ))
                .build();
    }
}