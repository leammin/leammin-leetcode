package com.leammin.leetcode.undone.easy;

import java.util.Arrays;
import java.util.Random;

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
 * 
 * @author Leammin
 * @date 2020-03-20
 */
public interface ZuiXiaoDeKgeShuLcof {
    int[] getLeastNumbers(int[] arr, int k);

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

        }

        private void quick(int[] arr, int k, int start, int end) {
            int pos = random(start, end);

        }

        private void swap(int[] arr, int a, int b) {
            int tmp = arr[a];
            arr[a] = arr[b];
            arr[b] = tmp;
        }

        private int random(int start, int end) {
            return new Random().nextInt(end - start) + start;
        }
    }
}
