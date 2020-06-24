package com.leammin.leetcode.medium;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * 
 * <p>给定一个包括&nbsp;<em>n</em> 个整数的数组&nbsp;<code>nums</code><em>&nbsp;</em>和 一个目标值&nbsp;<code>target</code>。找出&nbsp;<code>nums</code><em>&nbsp;</em>中的三个整数，使得它们的和与&nbsp;<code>target</code>&nbsp;最接近。返回这三个数的和。假定每组输入只存在唯一答案。</p>
 * 
 * <pre>例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2020-06-24
 */
public interface ThreeSumClosest {
    int threeSumClosest(int[] nums, int target);

    class Solution implements ThreeSumClosest {

        @Override
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int res = 0;
            int diff = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length - 2; i++) {
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (Math.abs(sum - target) < diff) {
                        res = sum;
                        diff = Math.abs(sum - target);
                    }
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        return sum;
                    }
                }
            }
            return res;
        }
    }
}
