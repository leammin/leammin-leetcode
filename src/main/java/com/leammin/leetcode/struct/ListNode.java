package com.leammin.leetcode.struct;

import java.util.Objects;

/**
 * @author Leammin
 * @date 2019-04-05
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val &&
                Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }

    public static ListNode of(int... vals) {
        if (vals == null || vals.length == 0) {
            return null;
        }
        ListNode head = new ListNode(vals[0]);
        for (int i = 1; i < vals.length; i++) {
            head.next = new ListNode(vals[i]);
        }
        return head;
    }
}
