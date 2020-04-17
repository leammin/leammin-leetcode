package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 445. 两数相加 II
 * 
 * <p>给定两个<strong>非空</strong>链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p>你可以假设除了数字 0 之外，这两个数字都不会以零开头。</p>
 * 
 * <p><strong>进阶:</strong></p>
 * 
 * <p>如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。</p>
 * 
 * <p><strong>示例:</strong></p>
 * 
 * <pre>
 * <strong>输入:</strong> (7 -&gt; 2 -&gt; 4 -&gt; 3) + (5 -&gt; 6 -&gt; 4)
 * <strong>输出:</strong> 7 -&gt; 8 -&gt; 0 -&gt; 7
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2020-04-14
 */
public interface AddTwoNumbersIi {
    ListNode addTwoNumbers(ListNode l1, ListNode l2);

    class Solution implements AddTwoNumbersIi {

        @Override
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int s1 = size(l1);
            int s2 = size(l2);
            ListNode longList = s1 > s2 ? l1 : l2;
            ListNode shortList = s1 > s2 ? l2 : l1;
            int longSize = Math.max(s1, s2);
            int shortSize = Math.min(s1, s2);

            ListNode ans;
            ListNode tail;
            List<ListNode> array = new ArrayList<>(longSize + 1);
            if (longSize > shortSize) {
                ans = tail = new ListNode(longList.val);
                array.add(tail);
                longList = longList.next;
                for (int i = 0; i < longSize - shortSize - 1; i++) {
                    tail.next = new ListNode(longList.val);
                    tail = tail.next;
                    array.add(tail);
                    longList = longList.next;
                }
            } else {
                int val = longList.val + shortList.val;
                longList = longList.next;
                shortList = shortList.next;
                if (val >= 10) {
                    ans = new ListNode(1);
                    ans.next = tail = new ListNode(val - 10);
                    array.add(ans);
                    array.add(tail);
                } else {
                    ans = tail = new ListNode(val);
                    array.add(ans);
                }
            }

            while (longList != null) {
                int val = longList.val + shortList.val;
                longList = longList.next;
                shortList = shortList.next;
                if (val >= 10) {
                    for (int i = array.size() - 1; i >= -1; i--) {
                        if (i == -1) {
                            ListNode t = new ListNode(1);
                            t.next = ans;
                            ans = t;
                        } else {
                            ListNode node = array.get(i);
                            if (node.val == 9) {
                                node.val = 0;
                            } else {
                                node.val++;
                                break;
                            }
                        }
                    }
                    tail.next = new ListNode(val - 10);
                } else {
                    tail.next = new ListNode(val);
                }
                tail = tail.next;
                array.add(tail);
            }
            return ans;
        }

        private int size(ListNode node) {
            int res = 0;
            while (node != null) {
                res++;
                node = node.next;
            }
            return res;
        }
    }
}
