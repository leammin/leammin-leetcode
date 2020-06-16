package com.leammin.leetcode.medium;

/**
 * 153. 寻找旋转排序数组中的最小值
 * 
 * <p>假设按照升序排序的数组在预先未知的某个点上进行了旋转。</p>
 * 
 * <p>( 例如，数组&nbsp;<code>[0,1,2,4,5,6,7]</code> <strong> </strong>可能变为&nbsp;<code>[4,5,6,7,0,1,2]</code>&nbsp;)。</p>
 * 
 * <p>请找出其中最小的元素。</p>
 * 
 * <p>你可以假设数组中不存在重复元素。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre><strong>输入:</strong> [3,4,5,1,2]
 * <strong>输出:</strong> 1</pre>
 * 
 * <p><strong>示例 2:</strong></p>
 * 
 * <pre><strong>输入:</strong> [4,5,6,7,0,1,2]
 * <strong>输出:</strong> 0</pre>
 * 
 * 
 * @author Leammin
 * @date 2020-06-15
 */
public interface FindMinimumInRotatedSortedArray {
    int findMin(int[] nums);

    class Solution implements FindMinimumInRotatedSortedArray {

        @Override
        public int findMin(int[] nums) {
            if (nums[0] < nums[nums.length - 1]) {
                return nums[0];
            }
            int lo = 0;
            int hi = nums.length;
            while (lo < hi) {
                int mid = (lo + hi) >> 1;
                if (mid > 0 && nums[mid - 1] > nums[mid]) {
                    return nums[mid];
                }
                if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                    return nums[mid + 1];
                }
                if (nums[mid] > nums[0]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            return nums[lo];
        }
    }
}
