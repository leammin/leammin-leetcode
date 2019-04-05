package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.ListNode;

/**
 * 2. 两数相加
 *
 * <div><p>给出两个&nbsp;<strong>非空</strong> 的链表用来表示两个非负的整数。其中，它们各自的位数是按照&nbsp;<strong>逆序</strong>&nbsp;的方式存储的，并且它们的每个节点只能存储&nbsp;<strong>一位</strong>&nbsp;数字。</p>
 *
 * <p>如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。</p>
 *
 * <p>您可以假设除了数字 0 之外，这两个数都不会以 0&nbsp;开头。</p>
 *
 * <p><strong>示例：</strong></p>
 *
 * <pre><strong>输入：</strong>(2 -&gt; 4 -&gt; 3) + (5 -&gt; 6 -&gt; 4)
 * <strong>输出：</strong>7 -&gt; 0 -&gt; 8
 * <strong>原因：</strong>342 + 465 = 807
 * </pre>
 * </div>
 *
 * @author Leammin
 * @date 2018-10-21
 */
public interface AddTwoNumbers {
    ListNode addTwoNumbers(ListNode l1, ListNode l2);

    class Solution implements AddTwoNumbers {
        @Override
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            boolean addOne = false;
            ListNode sum = null;
            ListNode tail = null;
            while (l1 != null && l2 != null) {
                int plus = l1.val + l2.val;
                if (addOne) {
                    plus++;
                    addOne = false;
                }
                if (plus > 9) {
                    addOne = true;
                }
                int modulo = plus % 10;
                if (sum == null) {
                    sum = new ListNode(modulo);
                    tail = sum;
                } else {
                    tail.next = new ListNode(modulo);
                    tail = tail.next;
                }
                l1 = l1.next;
                l2 = l2.next;
            }
            while (l1 != null) {
                int val = l1.val;
                if (addOne) {
                    val++;
                    addOne = false;
                }
                if (val > 9) {
                    addOne = true;
                }
                int modulo = val % 10;
                tail.next = new ListNode(modulo);
                tail = tail.next;
                l1 = l1.next;
            }
            while (l2 != null) {
                int val = l2.val;
                if (addOne) {
                    val++;
                    addOne = false;
                }
                if (val > 9) {
                    addOne = true;
                }
                int modulo = val % 10;
                tail.next = new ListNode(modulo);
                tail = tail.next;
                l2 = l2.next;
            }
            if (addOne) {
                tail.next = new ListNode(1);
            }
            return sum;
        }
    }
}
