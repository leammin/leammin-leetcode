package com.leammin.leetcode.easy;

/**
 * 面试题15. 二进制中1的个数
 * 
 * <p>请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9&nbsp;表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输入：</strong>00000000000000000000000000001011
 * <strong>输出：</strong>3
 * <strong>解释：</strong>输入的二进制串 <code><strong>00000000000000000000000000001011</strong>&nbsp;中，共有三位为 &#39;1&#39;。</code>
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre><strong>输入：</strong>00000000000000000000000010000000
 * <strong>输出：</strong>1
 * <strong>解释：</strong>输入的二进制串 <strong>00000000000000000000000010000000</strong>&nbsp;中，共有一位为 &#39;1&#39;。
 * </pre>
 * 
 * <p><strong>示例 3：</strong></p>
 * 
 * <pre><strong>输入：</strong>11111111111111111111111111111101
 * <strong>输出：</strong>31
 * <strong>解释：</strong>输入的二进制串 <strong>11111111111111111111111111111101</strong> 中，共有 31 位为 &#39;1&#39;。</pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p>注意：本题与主站 191 题相同：<a href="https://leetcode-cn.com/problems/number-of-1-bits/">https://leetcode-cn.com/problems/number-of-1-bits/</a></p>
 * 
 * 
 * @author Leammin
 * @date 2021-09-06
 */
public interface ErJinZhiZhong1deGeShuLcof {
    public int hammingWeight(int n);

    class Solution implements ErJinZhiZhong1deGeShuLcof {

        @Override
        public int hammingWeight(int n) {
            int r = 0;
            while (n != 0) {
                if ((n & 1) > 0) {
                    r++;
                }
                n >>>= 1;
            }
            return r;
        }
    }
}
