package com.leammin.leetcode.util;

import com.leammin.leetcode.struct.ListNode;

public class ListNodeUtils {
    private ListNodeUtils() {
    }

    public static ListNode tail(ListNode head) {
        if (head == null) {
            return null;
        }
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }
}
