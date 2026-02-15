package com.leammin.leetcode.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 128. 最长连续序列
 *
 * <p>给定一个未排序的整数数组，找出最长连续序列的长度。</p>
 *
 * <p>要求算法的时间复杂度为&nbsp;<em>O(n)</em>。</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong>输入:</strong>&nbsp;[100, 4, 200, 1, 3, 2]
 * <strong>输出:</strong> 4
 * <strong>解释:</strong> 最长连续序列是 <code>[1, 2, 3, 4]。它的长度为 4。</code></pre>
 *
 * @author Leammin
 * @date 2020-06-06
 */
public interface LongestConsecutiveSequence {
    int longestConsecutive(int[] nums);

    static Testsuite<LongestConsecutiveSequence> testsuite() {
        return Testsuite.<LongestConsecutiveSequence>builder()
                .add(ExpectedTestcase.of(t -> t.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}), 4))
                .add(ExpectedTestcase.of(t -> t.longestConsecutive(new int[]{1, 2, 0, 1}), 3))
                .add(ExpectedTestcase.of(t -> t.longestConsecutive(new int[]{-7, -1, 3, -9, -4, 7, -3, 2, 4, 9, 4, -9, 8, -7, 5, -1, -7}), 4))
                .build();
    }


    class Solution implements LongestConsecutiveSequence {

        @Override
        public int longestConsecutive(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            Arrays.sort(nums);
            int max = 1;
            for (int i = 1, count = 1, last = nums[0]; i < nums.length; i++) {
                count = nums[i] - last == 1 ? count + 1 : nums[i] == last ? count : 1;
                max = Math.max(max, count);
                last = nums[i];
            }
            return max;
        }
    }

    class Solution2 implements LongestConsecutiveSequence {

        @Override
        public int longestConsecutive(int[] nums) {
            Map<Integer, Range> left = new HashMap<>();
            Map<Integer, Range> right = new HashMap<>();
            for (int num : nums) {
                Range leftRange = left.remove(num + 1);
                Range rightRange = right.remove(num - 1);
                Range range;
                if (leftRange == null && rightRange == null) {
                    range = new Range(num, num);
                } else if (leftRange != null && rightRange != null) {
                    range = new Range(rightRange.left, leftRange.right);
                } else if (leftRange != null) {
                    range = new Range(num, leftRange.right);
                } else {
                    range = new Range(rightRange.left, num);
                }
                left.compute(range.left, (k, v) -> v == null || range.right > v.right ? range : v);
                right.compute(range.right, (k, v) -> v == null || range.left < v.left ? range : v);
            }
            int max = 0;
            for (Range range : left.values()) {
                max = Math.max(max, range.right - range.left + 1);
            }
            return max;
        }

        static class Range {
            int left;
            int right;

            public Range(int left, int right) {
                this.left = left;
                this.right = right;
            }
        }
    }
}

class LongestConsecutiveSequenceTest extends AbstractTest<LongestConsecutiveSequence> {
}
