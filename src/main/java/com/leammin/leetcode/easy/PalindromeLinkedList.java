package com.leammin.leetcode.easy;

/**
 * 234. 回文链表
 *
 * <div><p>请判断一个链表是否为回文链表。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong> 1-&gt;2
 * <strong>输出:</strong> false</pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入:</strong> 1-&gt;2-&gt;2-&gt;1
 * <strong>输出:</strong> true
 * </pre>
 *
 * <p><strong>进阶：</strong><br>
 * 你能否用&nbsp;O(n) 时间复杂度和 O(1) 空间复杂度解决此题？</p>
 * </div>
 *
 * @author Leammin
 * @date 2018-10-21
 */
public class PalindromeLinkedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) { // 0
            return false;
        }
        if (head.next == null) { // 1
            return true;
        }
        if (head.next.next == null) { // 2
            return head.val == head.next.val;
        }
        if (head.next.next.next == null) { // 3
            return head.val == head.next.next.val;
        }
        ListNode mid = head;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            if (tail.next != null) {
                tail = tail.next;
                mid = mid.next;
            }
        }
        mid = mid.next;
        reverseList(mid);
        while (tail != null) {
            if (tail.val != head.val) {
                return false;
            }
            tail = tail.next;
            head = head.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = head;
        head = head.next;
        last.next = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = last;
            last = head;
            head = next;
        }
        return last;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(1);
        head.next = node;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(1);
        PalindromeLinkedList test = new PalindromeLinkedList();
        test.isPalindrome(head);
    }
}
