package com.leammin.leetcode.easy;

/**
 * 198. 打家劫舍
 *
 * <div><p>你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，<strong>如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警</strong>。</p>
 *
 * <p>给定一个代表每个房屋存放金额的非负整数数组，计算你<strong>在不触动警报装置的情况下，</strong>能够偷窃到的最高金额。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong> [1,2,3,1]
 * <strong>输出:</strong> 4
 * <strong>解释:</strong> 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * &nbsp;    偷窃到的最高金额 = 1 + 3 = 4 。</pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入:</strong> [2,7,9,3,1]
 * <strong>输出:</strong> 12
 * <strong>解释:</strong> 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * &nbsp;    偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * </pre>
 * </div>
 *
 * @author Leammin
 * @date 2018-10-29
 */
public interface HouseRobber {
    int rob(int[] nums);

    class Solution implements HouseRobber {
        @Override
        public int rob(int[] nums) {
            int[] cache = new int[nums.length];
            for (int i = 0; i < cache.length; i++) {
                cache[i] = -1;
            }
            return rob(nums, 0, cache);
        }

        private int rob(int[] nums, int start, int[] cache) {
            if (start >= nums.length) {
                return 0;
            }
            if (cache[start] != -1) {
                return cache[start];
            }
            int res;
            if (start == nums.length - 1) {
                res = nums[start];
            } else if (start == nums.length - 2) {
                res = Math.max(nums[start], nums[start + 1]);
            } else if (start == nums.length - 3) {
                res = Math.max(nums[start] + nums[start + 2], nums[start + 1]);
            } else {
                res = Math.max(nums[start] + rob(nums, start + 2, cache), nums[start + 1] + rob(nums, start + 3, cache));
            }
            cache[start] = res;
            return res;
        }
    }

}
