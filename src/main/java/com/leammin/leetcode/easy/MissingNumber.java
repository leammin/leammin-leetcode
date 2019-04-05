package com.leammin.leetcode.easy;

import java.util.Arrays;

/**
 * 268. 缺失数字
 *
 * <div><p>给定一个包含 <code>0, 1, 2, ..., n</code>&nbsp;中&nbsp;<em>n</em>&nbsp;个数的序列，找出 0 .. <em>n</em>&nbsp;中没有出现在序列中的那个数。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong> [3,0,1]
 * <strong>输出:</strong> 2
 * </pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入:</strong> [9,6,4,2,3,5,7,0,1]
 * <strong>输出:</strong> 8
 * </pre>
 *
 * <p><strong>说明:</strong><br>
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?</p>
 * </div>
 *
 * @author Leammin
 * @date 2018-10-28
 */
public interface MissingNumber {
    int missingNumber(int[] nums);

    class Solution implements MissingNumber {
        @Override
        public int missingNumber(int[] nums) {
            boolean[] to = new boolean[nums.length + 1];
            for (int num : nums) {
                to[num] = true;
            }
            for (int i = 0; i < to.length; i++) {
                if (!to[i]) {
                    return i;
                }
            }
            return -1;
        }
    }

    class Solution1 implements MissingNumber {
        @Override
        public int missingNumber(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return (nums.length + 1) * nums.length / 2 - sum;
        }
    }
}
