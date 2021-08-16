package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 * 
 * <p>给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。</p>
 * 
 * <p><strong>示例&nbsp;1:</strong></p>
 * 
 * <pre><strong>输入:</strong> 1-&gt;1-&gt;2
 * <strong>输出:</strong> 1-&gt;2
 * </pre>
 * 
 * <p><strong>示例&nbsp;2:</strong></p>
 * 
 * <pre><strong>输入:</strong> 1-&gt;1-&gt;2-&gt;3-&gt;3
 * <strong>输出:</strong> 1-&gt;2-&gt;3</pre>
 * 
 * 
 * @author Leammin
 * @date 2021-08-10
 */
public interface RemoveDuplicatesFromSortedList {
    ListNode deleteDuplicates(ListNode head);

    class Solution implements RemoveDuplicatesFromSortedList {

        @Override
        public ListNode deleteDuplicates(ListNode head) {
            ListNode node = head;
            while (node != null && node.next != null) {
                if (node.val == node.next.val) {
                    node.next = node.next.next;
                } else {
                    node = node.next;
                }
            }
            return head;
        }
    }
}
