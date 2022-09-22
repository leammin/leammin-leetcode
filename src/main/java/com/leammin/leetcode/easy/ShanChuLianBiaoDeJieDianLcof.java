package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.ListNode;

/**
 * 面试题18. 删除链表的节点
 * 
 * <p>给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。</p>
 * 
 * <p>返回删除后的链表的头节点。</p>
 * 
 * <p><strong>注意：</strong>此题对比原题有改动</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre><strong>输入:</strong> head = [4,5,1,9], val = 5
 * <strong>输出:</strong> [4,1,9]
 * <strong>解释: </strong>给定你链表中值为&nbsp;5&nbsp;的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -&gt; 1 -&gt; 9.
 * </pre>
 * 
 * <p><strong>示例 2:</strong></p>
 * 
 * <pre><strong>输入:</strong> head = [4,5,1,9], val = 1
 * <strong>输出:</strong> [4,5,9]
 * <strong>解释: </strong>给定你链表中值为&nbsp;1&nbsp;的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -&gt; 5 -&gt; 9.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>说明：</strong></p>
 * 
 * <ul>
 * 	<li>题目保证链表中节点的值互不相同</li>
 * 	<li>若使用 C 或 C++ 语言，你不需要 <code>free</code> 或 <code>delete</code> 被删除的节点</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2021-09-08
 */
public interface ShanChuLianBiaoDeJieDianLcof {
    ListNode deleteNode(ListNode head, int val);

    class Solution implements ShanChuLianBiaoDeJieDianLcof {

        @Override
        public ListNode deleteNode(ListNode head, int val) {
            if (head == null) {
                return null;
            }
            if (head.val == val) {
                return head.next;
            }
            ListNode last = head;
            ListNode cur = head.next;
            while (cur != null) {
                if (cur.val == val) {
                    last.next = cur.next;
                    break;
                }
                last = cur;
                cur = cur.next;
            }
            return head;
        }
    }
}
