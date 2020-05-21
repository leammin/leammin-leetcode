package com.leammin.leetcode.medium;

/**
 * 152. 乘积最大子序列
 *
 * <p>给定一个整数数组 <code>nums</code>&nbsp;，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong> [2,3,-2,4]
 * <strong>输出:</strong> <code>6</code>
 * <strong>解释:</strong>&nbsp;子数组 [2,3] 有最大乘积 6。
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入:</strong> [-2,0,-1]
 * <strong>输出:</strong> 0
 * <strong>解释:</strong>&nbsp;结果不能为 2, 因为 [-2,-1] 不是子数组。</pre>
 *
 * @author Leammin
 * @date 2020-05-18
 */
public interface MaximumProductSubarray {
    int maxProduct(int[] nums);

    class Solution implements MaximumProductSubarray {

        @Override
        public int maxProduct(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                int start = i;
                int negCount = 0;
                int negL = -1;
                int negR = -1;
                for (; i < nums.length && nums[i] != 0; i++) {
                    if (nums[i] < 0) {
                        negCount++;
                        negR = i;
                        if (negL < 0) {
                            negL = i;
                        }
                    }
                }
                if (negCount % 2 == 0) {
                    max = Math.max(max, product(nums, start, i));
                } else {
                    max = Math.max(max, product(nums, start, negR));
                    max = Math.max(max, product(nums, negL + 1, i));
                }
            }
            return max;
        }

        private int product(int[] nums, int from, int to) {
            if (from >= to) {
                return 0;
            }
            int p = 1;
            for (int i = from; i < to; i++) {
                p *= nums[i];
            }
            return p;
        }
    }
}
