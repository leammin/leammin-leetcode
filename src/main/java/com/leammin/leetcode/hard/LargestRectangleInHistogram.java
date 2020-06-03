package com.leammin.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 84. 柱状图中最大的矩形
 *
 * <p>给定 <em>n</em> 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。</p>
 *
 * <p>求在该柱状图中，能够勾勒出来的矩形的最大面积。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/histogram.png"></p>
 *
 * <p><small>以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为&nbsp;<code>[2,1,5,6,2,3]</code>。</small></p>
 *
 * <p>&nbsp;</p>
 *
 * <p><img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/histogram_area.png"></p>
 *
 * <p><small>图中阴影部分为所能勾勒出的最大矩形面积，其面积为&nbsp;<code>10</code>&nbsp;个单位。</small></p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong>输入:</strong> [2,1,5,6,2,3]
 * <strong>输出:</strong> 10</pre>
 *
 * @author Leammin
 * @date 2020-05-30
 */
public interface LargestRectangleInHistogram {
    int largestRectangleArea(int[] heights);

    /**
     * 时间复杂度 O(n²)   26%
     */
    class Solution implements LargestRectangleInHistogram {

        @Override
        public int largestRectangleArea(int[] heights) {
            int res = 0;
            for (int i = 0; i < heights.length; i++) {
                int left = i - 1;
                while (left >= 0 && heights[left] >= heights[i]) {
                    left--;
                }
                int right = i + 1;
                while (right < heights.length && heights[right] >= heights[i]) {
                    right++;
                }
                res = Math.max(res, (right - left - 1) * heights[i]);
            }
            return res;
        }
    }

    class Solution2 implements LargestRectangleInHistogram {

        @Override
        public int largestRectangleArea(int[] heights) {
            int[] length = new int[heights.length];
            Deque<Integer> stack = new ArrayDeque<>(heights.length);
            for (int i = 0; i <= heights.length; i++) {
                Integer top;
                while ((top = stack.peek()) != null && (i == heights.length ? 0 : heights[i]) < heights[top]) {
                    length[top] += i - top - 1;
                    stack.pop();
                }
                stack.push(i);
            }
            stack = new ArrayDeque<>(heights.length);
            for (int i = heights.length - 1; i >= -1; i--) {
                Integer top;
                while ((top = stack.peek()) != null && (i == -1 ? 0 : heights[i]) < heights[top]) {
                    length[top] += top - i - 1;
                    stack.pop();
                }
                stack.push(i);
            }
            int max = 0;
            for (int i = 0; i < length.length; i++) {
                max = Math.max(max, heights[i] * (length[i] + 1));
            }
            return max;
        }
    }

    class Solution3 implements LargestRectangleInHistogram {

        @Override
        public int largestRectangleArea(int[] heights) {
            int[] length = new int[heights.length];
            Deque<Integer> stack = new ArrayDeque<>(heights.length);
            for (int i = 0; i <= heights.length; i++) {
                while (!stack.isEmpty() && (i == heights.length ? 0 : heights[i]) < heights[stack.peek()]) {
                    int top = stack.pop();
                    if (i < heights.length) {
                        length[i] += length[top] + 1;
                    }
                    length[top] += i - top - 1;
                }
                stack.push(i);
            }
            int max = 0;
            for (int i = 0; i < length.length; i++) {
                max = Math.max(max, heights[i] * (length[i] + 1));
            }
            return max;
        }
    }
}
