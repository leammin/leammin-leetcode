package com.leammin.leetcode.undone.hard;

import java.util.Arrays;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 480. 滑动窗口中位数
 * 
 * <p>中位数是有序序列最中间的那个数。如果序列的大小是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。</p>
 * 
 * <p>例如：</p>
 * 
 * <p><code>[2,3,4]</code>，中位数是&nbsp;<code>3</code></p>
 * 
 * <p><code>[2,3]</code>，中位数是 <code>(2 + 3) / 2 = 2.5</code></p>
 * 
 * <p>给出一个数组 nums，有一个大小为 <em>k</em> 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。</p>
 * 
 * <p>例如：</p>
 * 
 * <p>给出&nbsp;<em>nums</em> = <code>[1,3,-1,-3,5,3,6,7]</code>，以及&nbsp;<em>k</em> = 3。</p>
 * 
 * <pre>
 * 窗口位置                      中位数
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 *  1 [3  -1  -3] 5  3  6  7       -1
 *  1  3 [-1  -3  5] 3  6  7       -1
 *  1  3  -1 [-3  5  3] 6  7       3
 *  1  3  -1  -3 [5  3  6] 7       5
 *  1  3  -1  -3  5 [3  6  7]      6
 * </pre>
 * 
 * <p>&nbsp;因此，返回该滑动窗口的中位数数组&nbsp;<code>[1,-1,-1,3,5,6]</code>。</p>
 * 
 * <p><strong>提示：</strong><br />
 * 假设<code>k</code>是合法的，即：<code>k</code> 始终小于输入的非空数组的元素个数.</p>
 * 
 * 
 * @author Leammin
 * @date 2021-02-03
 */
public interface SlidingWindowMedian {
    double[] medianSlidingWindow(int[] nums, int k);

    /**
     * O(n*k) 有更优 O(n*logn)
     */

    static Testsuite<SlidingWindowMedian> testsuite() {
        return Testsuite.<SlidingWindowMedian>builder()
                .add(ExpectedTestcase.of(t -> t.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3), new double[]{1, -1, -1, 3, 5, 6}))
                .add(ExpectedTestcase.of(t -> t.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 1), new double[]{1, 3, -1, -3, 5, 3, 6, 7}))
                .add(ExpectedTestcase.of(t -> t.medianSlidingWindow(new int[]{2147483647, 2147483647}, 2), new double[]{2147483647.0}))
                .build();
    }

    class Solution implements SlidingWindowMedian {

        @Override
        public double[] medianSlidingWindow(int[] nums, int k) {
            double[] result = new double[nums.length - k + 1];
            int[] sub = Arrays.copyOf(nums, k);
            Arrays.sort(sub);
            result[0] = median(sub);
            for (int i = k; i < nums.length; i++) {
                replace(sub, nums[i - k], nums[i]);
                result[i - k + 1] = median(sub);
            }
            return result;
        }

        public void replace(int[] a, int oldValue, int newValue) {
            if (oldValue == newValue) {
                return;
            }
            int oldIndex = Arrays.binarySearch(a, oldValue);
            int newIndex = Arrays.binarySearch(a, newValue);
            if (newIndex < 0) {
                newIndex = -newIndex - 1;
            }
            if (newIndex == oldIndex || newIndex - oldIndex == 1) {
                a[oldIndex] = newValue;
            } else if (newIndex > oldIndex) {
                System.arraycopy(a, oldIndex + 1, a, oldIndex, newIndex - 1 - oldIndex);
                a[newIndex - 1] = newValue;
            } else {
                System.arraycopy(a, newIndex, a, newIndex + 1, oldIndex - newIndex);
                a[newIndex] = newValue;
            }
        }

        public double median(int[] a) {
            if (a.length % 2 == 0) {
                return a[a.length / 2] / 2.0 + a[a.length / 2 - 1] / 2.0;
            } else {
                return a[a.length / 2];
            }
        }
    }
}

class SlidingWindowMedianTest extends AbstractTest<SlidingWindowMedian> {
}
