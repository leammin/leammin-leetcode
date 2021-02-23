package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-02-24
 */
class FlippingAnImageTest extends AbstractTest<FlippingAnImage> {
    @Override
    protected Testsuite<FlippingAnImage> testsuite() {
        return Testsuite.<FlippingAnImage>builder()
                .add(ExpectedTestcase.of(t -> t.flipAndInvertImage(new int[][]{{1,1,0},{1,0,1},{0,0,0}}),
                        new int[][]{{1,0,0},{0,1,0},{1,1,1}}))
                .build();
    }
}