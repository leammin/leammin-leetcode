package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-16
 */
class DesignLinkedListTest extends AbstractTest<DesignLinkedList> {
    @Override
    protected Testsuite<DesignLinkedList> testsuite() {
        return Testsuite.<DesignLinkedList>builder()
                .add(Testcase.of(t -> {
                    long before = System.nanoTime();
                    t.addAtHead(1);
                    t.addAtTail(3);
                    t.addAtIndex(1, 2);
                    assert t.get(1) == 2;
                    t.deleteAtIndex(1);
                    assert t.get(1) == 3;
                    return System.nanoTime() - before;
                }))
                .build();
    }
}