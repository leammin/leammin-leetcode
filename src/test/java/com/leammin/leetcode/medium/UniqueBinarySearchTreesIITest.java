package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;
import com.leammin.leetcode.util.TreeNodeUtils;
import com.leammin.leetcode.util.VerifiableTestcase;
import org.assertj.core.api.Assertions;

import java.util.List;
import java.util.function.IntFunction;
import java.util.function.Predicate;

/**
 * @author Leammin
 * @date 2019-05-02
 */
class UniqueBinarySearchTreesIITest extends AbstractTest<UniqueBinarySearchTreesII> {

    @Override
    protected Testsuite<UniqueBinarySearchTreesII> testsuite() {
        IntFunction<Predicate<List<TreeNode>>> verifierFactory = length ->
                (nodes -> {
                    Assertions.assertThat(nodes)
                            .hasSize(length)
                            .allMatch(TreeNodeUtils::isBst);
                    for (int i = 0; i < nodes.size(); i++) {
                        for (int j = i + 1; j < nodes.size(); j++) {
                            Assertions.assertThat(TreeNodeUtils.structurallyEquals(nodes.get(i), nodes.get(j)))
                                    .withFailMessage("%s and %s is structurally equals", nodes.get(i), nodes.get(j))
                                    .isFalse();
                        }
                    }
                    return true;
                });
        return Testsuite.<UniqueBinarySearchTreesII>builder()
                .add(VerifiableTestcase.of(s -> s.generateTrees(0), verifierFactory.apply(0)))
                .add(VerifiableTestcase.of(s -> s.generateTrees(3), verifierFactory.apply(5)))
                .add(VerifiableTestcase.of(s -> s.generateTrees(4), verifierFactory.apply(14)))
                .add(VerifiableTestcase.of(s -> s.generateTrees(5), verifierFactory.apply(42)))
                .add(VerifiableTestcase.of(s -> s.generateTrees(6), verifierFactory.apply(132)))
                .add(VerifiableTestcase.of(s -> s.generateTrees(8), verifierFactory.apply(1430)))
                .build();
    }
}