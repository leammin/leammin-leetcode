package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-09
 */
class BaShuZiFanYiChengZiFuChuanLcofTest extends AbstractTest<BaShuZiFanYiChengZiFuChuanLcof> {
    @Override
    protected Testsuite<BaShuZiFanYiChengZiFuChuanLcof> testsuite() {
        return Testsuite.<BaShuZiFanYiChengZiFuChuanLcof>builder()
                .add(ExpectedTestcase.of(t -> t.translateNum(12258), 5))
                .add(ExpectedTestcase.of(t -> t.translateNum(542), 1))
                .add(ExpectedTestcase.of(t -> t.translateNum(506), 1))
                .build();
    }
}