package com.leammin.leetcode.undone.hard;

import java.util.Arrays;

/**
 * 719. 找出第 k 小的距离对
 *
 * <p>给定一个整数数组，返回所有数对之间的第 k 个最小<strong>距离</strong>。一对 (A, B) 的距离被定义为 A 和 B 之间的绝对差值。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>
 * nums = [1,3,1]
 * k = 1
 * <strong>输出：0</strong>
 * <strong>解释：</strong>
 * 所有数对如下：
 * (1,3) -&gt; 2
 * (1,1) -&gt; 0
 * (3,1) -&gt; 2
 * 因此第 1 个最小距离的数对是 (1,1)，它们之间的距离为 0。
 * </pre>
 *
 * <p><strong>提示:</strong></p>
 *
 * <ol>
 * 	<li><code>2 &lt;= len(nums) &lt;= 10000</code>.</li>
 * 	<li><code>0 &lt;= nums[i] &lt; 1000000</code>.</li>
 * 	<li><code>1 &lt;= k &lt;= len(nums) * (len(nums) - 1) / 2</code>.</li>
 * </ol>
 *
 * @author Leammin
 * @date 2020-06-19
 */
public interface FindKThSmallestPairDistance {
    int smallestDistancePair(int[] nums, int k);

    class Solution implements FindKThSmallestPairDistance {

        @Override
        public int smallestDistancePair(int[] nums, int k) {
            Arrays.sort(nums);
            int[][] range = new int[nums.length - 1][3];
            for (int i = 0; i < range.length; i++) {
                range[i][0] = i + 1;
                range[i][1] = nums.length - 1;
            }
            int mid = (range[0][0] + range[0][1]) / 2;
            range[0][2] = mid;
            int t = nums[mid];
            for (int i = 1; i < range.length; i++) {

            }
            return 0;
        }
    }
}
