package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 55. 跳跃游戏
 * 
 * <p>给定一个非负整数数组，你最初位于数组的第一个位置。</p>
 * 
 * <p>数组中的每个元素代表你在该位置可以跳跃的最大长度。</p>
 * 
 * <p>判断你是否能够到达最后一个位置。</p>
 * 
 * <p><strong>示例&nbsp;1:</strong></p>
 * 
 * <pre><strong>输入:</strong> [2,3,1,1,4]
 * <strong>输出:</strong> true
 * <strong>解释:</strong> 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * </pre>
 * 
 * <p><strong>示例&nbsp;2:</strong></p>
 * 
 * <pre><strong>输入:</strong> [3,2,1,0,4]
 * <strong>输出:</strong> false
 * <strong>解释:</strong> 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2019-09-02
 */
public interface JumpGame {
    boolean canJump(int[] nums);

    static Testsuite<JumpGame> testsuite() {
        return Testsuite.<JumpGame>builder()
                .add(ExpectedTestcase.of(t -> t.canJump(new int[]{2, 3, 1, 1, 4}), true))
                .add(ExpectedTestcase.of(t -> t.canJump(new int[]{3, 2, 1, 0, 4}), false))
                .add(ExpectedTestcase.of(t -> t.canJump(new int[]{0}), true))
                .add(ExpectedTestcase.of(t -> t.canJump(new int[]{2, 0, 0}), true))
                .add(ExpectedTestcase.of(t -> t.canJump(new int[]{3, 0, 0, 0}), true))
                .add(ExpectedTestcase.of(t -> t.canJump(new int[]{10, 0, 0, 2, 0, 0, 0}), true))
                .build();
    }


    class Solution implements JumpGame {
        @Override
        public boolean canJump(int[] nums) {
            for (int i = 0, max = 0; i < nums.length; i++, max--) {
                if (max < 0) {
                    return false;
                }
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
            return true;
        }
    }
}

class JumpGameTest extends AbstractTest<JumpGame> {
}
