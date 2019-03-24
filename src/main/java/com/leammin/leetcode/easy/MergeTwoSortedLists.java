package com.leammin.leetcode.easy;

/**
 * 21. 合并两个有序链表
 *
 * <div><p>将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。&nbsp;</p>
 *
 * <p><strong>示例：</strong></p>
 *
 * <pre><strong>输入：</strong>1-&gt;2-&gt;4, 1-&gt;3-&gt;4
 * <strong>输出：</strong>1-&gt;1-&gt;2-&gt;3-&gt;4-&gt;4
 * </pre>
 * </div>
 *
 * @author Leammin
 * @date 2018-09-26
 */
public class MergeTwoSortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode res;
        if (l1.val < l2.val) {
            res = l1;
            l1 = l1.next;
        } else {
            res = l2;
            l2 = l2.next;
        }
        ListNode resNode = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                resNode.next = l1;
                l1 = l1.next;
            } else {
                resNode.next = l2;
                l2 = l2.next;
            }
            resNode = resNode.next;
        }
        while (l1 != null) {
            resNode.next = l1;
            resNode = resNode.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            resNode.next = l2;
            resNode = resNode.next;
            l2 = l2.next;
        }
        return res;
    }
}
