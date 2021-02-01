package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.ListNode;

/**
 * 148. 排序链表
 * 
 * <p>在&nbsp;<em>O</em>(<em>n</em>&nbsp;log&nbsp;<em>n</em>) 时间复杂度和常数级空间复杂度下，对链表进行排序。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre><strong>输入:</strong> 4-&gt;2-&gt;1-&gt;3
 * <strong>输出:</strong> 1-&gt;2-&gt;3-&gt;4
 * </pre>
 * 
 * <p><strong>示例 2:</strong></p>
 * 
 * <pre><strong>输入:</strong> -1-&gt;5-&gt;3-&gt;4-&gt;0
 * <strong>输出:</strong> -1-&gt;0-&gt;3-&gt;4-&gt;5</pre>
 * 
 * 
 * @author Leammin
 * @date 2021-01-10
 */
public interface SortList {
    ListNode sortList(ListNode head);

    class Solution implements SortList {

        @Override
        public ListNode sortList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode s = sort(head);
            head = s.next;
            s.next = null;
            return head;
        }

        private ListNode sort(ListNode head) {
            if (head.next == null) {
                head.next = head;
                return head;
            }
            ListNode h = new ListNode(0);
            ListNode t = h;
            ListNode i = head;
            while (i.next != null) {
                if (i.next.val < head.val) {
                    t.next = i.next;
                    t = t.next;
                    i.next = i.next.next;
                    t.next = null;
                } else {
                    i = i.next;
                }
            }

            ListNode result = head;
            if (head.next != null) {
                result = sort(head.next);
                head.next = result.next;
                result.next = head;
            }
            if (h.next != null) {
                ListNode leftTail = sort(h.next);
                result.next = leftTail.next;
                leftTail.next = head;
            }
            return result;
        }
    }

    class Solution2 implements SortList {

        @Override
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode[] bucket = new ListNode[200001];
            while (head != null) {
                ListNode next = head.next;
                int index = head.val + 100000;
                head.next = bucket[index];
                bucket[index] = head;
                head = next;
            }
            ListNode h = new ListNode(0);
            ListNode t = h;
            for (ListNode node : bucket) {
                t.next = node;
                while (t.next != null) {
                    t = t.next;
                }
            }
            return h.next;
        }
    }

    class Solution3 implements SortList {

        @Override
        public ListNode sortList(ListNode head) {
            int length = getLength(head);
            int sublen = 1;
            while (sublen < length) {
                ListNode rh = null;
                ListNode rt = null;
                while (head != null) {
                    ListNode a = head;
                    ListNode at = nextOrTail(a, sublen - 1);
                    ListNode b = at.next;
                    ListNode bt = nextOrTail(b, sublen - 1);
                    head = null;
                    at.next = null;
                    if (bt != null) {
                        head = bt.next;
                        bt.next = null;
                    }

                    ListNode mergeTail = merge(a, b);
                    ListNode mergeHead = mergeTail.next;
                    mergeTail.next = null;
                    if (rh == null) {
                        rh = mergeHead;
                        rt = mergeTail;
                    } else {
                        rt.next = mergeHead;
                        rt = mergeTail;
                    }
                }
                head = rh;
                sublen *= 2;
            }
            return head;
        }

        private ListNode merge(ListNode a, ListNode b) {
            ListNode head = new ListNode(0);
            ListNode tail = head;
            while (a != null && b != null) {
                if (a.val <= b.val) {
                    tail.next = a;
                    a = a.next;
                } else {
                    tail.next = b;
                    b = b.next;
                }
                tail = tail.next;
                tail.next = null;
            }
            tail.next = a;
            while (a != null) {
                tail = a;
                a = a.next;
            }
            tail.next = b;
            while (b != null) {
                tail = b;
                b = b.next;
            }

            tail.next = head.next;
            head.next = null;
            return tail;
        }

        private int getLength(ListNode head) {
            int length = 0;
            for (ListNode tmp = head; tmp != null; tmp = tmp.next) {
                length++;
            }
            return length;
        }

        public ListNode nextOrTail(ListNode node, int times) {
            if (node == null) {
                return null;
            }
            for (int i = 0; i < times && node.next != null; i++) {
                node = node.next;
            }
            return node;
        }
    }
}
