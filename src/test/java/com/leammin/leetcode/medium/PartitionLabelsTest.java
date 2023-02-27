package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

import java.util.Arrays;

/**
 * @author Leammin
 * @date 2019-08-31
 */
class PartitionLabelsTest extends AbstractTest<PartitionLabels> {
    @Override
    protected Testsuite<PartitionLabels> testsuite() {
        return Testsuite.<PartitionLabels>builder()
                .add(ExpectedTestcase.of(t->t.partitionLabels("ababcbacadefegdehijhklij"), Arrays.asList(9,7,8)))
                .build();
    }
}