package com.leammin.leetcode.medium;

/**
 * 19. 删除链表的倒数第N个节点
 *
 * <div><p>给定一个链表，删除链表的倒数第&nbsp;<em>n&nbsp;</em>个节点，并且返回链表的头结点。</p>
 *
 * <p><strong>示例：</strong></p>
 *
 * <pre>给定一个链表: <strong>1-&gt;2-&gt;3-&gt;4-&gt;5</strong>, 和 <strong><em>n</em> = 2</strong>.
 *
 * 当删除了倒数第二个节点后，链表变为 <strong>1-&gt;2-&gt;3-&gt;5</strong>.
 * </pre>
 *
 * <p><strong>说明：</strong></p>
 *
 * <p>给定的 <em>n</em>&nbsp;保证是有效的。</p>
 *
 * <p><strong>进阶：</strong></p>
 *
 * <p>你能尝试使用一趟扫描实现吗？</p>
 * </div>
 *
 * @date 2018-09-02
 * @author Leammin
 */
public class RemoveNthNodeFromEndOfList {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0 || head == null) {
            return head;
        }
        
        ListNode cur = head;
        ListNode pre = head;
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }
        if (cur == null) {
            return head.next;
        }
        while (cur.next != null) {
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}
