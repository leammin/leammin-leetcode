package com.leammin.leetcode.undone.easy;

import com.leammin.leetcode.struct.ListNode;

/**
 * 面试题06. 从尾到头打印链表
 * 
 * <p>输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输入：</strong>head = [1,3,2]
 * <strong>输出：</strong>[2,3,1]</pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>限制：</strong></p>
 * 
 * <p><code>0 &lt;= 链表长度 &lt;= 10000</code></p>
 * 
 * 
 * @author Leammin
 * @date 2021-08-19
 */
public interface CongWeiDaoTouDaYinLianBiaoLcof {
    int[] reversePrint(ListNode head);

    class Solution implements CongWeiDaoTouDaYinLianBiaoLcof {

        @Override
        public int[] reversePrint(ListNode head) {
            int len = 0;
            ListNode node = head;
            while (node != null) {
                len++;
                node = node.next;
            }
            int[] res = new int[len];
            int i = res.length - 1;
            while (head != null) {
                res[i--] = head.val;
                head = head.next;
            }
            return res;
        }
    }
}
