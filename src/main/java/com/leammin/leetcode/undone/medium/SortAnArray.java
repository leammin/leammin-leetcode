package com.leammin.leetcode.undone.medium;

/**
 * 912. 排序数组
 * 
 * <p>给定一个整数数组&nbsp;<code>nums</code>，将该数组升序排列。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <ol>
 * </ol>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre>
 * <strong>输入：</strong>[5,2,3,1]
 * <strong>输出：</strong>[1,2,3,5]
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre>
 * <strong>输入：</strong>[5,1,1,2,0,0]
 * <strong>输出：</strong>[0,0,1,1,2,5]
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ol>
 * 	<li><code>1 &lt;= A.length &lt;= 10000</code></li>
 * 	<li><code>-50000 &lt;= A[i] &lt;= 50000</code></li>
 * </ol>
 * 
 * 
 * @author Leammin
 * @date 2020-03-31
 */
public interface SortAnArray {
    int[] sortArray(int[] nums);

    class Solution implements SortAnArray {

        @Override
        public int[] sortArray(int[] nums) {
            sort(nums, 0, nums.length);
            return nums;
        }

        private void sort(int[] nums, int start, int end) {
            if (start >= end) {
                return;
            }
            int k = (start + end) / 2;
            int i = start;
            int j = end - 1;
            while (i < j) {
                while (i < k && nums[i] <= nums[k]) {
                    i++;
                }
                while (j > k && nums[j] >= nums[k]) {
                    j--;
                }
                if (i == j) {
                    break;
                }
                if (i == k) {
                    swap(nums, k, j);
                    k = j;
                } else if (j == k) {
                    swap(nums, k, i);
                    k = i;
                } else {
                    swap(nums, i, j);
                }
            }
            sort(nums, start, k);
            sort(nums, k + 1, end);
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
