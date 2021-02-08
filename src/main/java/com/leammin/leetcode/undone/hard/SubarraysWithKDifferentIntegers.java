package com.leammin.leetcode.undone.hard;

import java.util.Arrays;

/**
 * 992. K 个不同整数的子数组
 *
 * <p>给定一个正整数数组 <code>A</code>，如果 <code>A</code>&nbsp;的某个子数组中不同整数的个数恰好为 <code>K</code>，则称 <code>A</code> 的这个连续、不一定独立的子数组为<em>好子数组</em>。</p>
 *
 * <p>（例如，<code>[1,2,3,1,2]</code> 中有&nbsp;<code>3</code>&nbsp;个不同的整数：<code>1</code>，<code>2</code>，以及&nbsp;<code>3</code>。）</p>
 *
 * <p>返回&nbsp;<code>A</code>&nbsp;中<em>好子数组</em>的数目。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输出：</strong>A = [1,2,1,2,3], K = 2
 * <strong>输入：</strong>7
 * <strong>解释：</strong>恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>A = [1,2,1,3,4], K = 3
 * <strong>输出：</strong>3
 * <strong>解释：</strong>恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ol>
 * 	<li><code>1 &lt;= A.length &lt;= 20000</code></li>
 * 	<li><code>1 &lt;= A[i] &lt;= A.length</code></li>
 * 	<li><code>1 &lt;= K &lt;= A.length</code></li>
 * </ol>
 *
 * @author Leammin
 * @date 2021-02-09
 */
public interface SubarraysWithKDifferentIntegers {
    int subarraysWithKDistinct(int[] A, int K);

    class Solution1 implements SubarraysWithKDifferentIntegers {

        @Override
        public int subarraysWithKDistinct(int[] A, int K) {
            int result = 0;
            for (int i = 0; i < A.length; i++) {
                for (int j = i; j < A.length; j++) {
                    if (Arrays.stream(A, i, j + 1).distinct().count() == K) {
                        result++;
                    }
                }
            }
            return result;
        }
    }

    class Solution2 implements SubarraysWithKDifferentIntegers {


        @Override
        public int subarraysWithKDistinct(int[] A, int K) {
            int[] count = new int[A.length + 1];
            int size = 0;
            int result = 0;
            int l = 0, r = 0;
            while (r < A.length || size == K) {
                if (size != K && count[A[r++]]++ == 0) {
                    size++;
                }
                if (size == K) {
                    int i = r;
                    while (i < A.length && count[A[i]] > 0) {
                        i++;
                    }
                    int rc = i - r + 1;
                    int lc = 0;
                    do {
                        lc++;
                        int v = A[l++];
                        if (count[v] > 0 && --count[v] == 0) {
                            size--;
                        }
                    } while (l < r && A[l - 1] == A[l]);
                    result += rc * lc;
                }
            }
            return result;
        }
    }
}
