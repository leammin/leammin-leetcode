package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.ListNode;
import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 328. 奇偶链表
 * 
 * <p>给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。</p>
 * 
 * <p>请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre><strong>输入:</strong> 1-&gt;2-&gt;3-&gt;4-&gt;5-&gt;NULL
 * <strong>输出:</strong> 1-&gt;3-&gt;5-&gt;2-&gt;4-&gt;NULL
 * </pre>
 * 
 * <p><strong>示例 2:</strong></p>
 * 
 * <pre><strong>输入:</strong> 2-&gt;1-&gt;3-&gt;5-&gt;6-&gt;4-&gt;7-&gt;NULL 
 * <strong>输出:</strong> 2-&gt;3-&gt;6-&gt;7-&gt;1-&gt;5-&gt;4-&gt;NULL</pre>
 * 
 * <p><strong>说明:</strong></p>
 * 
 * <ul>
 * 	<li>应当保持奇数节点和偶数节点的相对顺序。</li>
 * 	<li>链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2020-03-09
 */
public interface OddEvenLinkedList {
    ListNode oddEvenList(ListNode head);

    static Testsuite<OddEvenLinkedList> testsuite() {
        return Testsuite.<OddEvenLinkedList>builder()
                .add(ExpectedTestcase.of(t -> t.oddEvenList(ListNode.of(1, 2, 3, 4, 5, 6, 7)), ListNode.of(1, 3, 5, 7, 2, 4, 6)))
                .add(ExpectedTestcase.of(t -> t.oddEvenList(ListNode.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)), ListNode.of(1, 3, 5, 7, 9, 2, 4, 6, 8, 10)))
                .build();
    }


    class Solution implements OddEvenLinkedList {
        @Override
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode odd = head;
            ListNode even = head.next;
            ListNode evenHead = head.next;
            ListNode node = head.next.next;
            int i = 3;
            while (node != null) {
                if ((i++ & 1) > 0) {
                    odd.next = node;
                    odd = node;
                } else {
                    even.next = node;
                    even = node;
                }
                node = node.next;
                odd.next = null;
                even.next = null;
            }
            odd.next = evenHead;
            return head;
        }
    }
}

class OddEvenLinkedListTest extends AbstractTest<OddEvenLinkedList> {
}
