package com.leammin.leetcode.easy;

/**
 * 485. 最大连续1的个数
 * 
 * <p>给定一个二进制数组， 计算其中最大连续1的个数。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre>
 * <strong>输入:</strong> [1,1,0,1,1,1]
 * <strong>输出:</strong> 3
 * <strong>解释:</strong> 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * </pre>
 * 
 * <p><strong>注意：</strong></p>
 * 
 * <ul>
 * 	<li>输入的数组只包含&nbsp;<code>0</code> 和<code>1</code>。</li>
 * 	<li>输入数组的长度是正整数，且不超过 10,000。</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2020-06-13
 */
public interface MaxConsecutiveOnes {
    int findMaxConsecutiveOnes(int[] nums);

    class Solution implements MaxConsecutiveOnes {

        @Override
        public int findMaxConsecutiveOnes(int[] nums) {
            int res = 0;
            int l = -1;
            for (int i = 0; i <= nums.length; i++) {
                if (l < 0 && i < nums.length && nums[i] == 1) {
                    l = i;
                }
                if (l >= 0 && (i == nums.length || nums[i] != 1)) {
                    res = Math.max(res, i - l);
                    l = -1;
                }
            }
            return res;
        }
    }
}
