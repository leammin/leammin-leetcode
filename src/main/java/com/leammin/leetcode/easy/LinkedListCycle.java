package com.leammin.leetcode.easy;

/**
 * 141. 环形链表
 *
 * <div><p>给定一个链表，判断链表中是否有环。</p>
 *
 * <p><strong>进阶：</strong><br>
 * 你能否不使用额外空间解决此题？</p>
 * </div>
 *
 * @author Leammin
 * @date 2018-10-21
 */
public class LinkedListCycle {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode tail = head;
        ListNode mid = head;
        while (tail !=null && tail.next != null) {
            tail = tail.next.next;
            mid = mid.next;
            if (tail == mid) {
                return true;
            }
        }
        return false;
    }
}
