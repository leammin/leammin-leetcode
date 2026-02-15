package com.leammin.leetcode.undone.hard;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 面试题51. 数组中的逆序对
 *
 * <p>在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入</strong>: [7,5,6,4]
 * <strong>输出</strong>: 5</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>限制：</strong></p>
 *
 * <p><code>0 &lt;= 数组长度 &lt;= 50000</code></p>
 *
 * @author Leammin
 * @date 2020-05-28
 */
public interface ShuZuZhongDeNiXuDuiLcof {
    int reversePairs(int[] nums);

    static Testsuite<ShuZuZhongDeNiXuDuiLcof> testsuite() {
        return Testsuite.<ShuZuZhongDeNiXuDuiLcof>builder()
                .add(ExpectedTestcase.of(t -> t.reversePairs(new int[]{7,5,6,4}), 5))
                .build();
    }


    class Solution implements ShuZuZhongDeNiXuDuiLcof {

        @Override
        public int reversePairs(int[] nums) {
            int[] sorted = new int[nums.length];
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                int search = binarySearch(sorted, 0, i, nums[i]);
                res += i - search;
                System.arraycopy(sorted, search, sorted, search + 1, i - search);
                sorted[search] = nums[i];
            }
            return res;
        }

        private static int binarySearch(int[] a, int fromIndex, int toIndex,
                                         int key) {
            int low = fromIndex;
            int high = toIndex - 1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (a[mid] <= key)
                    low = mid + 1;
                else {
                    high = mid - 1;
                }
            }
            return low;
        }
    }
}

class ShuZuZhongDeNiXuDuiLcofTest extends AbstractTest<ShuZuZhongDeNiXuDuiLcof> {
}
