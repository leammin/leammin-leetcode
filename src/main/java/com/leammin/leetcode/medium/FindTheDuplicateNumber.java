package com.leammin.leetcode.medium;

import java.util.BitSet;

/**
 * 287. 寻找重复数
 *
 * <p>给定一个包含&nbsp;<em>n</em> + 1 个整数的数组&nbsp;<em>nums</em>，其数字都在 1 到 <em>n&nbsp;</em>之间（包括 1 和 <em>n</em>），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong> <code>[1,3,4,2,2]</code>
 * <strong>输出:</strong> 2
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入:</strong> [3,1,3,4,2]
 * <strong>输出:</strong> 3
 * </pre>
 *
 * <p><strong>说明：</strong></p>
 *
 * <ol>
 * 	<li><strong>不能</strong>更改原数组（假设数组是只读的）。</li>
 * 	<li>只能使用额外的 <em>O</em>(1) 的空间。</li>
 * 	<li>时间复杂度小于 <em>O</em>(<em>n</em><sup>2</sup>) 。</li>
 * 	<li>数组中只有一个重复的数字，但它可能不止重复出现一次。</li>
 * </ol>
 *
 * @author Leammin
 * @date 2020-05-31
 */
public interface FindTheDuplicateNumber {
    int findDuplicate(int[] nums);

    class Solution implements FindTheDuplicateNumber {

        @Override
        public int findDuplicate(int[] nums) {
            BitSet bitSet = new BitSet(nums.length);
            for (int num : nums) {
                if (bitSet.get(num)) {
                    return num;
                }
                bitSet.set(num);
            }
            return 0;
        }
    }

    class Best implements FindTheDuplicateNumber {

        @Override
        public int findDuplicate(int[] nums) {
            int slow = 0, fast = 0;
            do {
                slow = nums[slow];
                fast = nums[nums[fast]];
            } while (slow != fast);
            fast = 0;
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return fast;
        }
    }
}
