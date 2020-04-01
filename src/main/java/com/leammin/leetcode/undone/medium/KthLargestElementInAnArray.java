package com.leammin.leetcode.undone.medium;

import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 * 
 * <p>在未排序的数组中找到第 <strong>k</strong> 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre><strong>输入:</strong> <code>[3,2,1,5,6,4] 和</code> k = 2
 * <strong>输出:</strong> 5
 * </pre>
 * 
 * <p><strong>示例&nbsp;2:</strong></p>
 * 
 * <pre><strong>输入:</strong> <code>[3,2,3,1,2,4,5,5,6] 和</code> k = 4
 * <strong>输出:</strong> 4</pre>
 * 
 * <p><strong>说明: </strong></p>
 * 
 * <p>你可以假设 k 总是有效的，且 1 &le; k &le; 数组的长度。</p>
 * 
 * 
 * @author Leammin
 * @date 2020-03-31
 */
public interface KthLargestElementInAnArray {
    int findKthLargest(int[] nums, int k);

    class Solution implements KthLargestElementInAnArray {

        @Override
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(k);
            for (int i = 0; i < nums.length; i++) {
                queue.add(nums[i]);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
            return queue.peek();
        }
    }

    class Solution2 implements KthLargestElementInAnArray {

        @Override
        public int findKthLargest(int[] nums, int k) {
            return find(nums, nums.length - k, 0, nums.length);
        }

        private int find(int[] nums, int k, int start, int end) {
            int m = (start + end) / 2;
            int i = start;
            int j = end - 1;
            while (i < j) {
                while (i < m && nums[i] <= nums[m]) {
                    i++;
                }
                while (j > m && nums[j] >= nums[m]) {
                    j--;
                }
                if (i == j) {
                    break;
                }
                if (i == m) {
                    swap(nums, j, m);
                    m = j;
                } else if (j == m) {
                    swap(nums, i, m);
                    m = i;
                } else {
                    swap(nums, i, j);
                }
            }
            if (m == k) {
                return nums[m];
            } else if (m > k){
                return find(nums, k, start, m);
            } else {
                return find(nums, k, m + 1, end);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
