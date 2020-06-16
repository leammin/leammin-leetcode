package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.ListNode;

/**
 * 203. 移除链表元素
 * 
 * <p>删除链表中等于给定值&nbsp;<strong><em>val&nbsp;</em></strong>的所有节点。</p>
 * 
 * <p><strong>示例:</strong></p>
 * 
 * <pre><strong>输入:</strong> 1-&gt;2-&gt;6-&gt;3-&gt;4-&gt;5-&gt;6, <em><strong>val</strong></em> = 6
 * <strong>输出:</strong> 1-&gt;2-&gt;3-&gt;4-&gt;5
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2020-06-16
 */
public interface RemoveLinkedListElements {
    ListNode removeElements(ListNode head, int val);

    class Solution implements RemoveLinkedListElements {

        @Override
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) {
                return null;
            }
            ListNode last = head;
            ListNode node = head.next;
            while (node != null) {
                if (node.val == val) {
                    last.next = node.next;
                } else {
                    last = node;
                }
                node = node.next;
            }
            if (head.val == val) {
                head = head.next;
            }
            return head;
        }
    }
}
