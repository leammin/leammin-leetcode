package com.leammin.leetcode.undone.medium;

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
 * 
 * @author Leammin
 * @date 2020-05-18
 */
public interface MaximumProductSubarray {
    int maxProduct(int[] nums);

    class Solution implements MaximumProductSubarray {

        @Override
        public int maxProduct(int[] nums) {
            return 0;
        }
    }
}
