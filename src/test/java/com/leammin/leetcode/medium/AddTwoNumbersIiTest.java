package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.ListNode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-04-14
 */
class AddTwoNumbersIiTest extends AbstractTest<AddTwoNumbersIi> {
    @Override
    protected Testsuite<AddTwoNumbersIi> testsuite() {
        return Testsuite.<AddTwoNumbersIi>builder()
                .add(ExpectedTestcase.of(t->t.addTwoNumbers(ListNode.of(7,2,4,3), ListNode.of(5,6,4)), ListNode.of(7,8,0,7)))
                .add(ExpectedTestcase.of(t->t.addTwoNumbers(ListNode.of(1,9,9,9), ListNode.of(1)), ListNode.of(2,0,0,0)))
                .add(ExpectedTestcase.of(t->t.addTwoNumbers(ListNode.of(9,9,9,9), ListNode.of(1)), ListNode.of(1,0,0,0,0)))
                .add(ExpectedTestcase.of(t->t.addTwoNumbers(ListNode.of(0), ListNode.of(0)), ListNode.of(0)))
                .add(ExpectedTestcase.of(t->t.addTwoNumbers(ListNode.of(1,0), ListNode.of(0)), ListNode.of(1,0)))
                .build();
    }
}