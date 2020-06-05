package com.leammin.leetcode.medium;

/**
 * 238. 除自身以外数组的乘积
 * 
 * <p>给定长度为&nbsp;<em>n</em>&nbsp;的整数数组&nbsp;<code>nums</code>，其中&nbsp;<em>n</em> &gt; 1，返回输出数组&nbsp;<code>output</code>&nbsp;，其中 <code>output[i]</code>&nbsp;等于&nbsp;<code>nums</code>&nbsp;中除&nbsp;<code>nums[i]</code>&nbsp;之外其余各元素的乘积。</p>
 * 
 * <p><strong>示例:</strong></p>
 * 
 * <pre><strong>输入:</strong> <code>[1,2,3,4]</code>
 * <strong>输出:</strong> <code>[24,12,8,6]</code></pre>
 * 
 * <p><strong>说明: </strong>请<strong>不要使用除法，</strong>且在&nbsp;O(<em>n</em>) 时间复杂度内完成此题。</p>
 * 
 * <p><strong>进阶：</strong><br>
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组<strong>不被视为</strong>额外空间。）</p>
 * 
 * 
 * @author Leammin
 * @date 2020-06-04
 */
public interface ProductOfArrayExceptSelf {
    int[] productExceptSelf(int[] nums);

    class Solution implements ProductOfArrayExceptSelf {

        @Override
        public int[] productExceptSelf(int[] nums) {
            int[] res = new int[nums.length];
            res[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                res[i] = res[i - 1] * nums[i - 1];
            }
            int pro = 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                res[i] *= pro;
                pro *= nums[i];
            }
            return res;
        }
    }
}
