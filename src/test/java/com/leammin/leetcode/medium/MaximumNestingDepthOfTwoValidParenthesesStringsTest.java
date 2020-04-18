package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-04-01
 */
class MaximumNestingDepthOfTwoValidParenthesesStringsTest extends AbstractTest<MaximumNestingDepthOfTwoValidParenthesesStrings> {
    @Override
    protected Testsuite<MaximumNestingDepthOfTwoValidParenthesesStrings> testsuite() {
        return Testsuite.<MaximumNestingDepthOfTwoValidParenthesesStrings>builder()
                .add(ExpectedTestcase.of(t->t.maxDepthAfterSplit("(()())"), new int[]{0,1,1,1,1,0}))
                .add(ExpectedTestcase.of(t->t.maxDepthAfterSplit("()(())()"), new int[]{0,0,0,1,1,0,0,0}))
                .build();
    }
}