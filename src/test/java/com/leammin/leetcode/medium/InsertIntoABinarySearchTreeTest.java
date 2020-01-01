package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.undone.medium.InsertIntoABinarySearchTree;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;
import com.leammin.leetcode.util.TreeNodeUtils;
import com.leammin.leetcode.util.VerifiableTestcase;

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
                        root -> TreeNodeUtils.isBst(root) &&
                                TreeNodeUtils.serialize(root)
                                        .stream()
                                        .filter(Objects::nonNull)
                                        .collect(Collectors.toSet())
                                        .equals(Set.of(4, 2, 7, 1, 3, 5)),
                        s -> s.insertIntoBST(TreeNode.of(4, 2, 7, 1, 3), 5)))
                .build();
    }
}