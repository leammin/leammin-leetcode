package com.leammin.leetcode.medium;

/**
 * 413. 等差数列划分
 *
 * <div><p>如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。</p>
 *
 * <p>例如，以下数列为等差数列:</p>
 *
 * <pre>1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9</pre>
 *
 * <p>以下数列不是等差数列。</p>
 *
 * <pre>1, 1, 2, 5, 7</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p>数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0&lt;=P&lt;Q&lt;N 。</p>
 *
 * <p>如果满足以下条件，则称子数组(P, Q)为等差数组：</p>
 *
 * <p>元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且&nbsp;P + 1 &lt; Q 。</p>
 *
 * <p>函数要返回数组 A 中所有为等差数组的子数组个数。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre>A = [1, 2, 3, 4]
 *
 * 返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。
 * </pre>
 * </div>
 *
 * @author Leammin
 * @date 2019-03-29
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] a) {
        if (a == null || a.length < 3) {
            return 0;
        }
        int result = 0;
        int startIndex = 0;
        for (int i = 2; i < a.length; i++) {
            if (a[i] - a[i - 1] != a[i - 1] - a[i - 2]) {
                int n = i - startIndex - 2;
                if (n > 0) {
                    result += n * (n + 1) / 2;
                }
                startIndex = i - 1;
            }
        }
        int n = a.length - startIndex - 2;
        if (n > 0) {
            result += n * (n + 1) / 2;
        }
        return result;
    }
}