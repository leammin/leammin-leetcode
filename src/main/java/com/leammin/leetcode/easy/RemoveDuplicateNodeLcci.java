package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.ListNode;
import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 面试题 02.01. 移除重复节点
 * 
 * <p>编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。</p>
 * 
 * <p> <strong>示例1:</strong></p>
 * 
 * <pre>
 * <strong> 输入</strong>：[1, 2, 3, 3, 2, 1]
 * <strong> 输出</strong>：[1, 2, 3]
 * </pre>
 * 
 * <p> <strong>示例2:</strong></p>
 * 
 * <pre>
 * <strong> 输入</strong>：[1, 1, 1, 1, 2]
 * <strong> 输出</strong>：[1, 2]
 * </pre>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ol>
 * <li>链表长度在[0, 20000]范围内。</li>
 * <li>链表元素在[0, 20000]范围内。</li>
 * </ol>
 * 
 * <p> <strong>进阶：</strong></p>
 * 
 * <p>如果不得使用临时缓冲区，该怎么解决？</p>
 * 
 * 
 * @author Leammin
 * @date 2020-06-26
 */
public interface RemoveDuplicateNodeLcci {
    ListNode removeDuplicateNodes(ListNode head);

    static Testsuite<RemoveDuplicateNodeLcci> testsuite() {
        return Testsuite.<RemoveDuplicateNodeLcci>builder()
                .add(ExpectedTestcase.of(t -> t.removeDuplicateNodes(ListNode.of(1, 2, 3, 3, 2, 1)), ListNode.of(1, 2, 3)))
                .add(ExpectedTestcase.of(t -> t.removeDuplicateNodes(ListNode.of(1, 1, 1, 1, 2)), ListNode.of(1, 2)))
                .build();
    }


    class Solution implements RemoveDuplicateNodeLcci {

        @Override
        public ListNode removeDuplicateNodes(ListNode head) {
            if (head == null) {
                return null;
            }
            boolean[] contains = new boolean[20001];
            contains[head.val] = true;
            ListNode node = head;
            while (node.next != null) {
                if (contains[node.next.val]) {
                    node.next = node.next.next;
                } else {
                    contains[node.next.val] = true;
                    node = node.next;
                }
            }
            return head;
        }
    }

    class Solution2 implements RemoveDuplicateNodeLcci {

        @Override
        public ListNode removeDuplicateNodes(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode last = head;
            ListNode node = head.next;
            while (node != null) {
                ListNode n = head;
                while (n != node) {
                    if (node.val == n.val) {
                        last.next = node.next;
                        node = node.next;
                        break;
                    }
                    n = n.next;
                }
                if (n == node) {
                    last = node;
                    node = node.next;
                }
            }
            return head;
        }
    }
}

class RemoveDuplicateNodeLcciTest extends AbstractTest<RemoveDuplicateNodeLcci> {
}
