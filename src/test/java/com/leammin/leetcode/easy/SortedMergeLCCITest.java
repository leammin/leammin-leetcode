package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

public class SortedMergeLCCITest extends AbstractTest<SortedMergeLCCI> {
    @Override
    protected Testsuite<SortedMergeLCCI> testsuite() {
        return Testsuite.<SortedMergeLCCI>builder()
                .add(ExpectedTestcase.of(s -> {
                    int[] a = {1, 2, 3, 0, 0, 0};
                    s.merge(a, 3, new int[]{2, 5, 6}, 3);
                    return a;
                }, new int[]{1, 2, 2, 3, 5, 6})).add(ExpectedTestcase.of(s -> {
                    int[] a = {0};
                    s.merge(a, 0, new int[]{1}, 1);
                    return a;
                }, new int[]{1}))
                .build();
    }
}
