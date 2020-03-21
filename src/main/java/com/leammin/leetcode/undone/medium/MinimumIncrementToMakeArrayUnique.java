package com.leammin.leetcode.undone.medium;

/**
 * 945. 使数组唯一的最小增量
 * 
 * <p>给定整数数组 A，每次 <em>move</em> 操作将会选择任意&nbsp;<code>A[i]</code>，并将其递增&nbsp;<code>1</code>。</p>
 * 
 * <p>返回使 <code>A</code>&nbsp;中的每个值都是唯一的最少操作次数。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre><strong>输入：</strong>[1,2,2]
 * <strong>输出：</strong>1
 * <strong>解释：</strong>经过一次 <em>move</em> 操作，数组将变为 [1, 2, 3]。</pre>
 * 
 * <p><strong>示例 2:</strong></p>
 * 
 * <pre><strong>输入：</strong>[3,2,1,2,1,7]
 * <strong>输出：</strong>6
 * <strong>解释：</strong>经过 6 次 <em>move</em> 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 * 可以看出 5 次或 5 次以下的 <em>move</em> 操作是不能让数组的每个值唯一的。
 * </pre>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ol>
 * 	<li><code>0 &lt;= A.length &lt;= 40000</code></li>
 * 	<li><code>0 &lt;= A[i] &lt; 40000</code></li>
 * </ol>
 * 
 * 
 * @author Leammin
 * @date 2020-03-22
 */
public interface MinimumIncrementToMakeArrayUnique {
    int minIncrementForUnique(int[] A);

    class Solution implements MinimumIncrementToMakeArrayUnique {

        @Override
        public int minIncrementForUnique(int[] A) {
            int[] count = new int[80000];
            for (int value : A) {
                count[value]++;
            }
            int res = 0;
            for (int i = 0; i < count.length; i++) {
                if (count[i] > 1) {
                    res += count[i] - 1;
                    count[i + 1] += count[i] - 1;
                    count[i] = 1;
                }
            }
            return res;
        }
    }
}
