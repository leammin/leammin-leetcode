package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

import java.util.List;

/**
 * @author Leammin
 * @date 2023-02-23
 */
class CircularPermutationInBinaryRepresentationTest extends AbstractTest<CircularPermutationInBinaryRepresentation> {
    @Override
    protected Testsuite<CircularPermutationInBinaryRepresentation> testsuite() {
        return Testsuite.<CircularPermutationInBinaryRepresentation>builder()
//                .addExpected(t -> t.circularPermutation(2, 3), List.of(3,2,0,1))
                .addExpected(t -> t.circularPermutation(3, 2), List.of(2, 3, 1, 0, 4, 5, 7, 6))
                .build();
    }
}

