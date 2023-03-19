package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.test.Testsuite;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/longest-subsequence-with-limited-sum/">2389. 和有限的最长子序列</a>
 * 
 * <p>给你一个长度为 <code>n</code>&nbsp;的整数数组 <code>nums</code> ，和一个长度为 <code>m</code> 的整数数组 <code>queries</code> 。</p>
 * 
 * <p>返回一个长度为 <code>m</code> 的数组<em> </em><code>answer</code><em> </em>，其中<em> </em><code>answer[i]</code><em> </em>是 <code>nums</code> 中<span style=""> </span>元素之和小于等于 <code>queries[i]</code> 的 <strong>子序列</strong> 的 <strong>最大</strong> 长度<span style="">&nbsp;</span><span style=""> </span>。</p>
 * 
 * <p><strong>子序列</strong> 是由一个数组删除某些元素（也可以不删除）但不改变剩余元素顺序得到的一个数组。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre>
 * <strong>输入：</strong>nums = [4,5,2,1], queries = [3,10,21]
 * <strong>输出：</strong>[2,3,4]
 * <strong>解释：</strong>queries 对应的 answer 如下：
 * - 子序列 [2,1] 的和小于或等于 3 。可以证明满足题目要求的子序列的最大长度是 2 ，所以 answer[0] = 2 。
 * - 子序列 [4,5,1] 的和小于或等于 10 。可以证明满足题目要求的子序列的最大长度是 3 ，所以 answer[1] = 3 。
 * - 子序列 [4,5,2,1] 的和小于或等于 21 。可以证明满足题目要求的子序列的最大长度是 4 ，所以 answer[2] = 4 。
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre>
 * <strong>输入：</strong>nums = [2,3,4,5], queries = [1]
 * <strong>输出：</strong>[0]
 * <strong>解释：</strong>空子序列是唯一一个满足元素和小于或等于 1 的子序列，所以 answer[0] = 0 。</pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ul>
 * 	<li><code>n == nums.length</code></li>
 * 	<li><code>m == queries.length</code></li>
 * 	<li><code>1 &lt;= n, m &lt;= 1000</code></li>
 * 	<li><code>1 &lt;= nums[i], queries[i] &lt;= 10<sup>6</sup></code></li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2023-03-17
 */
public interface LongestSubsequenceWithLimitedSum {
    int[] answerQueries(int[] nums, int[] queries);
    static Testsuite<LongestSubsequenceWithLimitedSum> testsuite() {
        return Testsuite.<LongestSubsequenceWithLimitedSum>builder()
                .addExpected(t -> t.answerQueries(new int[]{4,5,2,1}, new int[]{3,10,21}), new int[]{2,3,4})
                .addExpected(t -> t.answerQueries(new int[]{2,3,4,5}, new int[]{1}), new int[]{0})
                .build();
    }

    class Solution implements LongestSubsequenceWithLimitedSum {

        @Override
        public int[] answerQueries(int[] nums, int[] queries) {
            Arrays.sort(nums);
            for (int i = 1; i < nums.length; i++) {
                nums[i] += nums[i - 1];
            }
            int[] res = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                res[i] = binarySearch(nums, queries[i]) + 1;
            }
            return res;
        }

        private int binarySearch(int[] nums, int target) {
            int l = 0;
            int r = nums.length;
            while (l < r) {
                int mid = (l + r) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    r = mid;
                } else if (nums[mid] < target) {
                    l = mid + 1;
                }
            }
            return l - 1;
        }

    }
}
