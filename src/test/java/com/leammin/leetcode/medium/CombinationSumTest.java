package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

import java.util.Arrays;
import java.util.List;

/**
 * @author Leammin
 * @date 2023-02-01
 */
class CombinationSumTest extends AbstractTest<CombinationSum> {
    @Override
    protected Testsuite<CombinationSum> testsuite() {
        return Testsuite.<CombinationSum>builder()
                .addExpected(t -> sort(t.combinationSum(new int[]{2, 3, 6, 7}, 7)), List.of(List.of(2, 2, 3), List.of(7)))
                .addExpected(t -> sort(t.combinationSum(new int[]{2, 3, 5}, 8)), List.of(List.of(2, 2, 2, 2), List.of(2, 3, 3), List.of(3, 5)))
                .addExpected(t -> sort(t.combinationSum(new int[]{8,7,4,3}, 11)), List.of(List.of(2, 2, 2, 2), List.of(2, 3, 3), List.of(3, 5)))
                .build();
    }

    private List<List<Integer>> sort(List<List<Integer>> r) {
        return r.stream().map(l -> l.stream().sorted().toList()).sorted((o1, o2) -> Arrays.compare(o1.toArray(Integer[]::new), o2.toArray(Integer[]::new))).toList();
    }
}