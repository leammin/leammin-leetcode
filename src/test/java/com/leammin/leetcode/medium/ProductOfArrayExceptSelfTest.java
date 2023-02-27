package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-04
 */
class ProductOfArrayExceptSelfTest extends AbstractTest<ProductOfArrayExceptSelf> {
    @Override
    protected Testsuite<ProductOfArrayExceptSelf> testsuite() {
        return Testsuite.<ProductOfArrayExceptSelf>builder()
                .add(ExpectedTestcase.of(t -> t.productExceptSelf(new int[]{1, 2, 3, 4}), new int[]{24, 12, 8, 6}))
                .build();
    }
}