package com.leammin.leetcode.easy;

import java.util.Arrays;

/**
 * 1005. K 次取反后最大化的数组和
 * 
 * <p>给定一个整数数组 A，我们<strong>只能</strong>用以下方法修改该数组：我们选择某个个索引 <code>i</code>&nbsp;并将 <code>A[i]</code> 替换为 <code>-A[i]</code>，然后总共重复这个过程 <code>K</code> 次。（我们可以多次选择同一个索引 <code>i</code>。）</p>
 * 
 * <p>以这种方式修改数组后，返回数组可能的最大和。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输入：</strong>A = [4,2,3], K = 1
 * <strong>输出：</strong>5
 * <strong>解释：</strong>选择索引 (1,) ，然后 A 变为 [4,-2,3]。
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre><strong>输入：</strong>A = [3,-1,0,2], K = 3
 * <strong>输出：</strong>6
 * <strong>解释：</strong>选择索引 (1, 2, 2) ，然后 A 变为 [3,1,0,2]。
 * </pre>
 * 
 * <p><strong>示例 3：</strong></p>
 * 
 * <pre><strong>输入：</strong>A = [2,-3,-1,5,-4], K = 2
 * <strong>输出：</strong>13
 * <strong>解释：</strong>选择索引 (1, 4) ，然后 A 变为 [2,3,-1,5,4]。
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ol>
 * 	<li><code>1 &lt;= A.length &lt;= 10000</code></li>
 * 	<li><code>1 &lt;= K &lt;= 10000</code></li>
 * 	<li><code>-100 &lt;= A[i] &lt;= 100</code></li>
 * </ol>
 * 
 * 
 * @author Leammin
 * @date 2019-08-29
 */
public interface MaximizeSumOfArrayAfterKNegations {
    int largestSumAfterKNegations(int[] a, int k);

    class Solution implements MaximizeSumOfArrayAfterKNegations {
        @Override
        public int largestSumAfterKNegations(int[] a, int k) {
            Arrays.sort(a);
            int index = 0;
            while (index < a.length && k > 0 && a[index] < 0) {
                a[index] = -a[index];
                index++;
                k--;
            }
            if (index >= a.length || (index > 0 && Math.abs(a[index]) > Math.abs(a[index - 1]))) {
                index--;
            }
            a[index] = a[index] * ((k & 1) == 0 ? 1 : -1);
            int sum = 0;
            for (int i : a) {
                sum += i;
            }
            return sum;
        }
    }
}
