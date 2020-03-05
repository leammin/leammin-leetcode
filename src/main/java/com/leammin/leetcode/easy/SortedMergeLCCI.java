package com.leammin.leetcode.easy;

/**
 * 面试题 10.01. 合并排序的数组
 *
 * <p>给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。</p>
 *
 * <p>初始化&nbsp;A 和 B 的元素数量分别为&nbsp;<em>m</em> 和 <em>n</em>。</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 *
 * <strong>输出:</strong>&nbsp;[1,2,2,3,5,6]</pre>
 *
 * @author Leammin
 * @date 2020-03-03
 */
public interface SortedMergeLCCI {
    void merge(int[] a, int m, int[] b, int n);

    class Solution implements SortedMergeLCCI {
        @Override
        public void merge(int[] a, int m, int[] b, int n) {
            for (int i = a.length - 1, ai = m - 1, bi = n - 1; i >= 0; i--) {
                a[i] = ai >= 0 && (bi < 0 || a[ai] > b[bi]) ? a[ai--] : b[bi--];
            }
        }
    }
}
