package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.Execute;
import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/longest-consecutive-sequence/">128. 最长连续序列</a>
 * 
 * <p>给定一个未排序的整数数组 <code>nums</code> ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。</p>
 * 
 * <p>请你设计并实现时间复杂度为 <code>O(n)</code><em> </em>的算法解决此问题。</p>
 * 
 * <p> </p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre>
 * <strong>输入：</strong>nums = [100,4,200,1,3,2]
 * <strong>输出：</strong>4
 * <strong>解释：</strong>最长数字连续序列是 <code>[1, 2, 3, 4]。它的长度为 4。</code></pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre>
 * <strong>输入：</strong>nums = [0,3,7,2,5,8,4,6,0,1]
 * <strong>输出：</strong>9
 * </pre>
 * 
 * <p> </p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ul>
 * 	<li><code>0 <= nums.length <= 10<sup>5</sup></code></li>
 * 	<li><code>-10<sup>9</sup> <= nums[i] <= 10<sup>9</sup></code></li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2026-03-01
 */
public interface LongestConsecutiveSequence {
    int longestConsecutive(int[] nums);

    static Testsuite<LongestConsecutiveSequence> testsuite() {
        return Testsuite.<LongestConsecutiveSequence>builder()
                .add(ExpectedTestcase.of(t -> t.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}), 4))
                .add(ExpectedTestcase.of(t -> t.longestConsecutive(new int[]{1, 2, 0, 1}), 3))
                // -9 -7 -4 -3 -1 2 3 4 5 7 8 9
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
            Map<Integer, Solution2.Range> left = new HashMap<>();
            Map<Integer, Solution2.Range> right = new HashMap<>();
            for (int num : nums) {
                Solution2.Range leftRange = left.remove(num + 1);
                Solution2.Range rightRange = right.remove(num - 1);
                Solution2.Range range;
                if (leftRange == null && rightRange == null) {
                    range = new Solution2.Range(num, num);
                } else if (leftRange != null && rightRange != null) {
                    range = new Solution2.Range(rightRange.left, leftRange.right);
                } else if (leftRange != null) {
                    range = new Solution2.Range(num, leftRange.right);
                } else {
                    range = new Solution2.Range(rightRange.left, num);
                }
                left.compute(range.left, (k, v) -> v == null || range.right > v.right ? range : v);
                right.compute(range.right, (k, v) -> v == null || range.left < v.left ? range : v);
            }
            int max = 0;
            for (Solution2.Range range : left.values()) {
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

    class Solution3 implements LongestConsecutiveSequence {

        @Override
        public int longestConsecutive(int[] nums) {
            Set<Integer> seen = HashSet.newHashSet(nums.length);
            //range[left, right]
            Map<Integer, Integer> leftMap = HashMap.newHashMap(nums.length); // left -> right
            Map<Integer, Integer> rightMap = HashMap.newHashMap(nums.length); // right -> left
            int res = 0;
            for (int num : nums) {
                if (!seen.add(num)) {
                    continue;
                }
                Integer right = leftMap.remove(num + 1);
                Integer left = rightMap.remove(num - 1);
                if (right == null) {
                    right = num;
                }
                if (left == null) {
                    left = num;
                }
                leftMap.put(left, right);
                rightMap.put(right, left);

                res = Math.max(res, right - left + 1);
            }
            return res;
        }
    }
}

class LongestConsecutiveSequenceTest extends AbstractTest<LongestConsecutiveSequence> {
}
