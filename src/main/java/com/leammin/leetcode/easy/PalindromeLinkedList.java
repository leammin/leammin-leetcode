package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.ListNode;

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
public interface PalindromeLinkedList {
    boolean isPalindrome(ListNode head);

    class Solution implements PalindromeLinkedList {
        @Override
        public boolean isPalindrome(ListNode head) {
            // 0
            if (head == null) {
                return false;
            }
            // 1
            if (head.next == null) {
                return true;
            }
            // 2
            if (head.next.next == null) {
                return head.val == head.next.val;
            }
            // 3
            if (head.next.next.next == null) {
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

        private ListNode reverseList(ListNode head) {
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
    }

}
