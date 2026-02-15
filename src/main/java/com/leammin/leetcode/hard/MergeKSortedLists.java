package com.leammin.leetcode.hard;

import com.leammin.leetcode.struct.ListNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 23. 合并K个排序链表
 * 
 * <p>合并&nbsp;<em>k&nbsp;</em>个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。</p>
 * 
 * <p><strong>示例:</strong></p>
 * 
 * <pre><strong>输入:</strong>
 * [
 * &nbsp; 1-&gt;4-&gt;5,
 * &nbsp; 1-&gt;3-&gt;4,
 * &nbsp; 2-&gt;6
 * ]
 * <strong>输出:</strong> 1-&gt;1-&gt;2-&gt;3-&gt;4-&gt;4-&gt;5-&gt;6</pre>
 * 
 * 
 * @author Leammin
 * @date 2020-04-26
 */
public interface MergeKSortedLists {
    ListNode mergeKLists(ListNode[] lists);

    static Testsuite<MergeKSortedLists> testsuite() {
        return Testsuite.<MergeKSortedLists>builder()
                .add(ExpectedTestcase.of(t -> t.mergeKLists(new ListNode[]{
                                ListNode.of(1, 4, 5),
                                ListNode.of(1, 3, 4),
                                ListNode.of(2, 6)}),
                        ListNode.of(1, 1, 2, 3, 4, 4, 5, 6)))
                .add(ExpectedTestcase.of(t -> t.mergeKLists(new ListNode[]{null}),
                        ListNode.of()))
                .build();
    }


    class Solution implements MergeKSortedLists {

        @Override
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode res = null;
            ListNode resNode = null;
            while (true) {
                boolean allNull = true;
                int min = -1;
                for (int i = 0; i < lists.length; i++) {
                    if (lists[i] != null) {
                        allNull = false;
                        if (min == -1 || lists[i].val < lists[min].val) {
                            min = i;
                        }
                    }
                }
                if (allNull) {
                    break;
                }
                if (res == null) {
                    res = new ListNode(lists[min].val);
                    resNode = res;
                } else {
                    resNode.next = new ListNode(lists[min].val);
                    resNode = resNode.next;
                }
                lists[min] = lists[min].next;
            }
            return res;
        }
    }

    class Solution2 implements MergeKSortedLists {

        @Override
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            Queue<ListNode> queue = new LinkedList<>(Arrays.asList(lists));
            while (queue.size() > 1) {
                queue.add(merge(queue.poll(), queue.poll()));
            }
            return queue.peek();
        }

        private ListNode merge(ListNode a, ListNode b) {
            if (a == null) {
                return b;
            }
            if (b == null) {
                return a;
            }
            ListNode head;
            ListNode tail;
            if (a.val < b.val) {
                tail = head = a;
                a = a.next;
            } else {
                tail = head = b;
                b = b.next;
            }

            while (a != null && b != null) {
                if (a.val < b.val) {
                    tail.next = a;
                    a = a.next;
                } else {
                    tail.next = b;
                    b = b.next;
                }
                tail = tail.next;
            }
            if (a != null) {
                tail.next = a;
            }
            if (b != null) {
                tail.next = b;
            }
            return head;
        }
    }
}

class MergeKSortedListsTest extends AbstractTest<MergeKSortedLists> {
}
