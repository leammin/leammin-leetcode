package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 1004. 最大连续1的个数 III
 * 
 * <p>给定一个由若干 <code>0</code> 和 <code>1</code> 组成的数组&nbsp;<code>A</code>，我们最多可以将&nbsp;<code>K</code>&nbsp;个值从 0 变成 1 。</p>
 * 
 * <p>返回仅包含 1 的最长（连续）子数组的长度。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输入：</strong>A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * <strong>输出：</strong>6
 * <strong>解释： </strong>
 * [1,1,1,0,0,<strong>1</strong>,1,1,1,1,<strong>1</strong>]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。</pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre><strong>输入：</strong>A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * <strong>输出：</strong>10
 * <strong>解释：</strong>
 * [0,0,1,1,<strong>1</strong>,<strong>1</strong>,1,1,1,<strong>1</strong>,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。</pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ol>
 * 	<li><code>1 &lt;= A.length &lt;= 20000</code></li>
 * 	<li><code>0 &lt;= K &lt;= A.length</code></li>
 * 	<li><code>A[i]</code> 为&nbsp;<code>0</code>&nbsp;或&nbsp;<code>1</code>&nbsp;</li>
 * </ol>
 * 
 * 
 * @author Leammin
 * @date 2021-02-19
 */
public interface MaxConsecutiveOnesIii {
    int longestOnes(int[] A, int K);

    static Testsuite<MaxConsecutiveOnesIii> testsuite() {
        return Testsuite.<MaxConsecutiveOnesIii>builder()
                .add(ExpectedTestcase.of(t -> t.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2), 6))
                .add(ExpectedTestcase.of(t -> t.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3), 10))
                .build();
    }


    class Solution implements MaxConsecutiveOnesIii {

        @Override
        public int longestOnes(int[] A, int K) {
            int max = 0, count = 0;
            for (int l = 0, r = 0; r < A.length; r++) {
                if (A[r] == 0) {
                    count++;
                }
                if (count > K) {
                    while (A[l] == 1) {
                        l++;
                    }
                    l++;
                    count--;
                }
                max = Math.max(max, r - l + 1);
            }
            return max;
        }
    }
}

class MaxConsecutiveOnesIiiTest extends AbstractTest<MaxConsecutiveOnesIii> {
}
