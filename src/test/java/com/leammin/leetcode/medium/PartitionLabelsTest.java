package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

import java.util.Arrays;

/**
 * @author Leammin
 * @date 2019-08-31
 */
class PartitionLabelsTest extends AbstractTest<PartitionLabels> {
    @Override
    protected Testsuite<PartitionLabels> testsuite() {
        return Testsuite.<PartitionLabels>builder()
                .add(ExpectedTestcase.of(Arrays.asList(9,7,8), t->t.partitionLabels("ababcbacadefegdehijhklij")))
                .build();
    }
}