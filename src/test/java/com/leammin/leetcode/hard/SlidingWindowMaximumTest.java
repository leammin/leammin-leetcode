package com.leammin.leetcode.hard;

import com.leammin.leetcode.undone.hard.SlidingWindowMaximum;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-02-04
 */
class SlidingWindowMaximumTest extends AbstractTest<SlidingWindowMaximum> {
    @Override
    protected Testsuite<SlidingWindowMaximum> testsuite() {
        return Testsuite.<SlidingWindowMaximum>builder()
                .add(ExpectedTestcase.of(t -> t.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3), new int[]{3, 3, 5, 5, 6, 7}))
                .build();
    }
}