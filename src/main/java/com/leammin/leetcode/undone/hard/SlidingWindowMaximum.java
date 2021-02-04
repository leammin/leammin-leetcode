package com.leammin.leetcode.undone.hard;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 239. 滑动窗口最大值
 * 
 * <p>给定一个数组 <em>nums</em>，有一个大小为&nbsp;<em>k&nbsp;</em>的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 <em>k</em>&nbsp;个数字。滑动窗口每次只向右移动一位。</p>
 * 
 * <p>返回滑动窗口中的最大值。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例:</strong></p>
 * 
 * <pre><strong>输入:</strong> <em>nums</em> = <code>[1,3,-1,-3,5,3,6,7]</code>, 和 <em>k</em> = 3
 * <strong>输出: </strong><code>[3,3,5,5,6,7] 
 * <strong>解释: 
 * </strong></code>
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7</pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <p>你可以假设 <em>k </em>总是有效的，在输入数组不为空的情况下，1 &le; k &le;&nbsp;输入数组的大小。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>进阶：</strong></p>
 * 
 * <p>你能在线性时间复杂度内解决此题吗？</p>
 * 
 * 
 * @author Leammin
 * @date 2021-02-04
 */
public interface SlidingWindowMaximum {
    int[] maxSlidingWindow(int[] nums, int k);

    class Solution implements SlidingWindowMaximum {

        @Override
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (k == 1) {
                return nums;
            }
            int[] result = new int[nums.length - k + 1];
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.<Integer>naturalOrder().reversed());
            Map<Integer, Integer> delayRemove = new HashMap<>();
            for (int i = 0; i < k; i++) {
                maxHeap.add(nums[i]);
            }
            result[0] = maxHeap.peek();
            for (int i = k; i < nums.length; i++) {
                delayRemove.compute(nums[i - k], (key, oldValue) -> oldValue == null ? 1 : oldValue + 1);
                maxHeap.add(nums[i]);
                while (delayRemove.getOrDefault(maxHeap.peek(), 0) > 0) {
                    delayRemove.computeIfPresent(maxHeap.poll(), (key, oldValue) -> oldValue - 1);
                }
                result[i - k + 1] = maxHeap.peek();
            }
            return result;
        }
    }
}
