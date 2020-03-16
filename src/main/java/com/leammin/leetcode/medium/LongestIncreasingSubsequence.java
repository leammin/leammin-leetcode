package com.leammin.leetcode.medium;

import java.util.Arrays;

/**
 * 300. 最长上升子序列
 *
 * <p>给定一个无序的整数数组，找到其中最长上升子序列的长度。</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong>输入:</strong> <code>[10,9,2,5,3,7,101,18]
 * </code><strong>输出: </strong>4
 * <strong>解释: </strong>最长的上升子序列是&nbsp;<code>[2,3,7,101]，</code>它的长度是 <code>4</code>。</pre>
 *
 * <p><strong>说明:</strong></p>
 *
 * <ul>
 * 	<li>可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。</li>
 * 	<li>你算法的时间复杂度应该为&nbsp;O(<em>n<sup>2</sup></em>) 。</li>
 * </ul>
 *
 * <p><strong>进阶:</strong> 你能将算法的时间复杂度降低到&nbsp;O(<em>n</em> log <em>n</em>) 吗?</p>
 *
 * @author Leammin
 * @date 2020-03-14
 */
public interface LongestIncreasingSubsequence {
    int lengthOfLIS(int[] nums);

    class Solution implements LongestIncreasingSubsequence {

        @Override
        public int lengthOfLIS(int[] nums) {
            int[] count = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                count[i] = 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] < nums[i] && count[j] >= count[i]) {
                        count[i] = count[j] + 1;
                    }
                }
            }
            int max = 0;
            for (int c : count) {
                if (c > max) {
                    max = c;
                }
            }
            return max;
        }
    }

    class Best implements LongestIncreasingSubsequence {

        @Override
        public int lengthOfLIS(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            // 表示长度为 i+1 的最长上升子序列的末尾元素的最小值
            int[] d = new int[nums.length];
            int len = 1;
            d[0] = nums[0];
            for (int num : nums) {
                int index = Arrays.binarySearch(d, 0, len, num);
                int di = -(index + 1);
                if (di >= 0) {
                    len = d[di] == 0 ? len + 1 : len;
                    d[di] = d[di] == 0 || d[di] > num ? num : d[di];
                }
            }
            return len;
        }
    }
}
