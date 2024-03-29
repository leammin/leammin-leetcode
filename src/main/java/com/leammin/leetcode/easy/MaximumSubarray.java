package com.leammin.leetcode.easy;

/**
 * 53. 最大子序和
 *
 * <div><p>给定一个整数数组 <code>nums</code>&nbsp;，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong>输入:</strong> [-2,1,-3,4,-1,2,1,-5,4],
 * <strong>输出:</strong> 6
 * <strong>解释:</strong>&nbsp;连续子数组&nbsp;[4,-1,2,1] 的和最大，为&nbsp;6。
 * </pre>
 *
 * <p><strong>进阶:</strong></p>
 *
 * <p>如果你已经实现复杂度为 O(<em>n</em>) 的解法，尝试使用更为精妙的分治法求解。</p>
 * </div>
 *
 * @author Leammin
 * @date 2018-09-30
 */
public interface MaximumSubarray {
    int maxSubArray(int[] nums);

    class Solution implements MaximumSubarray {
        @Override
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int max = nums[0];
            for (int i = 0, sum = 0; i < nums.length; i++) {
                sum += nums[i];
                if (sum > max) {
                    max = sum;
                }
                if (sum < 0) {
                    sum = 0;
                }
            }
            return max;
        }
    }

}
