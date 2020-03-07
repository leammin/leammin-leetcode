package com.leammin.leetcode.easy;

import com.google.common.primitives.Ints;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;
import com.leammin.leetcode.util.VerifiableTestcase;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Leammin
 * @date 2020-03-07
 */
class HeWeiSdeLianXuZhengShuXuLieLcofTest extends AbstractTest<HeWeiSdeLianXuZhengShuXuLieLcof> {
    @Override
    protected Testsuite<HeWeiSdeLianXuZhengShuXuLieLcof> testsuite() {
        return Testsuite.<HeWeiSdeLianXuZhengShuXuLieLcof>builder()
                .add(VerifiableTestcase.of(output -> {
                    List<List<Integer>> expected = List.of(
                            List.of(2, 3, 4),
                            List.of(4, 5)
                    );
                    List<List<Integer>> outputSet = Arrays.stream(output)
                            .map(Ints::asList)
                            .collect(Collectors.toList());
                    return expected.equals(outputSet);
                }, t -> t.findContinuousSequence(9)))
                .add(VerifiableTestcase.of(output -> {
                    List<List<Integer>> expected = List.of(
                            List.of(1, 2, 3, 4, 5),
                            List.of(4, 5, 6),
                            List.of(7, 8)
                    );
                    List<List<Integer>> outputSet = Arrays.stream(output)
                            .map(Ints::asList)
                            .collect(Collectors.toList());
                    return expected.equals(outputSet);
                }, t -> t.findContinuousSequence(15)))
                .build();
    }
}