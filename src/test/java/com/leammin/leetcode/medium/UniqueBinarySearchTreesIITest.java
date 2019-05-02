package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;
import com.leammin.leetcode.util.TreeNodeUtils;
import com.leammin.leetcode.util.VerifiableTestcase;
import org.assertj.core.api.Assertions;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntFunction;

/**
 * @author Leammin
 * @date 2019-05-02
 */
class UniqueBinarySearchTreesIITest extends AbstractTest<UniqueBinarySearchTreesII> {

    @Override
    protected Testsuite<UniqueBinarySearchTreesII> testsuite() {
        IntFunction<Consumer<List<TreeNode>>> verifierFactory = length ->
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
                });
        return Testsuite.<UniqueBinarySearchTreesII>builder()
                .add(VerifiableTestcase.of(verifierFactory.apply(0), s -> s.generateTrees(0)))
                .add(VerifiableTestcase.of(verifierFactory.apply(5), s -> s.generateTrees(3)))
                .add(VerifiableTestcase.of(verifierFactory.apply(14), s -> s.generateTrees(4)))
                .add(VerifiableTestcase.of(verifierFactory.apply(42), s -> s.generateTrees(5)))
                .add(VerifiableTestcase.of(verifierFactory.apply(132), s -> s.generateTrees(6)))
                .add(VerifiableTestcase.of(verifierFactory.apply(1430), s -> s.generateTrees(8)))
                .build();
    }
}