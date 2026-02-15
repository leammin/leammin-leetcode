package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 41. 缺失的第一个正数
 *
 * <p>给定一个未排序的整数数组，找出其中没有出现的最小的正整数。</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre>输入: [1,2,0]
 * 输出: 3
 * </pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre>输入: [3,4,-1,1]
 * 输出: 2
 * </pre>
 *
 * <p><strong>示例&nbsp;3:</strong></p>
 *
 * <pre>输入: [7,8,9,11,12]
 * 输出: 1
 * </pre>
 *
 * <p><strong>说明:</strong></p>
 *
 * <p>你的算法的时间复杂度应为O(<em>n</em>)，并且只能使用常数级别的空间。</p>
 *
 * @author Leammin
 * @date 2020-06-27
 */
public interface FirstMissingPositive {
    int firstMissingPositive(int[] nums);

    static Testsuite<FirstMissingPositive> testsuite() {
        return Testsuite.<FirstMissingPositive>builder()
                .add(ExpectedTestcase.of(t -> t.firstMissingPositive(new int[]{1,2,0}), 3))
                .add(ExpectedTestcase.of(t -> t.firstMissingPositive(new int[]{1,2,3}), 4))
                .add(ExpectedTestcase.of(t -> t.firstMissingPositive(new int[]{1,2,4}), 3))
                .add(ExpectedTestcase.of(t -> t.firstMissingPositive(new int[]{3,4,-1,1}), 2))
                .add(ExpectedTestcase.of(t -> t.firstMissingPositive(new int[]{7,8,9,11,12}), 1))
                .add(ExpectedTestcase.of(t -> t.firstMissingPositive(new int[]{}), 1))
                .add(ExpectedTestcase.of(t -> t.firstMissingPositive(new int[]{1,1}), 2))
                .build();
    }


    class Solution implements FirstMissingPositive {

        @Override
        public int firstMissingPositive(int[] nums) {
            boolean hasN = false;
            for (int i = 0; i < nums.length; i++) {
                int v = nums[i];
                while (v >= 0 && v < nums.length && nums[v] != v) {
                    int tmp = nums[v];
                    nums[v] = v;
                    v = tmp;
                }
                if (v == nums.length) {
                    hasN = true;
                } else if (v == i) {
                    nums[i] = i;
                }
            }
            for (int i = 1; i < nums.length; i++) {
                if (i != nums[i]) {
                    return i;
                }
            }
            return hasN || nums.length == 0 ? nums.length + 1 : nums.length;
        }
    }
}

class FirstMissingPositiveTest extends AbstractTest<FirstMissingPositive> {
}
