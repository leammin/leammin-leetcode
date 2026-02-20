package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;
import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/house-robber-ii/">213. 打家劫舍 II</a>
 *
 * <p>你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 <strong>围成一圈</strong> ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，<strong>如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警</strong> 。</p>
 *
 * <p>给定一个代A * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [1,2,3,1]
 * <strong>输出：</strong>4
 * <strong>解释：</strong>你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * &nbsp;    偷窃到的最高金额 = 1 + 3 = 4 。</pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [1,2,3]
 * <strong>输出：</strong>3
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
 * 	<li><code>0 &lt;= nums[i] &lt;= 1000</code></li>
 * </ul>
 *
 *
 * @author Leammin
 * @date 2026-02-20
 */
public interface HouseRobberIi {
    public int rob(int[] nums);

    static Testsuite<HouseRobberIi> testsuite() {
        return Testsuite.<HouseRobberIi>builder()
            .addExpected(t -> t.rob(new int[] { 2, 3, 2 }), 3)
            .addExpected(t -> t.rob(new int[] { 1, 2, 3, 1 }), 4)
            .addExpected(t -> t.rob(new int[] { 1, 2, 3 }), 3)
            .addExpected(t -> t.rob(new int[] { 200, 3, 140, 20, 10 }), 340)
            .addExpected(t -> t.rob(new int[] { 1 }), 1)
            .addExpected(t -> t.rob(new int[] { 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0 }), 0)
            .build();
    }

    class Solution implements HouseRobberIi {

        @Override
        public int rob(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            Integer[][] cache = new Integer[101][101];
            return Math.max(doRob(nums, 0, nums.length - 1, cache), doRob(nums, 1, nums.length, cache));
        }

        public int doRob(int[] nums, int left, int right, Integer[][] cache) {
            if (left >= right) {
                return 0;
            }
            if (cache[left][right] != null) {
                return cache[left][right];
            }
            if (nums[left] == 0) {
                return cache[left][right] = doRob(nums, left + 1, right, cache);
            }
            if (nums[right - 1] == 0) {
                return cache[left][right] = doRob(nums, left, right - 1, cache);
            }
            int max = 0;
            for (int i = left; i < right; i++) {
                if (nums[i] == 0) {
                    continue;
                }
                max = Math.max(max, doRob(nums, left, i - 1, cache) + nums[i] + doRob(nums, i + 2, right, cache));
            }
            return cache[left][right] = max;
        }
    }
    
    
    class Solution2 implements HouseRobberIi {

        @Override
        public int rob(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            if (nums.length == 2) {
                return Math.max(nums[0], nums[1]);
            }
            return Math.max(doRob(nums, 0, nums.length - 1), doRob(nums, 1, nums.length));
        }

        public int doRob(int[] nums, int left, int right) {
            int a = nums[left], b = Math.max(a, nums[left + 1]);
            for(int i = left + 2; i < right; i++) {
                int c = Math.max(a + nums[i], b);
                a = b;
                b = c;
            }
            return b;
        }
    }
}

class HouseRobberIiTest extends AbstractTest<HouseRobberIi> {}
