package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 35. 搜索插入位置
 * 
 * <p>给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。</p>
 * 
 * <p>你可以假设数组中无重复元素。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre><strong>输入:</strong> [1,3,5,6], 5
 * <strong>输出:</strong> 2
 * </pre>
 * 
 * <p><strong>示例&nbsp;2:</strong></p>
 * 
 * <pre><strong>输入:</strong> [1,3,5,6], 2
 * <strong>输出:</strong> 1
 * </pre>
 * 
 * <p><strong>示例 3:</strong></p>
 * 
 * <pre><strong>输入:</strong> [1,3,5,6], 7
 * <strong>输出:</strong> 4
 * </pre>
 * 
 * <p><strong>示例 4:</strong></p>
 * 
 * <pre><strong>输入:</strong> [1,3,5,6], 0
 * <strong>输出:</strong> 0
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2020-06-12
 */
public interface SearchInsertPosition {
    int searchInsert(int[] nums, int target);

    static Testsuite<SearchInsertPosition> testsuite() {
        return Testsuite.<SearchInsertPosition>builder()
                .add(ExpectedTestcase.of(t -> t.searchInsert(new int[]{1, 3, 5, 6}, 5), 2))
                .add(ExpectedTestcase.of(t -> t.searchInsert(new int[]{1, 3, 5, 6}, 2), 1))
                .add(ExpectedTestcase.of(t -> t.searchInsert(new int[]{1, 3, 5, 6}, 7), 4))
                .add(ExpectedTestcase.of(t -> t.searchInsert(new int[]{1, 3, 5, 6}, 0), 0))
                .build();
    }


    class Solution implements SearchInsertPosition {

        @Override
        public int searchInsert(int[] nums, int target) {
            int lo = 0;
            int hi = nums.length;
            while (lo < hi) {
                int mid = (lo + hi) >> 1;
                if (nums[mid] > target) {
                    hi = mid;
                } else if (nums[mid] < target) {
                    lo = mid + 1;
                } else {
                    return mid;
                }
            }
            return lo;
        }
    }
}

class SearchInsertPositionTest extends AbstractTest<SearchInsertPosition> {
}
