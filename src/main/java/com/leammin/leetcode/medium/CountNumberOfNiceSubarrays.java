package com.leammin.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1248. 统计「优美子数组」
 *
 * <p>给你一个整数数组&nbsp;<code>nums</code> 和一个整数 <code>k</code>。</p>
 *
 * <p>如果某个 <strong>连续</strong> 子数组中恰好有 <code>k</code> 个奇数数字，我们就认为这个子数组是「<strong>优美子数组</strong>」。</p>
 *
 * <p>请返回这个数组中「优美子数组」的数目。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>nums = [1,1,2,1,1], k = 3
 * <strong>输出：</strong>2
 * <strong>解释：</strong>包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>nums = [2,4,6], k = 1
 * <strong>输出：</strong>0
 * <strong>解释：</strong>数列中不包含任何奇数，所以不存在优美子数组。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre><strong>输入：</strong>nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * <strong>输出：</strong>16
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 50000</code></li>
 * 	<li><code>1 &lt;= nums[i] &lt;= 10^5</code></li>
 * 	<li><code>1 &lt;= k &lt;= nums.length</code></li>
 * </ul>
 *
 * @author Leammin
 * @date 2020-04-21
 */
public interface CountNumberOfNiceSubarrays {
    int numberOfSubarrays(int[] nums, int k);


    class Solution implements CountNumberOfNiceSubarrays {

        @Override
        public int numberOfSubarrays(int[] nums, int k) {
            int last = -1;
            Queue<Integer> oddIndexes = new ArrayDeque<>(k);
            int index = 0;
            for (; index < nums.length && oddIndexes.size() < k; index++) {
                if ((nums[index] & 1) == 1) {
                    oddIndexes.add(index);
                }
            }
            if (oddIndexes.size() != k) {
                return 0;
            }
            int ans = oddIndexes.peek() - last;
            for (; index < nums.length; index++) {
                if ((nums[index] & 1) == 1) {
                    last = oddIndexes.poll();
                    oddIndexes.add(index);
                }
                ans += (oddIndexes.peek() - last);
            }
            return ans;
        }
    }

    class Solution2 implements CountNumberOfNiceSubarrays {

        @Override
        public int numberOfSubarrays(int[] nums, int k) {
            int last = -1;
            int left = -1;
            int right = -1;
            for (int i = 0, oddCount = 0; i < nums.length && oddCount < k; i++) {
                if ((nums[i] & 1) == 1) {
                    oddCount++;
                    if (oddCount == 1) {
                        left = i;
                    }
                    if (oddCount == k) {
                        right = i;
                    }
                }
            }
            if (right < 0) {
                return 0;
            }
            int ans = left - last;
            for (right++ ; right < nums.length; right++) {
                if ((nums[right] & 1) == 1) {
                    last = left;
                    while ((nums[++left] & 1) != 1) {
                    }
                }
                ans += (left - last);
            }
            return ans;
        }
    }
}
