package com.leammin.leetcode.hard;

import com.leammin.leetcode.struct.ListNode;
import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 25. K 个一组翻转链表
 * 
 * <p>给你一个链表，每&nbsp;<em>k&nbsp;</em>个节点一组进行翻转，请你返回翻转后的链表。</p>
 * 
 * <p><em>k&nbsp;</em>是一个正整数，它的值小于或等于链表的长度。</p>
 * 
 * <p>如果节点总数不是&nbsp;<em>k&nbsp;</em>的整数倍，那么请将最后剩余的节点保持原有顺序。</p>
 * 
 * <p><strong>示例 :</strong></p>
 * 
 * <p>给定这个链表：<code>1-&gt;2-&gt;3-&gt;4-&gt;5</code></p>
 * 
 * <p>当&nbsp;<em>k&nbsp;</em>= 2 时，应当返回: <code>2-&gt;1-&gt;4-&gt;3-&gt;5</code></p>
 * 
 * <p>当&nbsp;<em>k&nbsp;</em>= 3 时，应当返回: <code>3-&gt;2-&gt;1-&gt;4-&gt;5</code></p>
 * 
 * <p><strong>说明 :</strong></p>
 * 
 * <ul>
 * 	<li>你的算法只能使用常数的额外空间。</li>
 * 	<li><strong>你不能只是单纯的改变节点内部的值</strong>，而是需要实际的进行节点交换。</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2020-05-20
 */
public interface ReverseNodesInKGroup {
    ListNode reverseKGroup(ListNode head, int k);

    static Testsuite<ReverseNodesInKGroup> testsuite() {
        return Testsuite.<ReverseNodesInKGroup>builder()
                .add(ExpectedTestcase.of(t -> t.reverseKGroup(ListNode.of(1, 2, 3, 4, 5), 2), ListNode.of(2, 1, 4, 3, 5)))
                .add(ExpectedTestcase.of(t -> t.reverseKGroup(ListNode.of(1, 2, 3, 4, 5), 3), ListNode.of(3, 2, 1, 4, 5)))
                .add(ExpectedTestcase.of(t -> t.reverseKGroup(ListNode.of(1, 2, 3, 4, 5), 5), ListNode.of(5, 4, 3, 2, 1)))
                .add(ExpectedTestcase.of(t -> t.reverseKGroup(ListNode.of(1, 2, 3, 4, 5), 0), ListNode.of(1, 2, 3, 4, 5)))
                .build();
    }


    class Solution implements ReverseNodesInKGroup {
        ListNode empty = new ListNode(0);

        @Override
        public ListNode reverseKGroup(ListNode head, int k) {
            if (k == 0 || head == null) {
                return head;
            }
            ListNode result = new ListNode(0);
            ListNode resultTail = result;
            ListNode list = head;
            ListNode nextList;
            while ((nextList = split(list, k)) != empty) {
                resultTail.next = reverse(list);
                resultTail = list;
                list = nextList;
            }
            resultTail.next = list;
            return result.next;
        }

        private ListNode split(ListNode head, int k) {
            ListNode last = null;
            ListNode node = head;
            while (--k >= 0 && node != null) {
                last = node;
                node = node.next;
            }
            if (k >= 0) {
                return empty;
            }
            if (last != null) {
                last.next = null;
            }
            return node;
        }

        private ListNode reverse(ListNode head) {
            ListNode l = null, r = head;
            while (r != null) {
                ListNode next = r.next;
                r.next = l;
                l = r;
                r = next;
            }
            return l;
        }

    }
}

class ReverseNodesInKGroupTest extends AbstractTest<ReverseNodesInKGroup> {
}
