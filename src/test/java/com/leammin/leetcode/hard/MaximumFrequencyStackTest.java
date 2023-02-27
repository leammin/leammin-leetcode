package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

import java.util.stream.IntStream;

/**
 * @author Leammin
 * @date 2021-02-25
 */
class MaximumFrequencyStackTest extends AbstractTest<MaximumFrequencyStack> {
    @Override
    protected Testsuite<MaximumFrequencyStack> testsuite() {
        return Testsuite.<MaximumFrequencyStack>builder()
                .add(ExpectedTestcase.of(t -> {
                    t.push(5);
                    t.push(7);
                    t.push(5);
                    t.push(7);
                    t.push(4);
                    t.push(5);
                    return IntStream.range(0, 4).map(i -> t.pop())
                            .toArray();
                }, new int[]{5, 7, 5, 4}))
                .build();
    }
}