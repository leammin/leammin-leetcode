package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 154. 寻找旋转排序数组中的最小值 II
 *
 * <p>假设按照升序排序的数组在预先未知的某个点上进行了旋转。</p>
 *
 * <p>( 例如，数组&nbsp;<code>[0,1,2,4,5,6,7]</code> <strong> </strong>可能变为&nbsp;<code>[4,5,6,7,0,1,2]</code>&nbsp;)。</p>
 *
 * <p>请找出其中最小的元素。</p>
 *
 * <p>注意数组中可能存在重复的元素。</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入:</strong> [1,3,5]
 * <strong>输出:</strong> 1</pre>
 *
 * <p><strong>示例&nbsp;2：</strong></p>
 *
 * <pre><strong>输入:</strong> [2,2,2,0,1]
 * <strong>输出:</strong> 0</pre>
 *
 * <p><strong>说明：</strong></p>
 *
 * <ul>
 * 	<li>这道题是&nbsp;<a href="https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/description/">寻找旋转排序数组中的最小值</a>&nbsp;的延伸题目。</li>
 * 	<li>允许重复会影响算法的时间复杂度吗？会如何影响，为什么？</li>
 * </ul>
 *
 * @author Leammin
 * @date 2020-06-18
 */
public interface FindMinimumInRotatedSortedArrayIi {
    int findMin(int[] nums);

    static Testsuite<FindMinimumInRotatedSortedArrayIi> testsuite() {
        return Testsuite.<FindMinimumInRotatedSortedArrayIi>builder()
                .add(ExpectedTestcase.of(t -> t.findMin(new int[]{1,3,5}), 1))
                .add(ExpectedTestcase.of(t -> t.findMin(new int[]{2,2,2,0,1}), 0))
                .add(ExpectedTestcase.of(t -> t.findMin(new int[]{2,2,2,2,2,2,2,0,1,2,2}), 0))
                .add(ExpectedTestcase.of(t -> t.findMin(new int[]{2,2,2,2,2,2,2,0,2,2,2}), 0))
                .add(ExpectedTestcase.of(t -> t.findMin(new int[]{2,2,0,1,2,2,2,2,2,2,2}), 0))
                .add(ExpectedTestcase.of(t -> t.findMin(new int[]{2,2,0,2,2,2,2,2,2,2,2}), 0))
                .add(ExpectedTestcase.of(t -> t.findMin(new int[]{2,2,2,2,2,2,2,2,2,2,2}), 2))
                .add(ExpectedTestcase.of(t -> t.findMin(new int[]{2,3,4,5,1}), 1))
                .add(ExpectedTestcase.of(t -> t.findMin(new int[]{1,2,0,0,1}), 0))
                .build();
    }


    class Solution implements FindMinimumInRotatedSortedArrayIi {

        @Override
        public int findMin(int[] nums) {
            if (nums.length == 1 || nums[0] < nums[nums.length - 1]) {
                return nums[0];
            }
            int lo = 0;
            int hi = nums.length - 1;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;

                if (nums[mid] > nums[mid + 1]) {
                    return nums[mid + 1];
                }
                if (nums[mid] > nums[lo] || nums[mid] > nums[hi]) {
                    lo = mid + 1;
                } else if (nums[mid] < nums[lo] || nums[mid] < nums[hi]) {
                    hi = mid;
                } else {
                    hi--;
                }
            }
            return nums[lo];
        }
    }
}

class FindMinimumInRotatedSortedArrayIiTest extends AbstractTest<FindMinimumInRotatedSortedArrayIi> {
}
