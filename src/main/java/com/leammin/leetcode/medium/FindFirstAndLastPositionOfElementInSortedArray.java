package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 
 * <p>给定一个按照升序排列的整数数组 <code>nums</code>，和一个目标值 <code>target</code>。找出给定目标值在数组中的开始位置和结束位置。</p>
 * 
 * <p>你的算法时间复杂度必须是&nbsp;<em>O</em>(log <em>n</em>) 级别。</p>
 * 
 * <p>如果数组中不存在目标值，返回&nbsp;<code>[-1, -1]</code>。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre><strong>输入:</strong> nums = [<code>5,7,7,8,8,10]</code>, target = 8
 * <strong>输出:</strong> [3,4]</pre>
 * 
 * <p><strong>示例&nbsp;2:</strong></p>
 * 
 * <pre><strong>输入:</strong> nums = [<code>5,7,7,8,8,10]</code>, target = 6
 * <strong>输出:</strong> [-1,-1]</pre>
 * 
 * 
 * @author Leammin
 * @date 2020-04-01
 */
public interface FindFirstAndLastPositionOfElementInSortedArray {
    int[] searchRange(int[] nums, int target);

    static Testsuite<FindFirstAndLastPositionOfElementInSortedArray> testsuite() {
        return Testsuite.<FindFirstAndLastPositionOfElementInSortedArray>builder()
                .add(ExpectedTestcase.of(t -> t.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8), new int[]{3, 4}))
                .add(ExpectedTestcase.of(t -> t.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6), new int[]{-1, -1}))
                .add(ExpectedTestcase.of(t -> t.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 5), new int[]{0, 0}))
                .build();
    }


    class Solution implements FindFirstAndLastPositionOfElementInSortedArray {

        @Override
        public int[] searchRange(int[] nums, int target) {
            int index = search(nums, target, 0, nums.length);
            int left = index;
            for (int t = index; t != -1; ) {
                left = t;
                t = search(nums, target, 0, t);
            }
            int right = index;
            for (int t = index; t != -1; ) {
                right = t;
                t = search(nums, target, t + 1, nums.length);
            }
            return new int[]{left, right};
        }

        private int search(int[] nums, int target, int start, int end) {
            while (start < end) {
                int mid = (start + end) / 2;
                if (nums[mid] > target) {
                    end = mid;
                } else if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            }
            return -1;
        }

    }
}

class FindFirstAndLastPositionOfElementInSortedArrayTest extends AbstractTest<FindFirstAndLastPositionOfElementInSortedArray> {
}
