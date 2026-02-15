package com.leammin.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 658. 找到 K 个最接近的元素
 * 
 * <p>给定一个排序好的数组，两个整数 <code>k</code> 和 <code>x</code>，从数组中找到最靠近 <code>x</code>（两数之差最小）的 <code>k</code> 个数。返回的结果必须要是按升序排好的。如果有两个数与 <code>x</code> 的差值一样，优先选择数值较小的那个数。</p>
 * 
 * <p><strong>示例&nbsp;1:</strong></p>
 * 
 * <pre>
 * <strong>输入:</strong> [1,2,3,4,5], k=4, x=3
 * <strong>输出:</strong> [1,2,3,4]
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 2:</strong></p>
 * 
 * <pre>
 * <strong>输入:</strong> [1,2,3,4,5], k=4, x=-1
 * <strong>输出:</strong> [1,2,3,4]
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>说明:</strong></p>
 * 
 * <ol>
 * 	<li>k 的值为正数，且总是小于给定排序数组的长度。</li>
 * 	<li>数组不为空，且长度不超过 10<sup>4</sup></li>
 * 	<li>数组里的每个元素与&nbsp;x 的绝对值不超过 10<sup>4</sup></li>
 * </ol>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>更新(2017/9/19):</strong><br />
 * 这个参数 <em>arr</em> 已经被改变为一个<strong>整数数组</strong>（而不是整数列表）。<strong><em>&nbsp;请重新加载代码定义以获取最新更改。</em></strong></p>
 * 
 * 
 * @author Leammin
 * @date 2020-06-18
 */
public interface FindKClosestElements {
    List<Integer> findClosestElements(int[] arr, int k, int x);

    static Testsuite<FindKClosestElements> testsuite() {
        return Testsuite.<FindKClosestElements>builder()
                .add(ExpectedTestcase.of(t -> t.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3), List.of(1, 2, 3, 4)))
                .add(ExpectedTestcase.of(t -> t.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1), List.of(1, 2, 3, 4)))
                .add(ExpectedTestcase.of(t -> t.findClosestElements(new int[]{1,2,5,6}, 1, 4), List.of(5)))
                .add(ExpectedTestcase.of(t -> t.findClosestElements(new int[]{1,2,5,6}, 1, 3), List.of(2)))
                .build();
    }


    class Solution implements FindKClosestElements {

        @Override
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int index = bs(arr, x);
            int left = index;
            int right = index;
            while (right - left < k) {
                if (left <= 0 && right >= arr.length) {
                    break;
                }
                if (left <= 0) {
                    right++;
                } else if (right >= arr.length) {
                    left--;
                } else if (Math.abs(arr[left - 1] - x) > Math.abs(arr[right] - x)) {
                    right++;
                } else {
                    left--;
                }
            }
            ArrayList<Integer> list = new ArrayList<>(right - left);
            for (int i = left; i < right; i++) {
                list.add(arr[i]);
            }
            return list;
        }

        private int bs(int[] arr, int target) {
            int lo = 0;
            int hi = arr.length - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (arr[mid] < target) {
                    lo = mid + 1;
                } else if (arr[mid] > target) {
                    hi = mid - 1;
                } else {
                    return mid;
                }
            }
            return lo;
        }
    }
}

class FindKClosestElementsTest extends AbstractTest<FindKClosestElements> {
}
