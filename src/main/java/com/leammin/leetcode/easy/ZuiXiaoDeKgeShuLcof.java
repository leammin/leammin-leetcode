package com.leammin.leetcode.easy;

import java.util.Arrays;
import java.util.Random;
import com.google.common.primitives.Ints;
import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;
import com.leammin.leetcode.util.test.VerifiableTestcase;
import org.assertj.core.api.Assertions;

/**
 * 面试题40. 最小的k个数
 *
 * <p>输入整数数组 <code>arr</code> ，找出其中最小的 <code>k</code> 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>arr = [3,2,1], k = 2
 * <strong>输出：</strong>[1,2] 或者 [2,1]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>arr = [0,1,2,1], k = 1
 * <strong>输出：</strong>[0]</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>限制：</strong></p>
 *
 * <ul>
 * 	<li><code>0 &lt;= k &lt;= arr.length &lt;= 10000</code></li>
 * 	<li><code>0 &lt;= arr[i]&nbsp;&lt;= 10000</code></li>
 * </ul>
 *
 * @author Leammin
 * @date 2020-03-20
 */
public interface ZuiXiaoDeKgeShuLcof {
    int[] getLeastNumbers(int[] arr, int k);

    static Testsuite<ZuiXiaoDeKgeShuLcof> testsuite() {
        return Testsuite.<ZuiXiaoDeKgeShuLcof>builder()
                .add(VerifiableTestcase.ofConsumer(t -> t.getLeastNumbers(new int[]{3, 2, 1}, 2), res -> Assertions.assertThat(Ints.asList(res)).containsExactlyInAnyOrder(1, 2)
                ))
                .add(VerifiableTestcase.ofConsumer(t -> t.getLeastNumbers(new int[]{0, 1, 2, 1}, 1), res -> Assertions.assertThat(Ints.asList(res)).containsExactlyInAnyOrder(0)
                ))
                .add(VerifiableTestcase.ofConsumer(t -> t.getLeastNumbers(new int[]{0, 1, 2, 1}, 3), res -> Assertions.assertThat(Ints.asList(res)).containsExactlyInAnyOrder(0, 1, 1)
                ))
                .add(VerifiableTestcase.ofConsumer(t -> t.getLeastNumbers(new int[]{0, 0, 0, 2, 0, 5}, 0), res -> Assertions.assertThat(Ints.asList(res)).containsExactlyInAnyOrder()
                ))
                .add(VerifiableTestcase.ofConsumer(t -> t.getLeastNumbers(new int[]{0, 0, 1, 2, 4, 2, 2, 3, 1, 4}, 8), res -> Assertions.assertThat(Ints.asList(res)).containsExactlyInAnyOrder(0, 0, 1, 1, 2, 2, 2, 3)
                ))
                .add(VerifiableTestcase.ofConsumer(t -> t.getLeastNumbers(new int[]{3, 2, 1}, 2), res -> Assertions.assertThat(Ints.asList(res)).containsExactlyInAnyOrder(1, 2)
                ))
                .build();
    }


    class Solution implements ZuiXiaoDeKgeShuLcof {

        @Override
        public int[] getLeastNumbers(int[] arr, int k) {
            Arrays.sort(arr);
            return Arrays.copyOf(arr, k);
        }
    }

    class Solution2 implements ZuiXiaoDeKgeShuLcof {

        @Override
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k == 0) {
                return new int[0];
            }
            if (k >= arr.length) {
                return arr;
            }
            quick(arr, k, 0, arr.length);
            return Arrays.copyOf(arr, k);
        }

        private void quick(int[] arr, int k, int start, int end) {
            int pos = random(start, end);
            int low = start;
            int high = end - 1;
            while (low < high) {
                while (low < pos && arr[low] <= arr[pos]) {
                    low++;
                }
                while (high > pos && arr[high] > arr[pos]) {
                    high--;
                }
                if (low != high && (low == pos || high == pos)) {
                    int newPos = (low + high) / 2 + (high - 1 == pos ? 1 : 0);
                    swap(arr, pos, newPos);
                    pos = newPos;
                } else {
                    swap(arr, low, high);
                }
            }
            if (pos < k) {
                quick(arr, k, pos + 1, end);
            }
            if (pos > k) {
                quick(arr, k, start, pos);
            }
        }

        private void swap(int[] arr, int a, int b) {
            if (a != b) {
                int tmp = arr[a];
                arr[a] = arr[b];
                arr[b] = tmp;
            }
        }

        private int random(int start, int end) {
            return new Random().nextInt(end - start) + start;
        }
    }
}

class ZuiXiaoDeKgeShuLcofTest extends AbstractTest<ZuiXiaoDeKgeShuLcof> {
}
