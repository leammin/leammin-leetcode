package com.leammin.leetcode.medium;

import java.util.Arrays;

/**
 * 209. 长度最小的子数组
 * 
 * <p>给定一个含有&nbsp;<strong>n&nbsp;</strong>个正整数的数组和一个正整数&nbsp;<strong>s ，</strong>找出该数组中满足其和<strong> &ge; s </strong>的长度最小的连续子数组<strong>。</strong>如果不存在符合条件的连续子数组，返回 0。</p>
 * 
 * <p><strong>示例:&nbsp;</strong></p>
 * 
 * <pre><strong>输入:</strong> <code>s = 7, nums = [2,3,1,2,4,3]</code>
 * <strong>输出:</strong> 2
 * <strong>解释: </strong>子数组&nbsp;<code>[4,3]</code>&nbsp;是该条件下的长度最小的连续子数组。
 * </pre>
 * 
 * <p><strong>进阶:</strong></p>
 * 
 * <p>如果你已经完成了<em>O</em>(<em>n</em>) 时间复杂度的解法, 请尝试&nbsp;<em>O</em>(<em>n</em> log <em>n</em>) 时间复杂度的解法。</p>
 * 
 * 
 * @author Leammin
 * @date 2020-06-15
 */
public interface MinimumSizeSubarraySum {
    int minSubArrayLen(int s, int[] nums);

    class Solution implements MinimumSizeSubarraySum {

        @Override
        public int minSubArrayLen(int s, int[] nums) {
            int res = Integer.MAX_VALUE;
            int head = 0;
            int tail = 0;
            int sum = 0;
            while (tail <= nums.length) {
                if (sum < s) {
                    if (tail == nums.length) {
                        break;
                    }
                    sum += nums[tail++];
                } else {
                    res = Math.min(res, tail - head);
                    sum -= nums[head++];
                }
            }
            return res == Integer.MAX_VALUE ? 0 : res;
        }
    }

    class Solution2 implements MinimumSizeSubarraySum {

        @Override
        public int minSubArrayLen(int s, int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int start = -1;
            int[] sums = new int[nums.length];
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sums[i] = sum += nums[i];
                if (sum >= s && start < 0) {
                    start = i;
                }
            }
            if (start < 0) {
                return 0;
            }
            int res = start + 1;
            for (int i = start; i < sums.length; i++) {
                int search = Arrays.binarySearch(sums, sums[i] - s);
                if (search < 0) {
                    search = -search-2;
                }
                res = Math.min(res, i - search);
            }

            return res;
        }
    }
}
