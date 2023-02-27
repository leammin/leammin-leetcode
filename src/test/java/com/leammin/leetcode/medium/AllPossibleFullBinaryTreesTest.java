package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;
import com.leammin.leetcode.util.test.VerifiableTestcase;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Leammin
 * @date 2019-12-27
 */
class AllPossibleFullBinaryTreesTest extends AbstractTest<AllPossibleFullBinaryTrees> {
    @Override
    protected Testsuite<AllPossibleFullBinaryTrees> testsuite() {
        return Testsuite.<AllPossibleFullBinaryTrees>builder()
                .add(VerifiableTestcase.of(
                        s -> s.allPossibleFBT(7), output -> {
                            Set<TreeNode> expected = Set.of(
                                    TreeNode.of(0, 0, 0, null, null, 0, 0, null, null, 0, 0),
                                    TreeNode.of(0, 0, 0, null, null, 0, 0, 0, 0),
                                    TreeNode.of(0, 0, 0, 0, 0, 0, 0),
                                    TreeNode.of(0, 0, 0, 0, 0, null, null, null, null, 0, 0),
                                    TreeNode.of(0, 0, 0, 0, 0, null, null, 0, 0)
                            );
                            return expected.size() == output.size() && expected.equals(new HashSet<>(output));
                        }
                ))
                .build();
    }
}