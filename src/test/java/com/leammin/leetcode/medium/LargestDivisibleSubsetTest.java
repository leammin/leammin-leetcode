package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

import java.util.List;
import java.util.Set;

/**
 * @author Leammin
 * @date 2021-04-23
 */
class LargestDivisibleSubsetTest extends AbstractTest<LargestDivisibleSubset> {
    @Override
    protected Testsuite<LargestDivisibleSubset> testsuite() {
        return Testsuite.<LargestDivisibleSubset>builder()
                .addAnyExpected(t -> Set.copyOf(t.largestDivisibleSubset(new int[]{1,2,3})), List.of(Set.of(1, 2), Set.of(1,3)))
                .addAnyExpected(t -> Set.copyOf(t.largestDivisibleSubset(new int[]{2,3,4,9,8})), List.of(Set.of(2,4,8)))
                .build();
    }
}