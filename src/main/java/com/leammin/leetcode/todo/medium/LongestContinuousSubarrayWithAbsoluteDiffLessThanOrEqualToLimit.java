package com.leammin.leetcode.todo.medium;

import java.util.TreeMap;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 1438. 绝对差不超过限制的最长连续子数组
 * 
 * <p>给你一个整数数组 <code>nums</code> ，和一个表示限制的整数 <code>limit</code>，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 <code>limit</code><em> 。</em></p>
 * 
 * <p>如果不存在满足条件的子数组，则返回 <code>0</code> 。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输入：</strong>nums = [8,2,4,7], limit = 4
 * <strong>输出：</strong>2 
 * <strong>解释：</strong>所有子数组如下：
 * [8] 最大绝对差 |8-8| = 0 &lt;= 4.
 * [8,2] 最大绝对差 |8-2| = 6 &gt; 4. 
 * [8,2,4] 最大绝对差 |8-2| = 6 &gt; 4.
 * [8,2,4,7] 最大绝对差 |8-2| = 6 &gt; 4.
 * [2] 最大绝对差 |2-2| = 0 &lt;= 4.
 * [2,4] 最大绝对差 |2-4| = 2 &lt;= 4.
 * [2,4,7] 最大绝对差 |2-7| = 5 &gt; 4.
 * [4] 最大绝对差 |4-4| = 0 &lt;= 4.
 * [4,7] 最大绝对差 |4-7| = 3 &lt;= 4.
 * [7] 最大绝对差 |7-7| = 0 &lt;= 4. 
 * 因此，满足题意的最长子数组的长度为 2 。
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre><strong>输入：</strong>nums = [10,1,2,4,7,2], limit = 5
 * <strong>输出：</strong>4 
 * <strong>解释：</strong>满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 &lt;= 5 。
 * </pre>
 * 
 * <p><strong>示例 3：</strong></p>
 * 
 * <pre><strong>输入：</strong>nums = [4,2,2,2,4,4,2,2], limit = 0
 * <strong>输出：</strong>3
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 10^5</code></li>
 * 	<li><code>1 &lt;= nums[i] &lt;= 10^9</code></li>
 * 	<li><code>0 &lt;= limit &lt;= 10^9</code></li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2021-02-21
 */
public interface LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    int longestSubarray(int[] nums, int limit);

    static Testsuite<LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit> testsuite() {
        return Testsuite.<LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit>builder()
                .add(ExpectedTestcase.of(t -> t.longestSubarray(new int[]{8,2,4,7}, 4), 2))
                .add(ExpectedTestcase.of(t -> t.longestSubarray(new int[]{10,1,2,4,7,2}, 5), 4))
                .add(ExpectedTestcase.of(t -> t.longestSubarray(new int[]{4,2,2,2,4,4,2,2}, 0), 3))
                .build();
    }


    class Solution implements LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

        @Override
        public int longestSubarray(int[] nums, int limit) {
            TreeMap<Integer, Integer> counter = new TreeMap<>();
            int maxLen = 0;
            for (int l = 0, r = 0; r < nums.length; r++) {
                counter.compute(nums[r], (k, v) -> v == null ? 1 : (v + 1));
                while (counter.lastKey() - counter.firstKey() > limit) {
                    counter.compute(nums[l++], (k, v) -> v == null || v <= 1 ? null : v - 1);
                }
                maxLen = Math.max(maxLen, r - l + 1);
            }
            return maxLen;
        }
    }

}

class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimitTest extends AbstractTest<LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit> {
}
