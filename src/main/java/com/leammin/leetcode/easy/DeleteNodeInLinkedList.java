package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.ListNode;

/**
 * 237. 删除链表中的节点
 *
 * <div><p>请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。</p>
 *
 * <p>现有一个链表 --&nbsp;head =&nbsp;[4,5,1,9]，它可以表示为:</p>
 *
 * <pre>    4 -&gt; 5 -&gt; 1 -&gt; 9
 * </pre>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong> head = [4,5,1,9], node = 5
 * <strong>输出:</strong> [4,1,9]
 * <strong>解释: </strong>给定你链表中值为&nbsp;<span style="">5</span>&nbsp;的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -&gt; 1 -&gt; 9.
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入:</strong> head = [4,5,1,9], node = 1
 * <strong>输出:</strong> [4,5,9]
 * <strong>解释: </strong>给定你链表中值为&nbsp;1&nbsp;的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -&gt; 5 -&gt; 9.
 * </pre>
 *
 * <p><strong>说明:</strong></p>
 *
 * <ul>
 * <li>链表至少包含两个节点。</li>
 * <li>链表中所有节点的值都是唯一的。</li>
 * <li>给定的节点为非末尾节点并且一定是链表中的一个有效节点。</li>
 * <li>不要从你的函数中返回任何结果。</li>
 * </ul>
 * </div>
 *
 * @author Leammin
 * @date 2018-08-26
 */
public interface DeleteNodeInLinkedList {
    void deleteNode(ListNode node);

    class Solution implements DeleteNodeInLinkedList {
        @Override
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }


}
