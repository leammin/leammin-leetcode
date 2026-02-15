package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 33. 搜索旋转排序数组
 *
 * <p>假设按照升序排序的数组在预先未知的某个点上进行了旋转。</p>
 *
 * <p>( 例如，数组&nbsp;<code>[0,1,2,4,5,6,7]</code>&nbsp;可能变为&nbsp;<code>[4,5,6,7,0,1,2]</code>&nbsp;)。</p>
 *
 * <p>搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回&nbsp;<code>-1</code>&nbsp;。</p>
 *
 * <p>你可以假设数组中不存在重复的元素。</p>
 *
 * <p>你的算法时间复杂度必须是&nbsp;<em>O</em>(log&nbsp;<em>n</em>) 级别。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong> nums = [<code>4,5,6,7,0,1,2]</code>, target = 0
 * <strong>输出:</strong> 4
 * </pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入:</strong> nums = [<code>4,5,6,7,0,1,2]</code>, target = 3
 * <strong>输出:</strong> -1</pre>
 *
 * @author Leammin
 * @date 2020-04-03
 */
public interface SearchInRotatedSortedArray {
    int search(int[] nums, int target);

    static Testsuite<SearchInRotatedSortedArray> testsuite() {
        return Testsuite.<SearchInRotatedSortedArray>builder()
                .add(ExpectedTestcase.of(t->t.search(new int[]{4,5,6,7,0,1,2}, 0), 4))
                .add(ExpectedTestcase.of(t->t.search(new int[]{4,5,6,7,0,1,2}, 3), -1))
                .add(ExpectedTestcase.of(t->t.search(new int[]{1,3}, 3), 1))
                .build();
    }


    class Solution implements SearchInRotatedSortedArray {

        @Override
        public int search(int[] nums, int target) {
            return search(nums, target, 0, nums.length);
        }

        private int search(int[] nums, int target, int from, int to) {
            if (from >= to) {
                return -1;
            }
            int mid = (from + to) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[from] < target && target < nums[mid]) {
                return search(nums, target, from, mid);
            } else if (nums[mid] < target && target < nums[to - 1]) {
                return search(nums, target, mid + 1, to);
            } else {
                int t = search(nums, target, from, mid);
                return t == -1 ? search(nums, target, mid + 1, to) : t;
            }
        }
    }

    class Solution2 implements SearchInRotatedSortedArray {

        @Override
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if ((nums[left] <= target) ^ (target < nums[mid]) ^ (nums[left] <= nums[mid])) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }
}

class SearchInRotatedSortedArrayTest extends AbstractTest<SearchInRotatedSortedArray> {
}
