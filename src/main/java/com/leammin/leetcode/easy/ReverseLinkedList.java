package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.ListNode;

/**
 * 206. 反转链表
 *
 * <p>反转一个单链表。</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong>输入:</strong> 1-&gt;2-&gt;3-&gt;4-&gt;5-&gt;NULL
 * <strong>输出:</strong> 5-&gt;4-&gt;3-&gt;2-&gt;1-&gt;NULL</pre>
 *
 * <p><strong>进阶:</strong><br>
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？</p>
 *
 * @author Leammin
 * @date 2019-08-20
 */
public interface ReverseLinkedList {
    ListNode reverseList(ListNode head);

    /**
     * 迭代
     */
    class Solution implements ReverseLinkedList {
        @Override
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
    }

    /**
     * 递归
     */
    class Solution2 implements ReverseLinkedList {
        @Override
        public ListNode reverseList(ListNode head) {
            return reverse(head, null);
        }

        public ListNode reverse(ListNode current, ListNode last) {
            if (current == null) {
                return last;
            }
            ListNode next = current.next;
            current.next = last;
            return reverse(next, current);
        }
    }
}
