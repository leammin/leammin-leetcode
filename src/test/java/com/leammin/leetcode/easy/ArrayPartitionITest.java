package com.leammin.leetcode.easy;

import com.leammin.leetcode.undone.easy.ArrayPartitionI;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-13
 */
class ArrayPartitionITest extends AbstractTest<ArrayPartitionI> {
    @Override
    protected Testsuite<ArrayPartitionI> testsuite() {
        return Testsuite.<ArrayPartitionI>builder()
                .add(ExpectedTestcase.of(t -> t.arrayPairSum(new int[]{1,4,3,2}), 4))
                .build();
    }
}