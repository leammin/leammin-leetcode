package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.ListNode;
import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 24. 两两交换链表中的节点
 * 
 * <p>给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。</p>
 * 
 * <p><strong>你不能只是单纯的改变节点内部的值</strong>，而是需要实际的进行节点交换。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例:</strong></p>
 * 
 * <pre>给定 <code>1-&gt;2-&gt;3-&gt;4</code>, 你应该返回 <code>2-&gt;1-&gt;4-&gt;3</code>.
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2021-04-03
 */
public interface SwapNodesInPairs {
    ListNode swapPairs(ListNode head);

    static Testsuite<SwapNodesInPairs> testsuite() {
        return Testsuite.<SwapNodesInPairs>builder()
                .addExpected(t -> t.swapPairs(ListNode.of(1, 2, 3, 4)), ListNode.of(2, 1, 4, 3))
                .build();
    }


    class Solution implements SwapNodesInPairs {

        @Override
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode newHead = head.next;
            head.next = newHead.next;
            newHead.next = head;
            ListNode node = head;
            while (node.next != null && node.next.next != null) {
                ListNode a = node.next;
                ListNode b = a.next;
                ListNode c = b.next;
                node.next = b;
                b.next = a;
                a.next = c;
                node = a;
            }
            return newHead;
        }
    }
}

class SwapNodesInPairsTest extends AbstractTest<SwapNodesInPairs> {
}
