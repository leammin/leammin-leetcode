package com.leammin.leetcode.hard;

/**
 * 45. 跳跃游戏 II
 * 
 * <p>给定一个非负整数数组，你最初位于数组的第一个位置。</p>
 * 
 * <p>数组中的每个元素代表你在该位置可以跳跃的最大长度。</p>
 * 
 * <p>你的目标是使用最少的跳跃次数到达数组的最后一个位置。</p>
 * 
 * <p><strong>示例:</strong></p>
 * 
 * <pre><strong>输入:</strong> [2,3,1,1,4]
 * <strong>输出:</strong> 2
 * <strong>解释:</strong> 跳到最后一个位置的最小跳跃数是 <code>2</code>。
 * &nbsp;    从下标为 0 跳到下标为 1 的位置，跳&nbsp;<code>1</code>&nbsp;步，然后跳&nbsp;<code>3</code>&nbsp;步到达数组的最后一个位置。
 * </pre>
 * 
 * <p><strong>说明:</strong></p>
 * 
 * <p>假设你总是可以到达数组的最后一个位置。</p>
 * 
 * 
 * @author Leammin
 * @date 2019-09-02
 */
public interface JumpGameII {
    int jump(int[] nums);

    class Solution implements JumpGameII {
        @Override
        public int jump(int[] nums) {
            int jump = 0;
            int index = 1;
            int max = Math.min(nums[0], nums.length - 1);
            int to = max;
            while (index < nums.length) {
                max = Math.max(max, index + nums[index]);
                max = Math.min(max, nums.length - 1);
                if (index == to) {
                    jump++;
                    to = max;
                }
                index++;
            }
            return jump;
        }
    }
}
