package com.leammin.leetcode.easy;

import com.leammin.leetcode.undone.easy.PartitionArrayIntoThreePartsWithEqualSum;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-11
 */
class PartitionArrayIntoThreePartsWithEqualSumTest extends AbstractTest<PartitionArrayIntoThreePartsWithEqualSum> {
    @Override
    protected Testsuite<PartitionArrayIntoThreePartsWithEqualSum> testsuite() {
        return Testsuite.<PartitionArrayIntoThreePartsWithEqualSum>builder()
                .add(ExpectedTestcase.of(true, t -> t.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1})))
                .add(ExpectedTestcase.of(true, t -> t.canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4})))
                .add(ExpectedTestcase.of(false, t -> t.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1})))
                .build();
    }
}