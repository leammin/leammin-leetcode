package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * <a href="https://leetcode.cn/problems/shortest-subarray-to-be-removed-to-make-array-sorted/">1574. 删除最短的子数组使剩余数组有序</a>
 *
 * <p>给你一个整数数组 <code>arr</code>&nbsp;，请你删除一个子数组（可以为空），使得 <code>arr</code>&nbsp;中剩下的元素是 <strong>非递减</strong> 的。</p>
 *
 * <p>一个子数组指的是原数组中连续的一个子序列。</p>
 *
 * <p>请你返回满足题目要求的最短子数组的长度。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>arr = [1,2,3,10,4,2,3,5]
 * <strong>输出：</strong>3
 * <strong>解释：</strong>我们需要删除的最短子数组是 [10,4,2] ，长度为 3 。剩余元素形成非递减数组 [1,2,3,3,5] 。
 * 另一个正确的解为删除子数组 [3,10,4] 。</pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>arr = [5,4,3,2,1]
 * <strong>输出：</strong>4
 * <strong>解释：</strong>由于数组是严格递减的，我们只能保留一个元素。所以我们需要删除长度为 4 的子数组，要么删除 [5,4,3,2]，要么删除 [4,3,2,1]。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>arr = [1,2,3]
 * <strong>输出：</strong>0
 * <strong>解释：</strong>数组已经是非递减的了，我们不需要删除任何元素。
 * </pre>
 *
 * <p><strong>示例 4：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>arr = [1]
 * <strong>输出：</strong>0
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= arr.length &lt;= 10^5</code></li>
 * 	<li><code>0 &lt;= arr[i] &lt;= 10^9</code></li>
 * </ul>
 *
 * @author Leammin
 * @date 2023-03-25
 */
public interface ShortestSubarrayToBeRemovedToMakeArraySorted {
    int findLengthOfShortestSubarray(int[] arr);

    static Testsuite<ShortestSubarrayToBeRemovedToMakeArraySorted> testsuite() {
        return Testsuite.<ShortestSubarrayToBeRemovedToMakeArraySorted>builder()
                .addExpected(t -> t.findLengthOfShortestSubarray(new int[]{1, 2, 3, 10, 4, 2, 3, 5}), 3)
                .addExpected(t -> t.findLengthOfShortestSubarray(new int[]{5, 4, 3, 2, 1}), 4)
                .addExpected(t -> t.findLengthOfShortestSubarray(new int[]{1, 2, 3}), 0)
                .addExpected(t -> t.findLengthOfShortestSubarray(new int[]{1}), 0)
                .addExpected(t -> t.findLengthOfShortestSubarray(new int[]{2,2,2,1,1,1}), 3)
                .build();
    }

    //    @Execute(cases = 1)
    class Solution implements ShortestSubarrayToBeRemovedToMakeArraySorted {

        @Override
        public int findLengthOfShortestSubarray(int[] arr) {
            int t = arr.length - 1;
            while (t > 0 && arr[t - 1] <= arr[t]) {
                t--;
            }
            if (t == 0) {
                return 0;
            }
            int res = t;
            for (int l = 0, r = t; l < t; l++) {
                r = binarySearch(arr, r, arr.length, arr[l]);
                res = Math.min(res, r - l - 1);
                if (arr[l] > arr[l + 1]) {
                    break;
                }
            }
            return res;
        }

        private int binarySearch(int[] arr, int from, int to, int target) {
            if (from >= to || target > arr[to - 1]) {
                return to;
            }
            if (target <= arr[from]) {
                return from;
            }
            int l = from;
            int r = to;
            while (l < r) {
                int mid = (l + r) / 2;
                if (arr[mid] > target) {
                    r = mid;
                } else if (arr[mid] == target) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }

        public static void main(String[] args) {
            System.out.println(new Solution().binarySearch(new int[]{1, 1, 3, 5, 5, 5, 7, 9, 9}, 0, 9, 0));
            System.out.println(new Solution().binarySearch(new int[]{1, 1, 3, 5, 5, 5, 7, 9, 9}, 0, 9, 1));
            System.out.println(new Solution().binarySearch(new int[]{1, 1, 3, 5, 5, 5, 7, 9, 9}, 0, 9, 4));
            System.out.println(new Solution().binarySearch(new int[]{1, 1, 3, 5, 5, 5, 7, 9, 9}, 0, 9, 5));
            System.out.println(new Solution().binarySearch(new int[]{1, 1, 3, 5, 5, 5, 7, 9, 9}, 0, 9, 9));
            System.out.println(new Solution().binarySearch(new int[]{1, 1, 3, 5, 5, 5, 7, 9, 9}, 0, 9, 10));
        }

    }
}

class ShortestSubarrayToBeRemovedToMakeArraySortedTest extends AbstractTest<ShortestSubarrayToBeRemovedToMakeArraySorted> {
}
