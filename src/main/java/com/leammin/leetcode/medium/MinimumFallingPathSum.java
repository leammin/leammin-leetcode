package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 931. 下降路径最小和
 *
 * <div><p>给定一个<strong>方形</strong>整数数组&nbsp;<code>A</code>，我们想要得到通过 <code>A</code> 的<em>下降路径</em>的<strong>最小</strong>和。</p>
 *
 * <p>下降路径可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例：</strong></p>
 *
 * <pre><strong>输入：</strong>[[1,2,3],[4,5,6],[7,8,9]]
 * <strong>输出：</strong>12
 * <strong>解释：</strong>
 * 可能的下降路径有：
 * </pre>
 *
 * <ul>
 * <li><code>[1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]</code></li>
 * <li><code>[2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]</code></li>
 * <li><code>[3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]</code></li>
 * </ul>
 *
 * <p>和最小的下降路径是&nbsp;<code>[1,4,7]</code>，所以答案是&nbsp;<code>12</code>。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ol>
 * <li><code>1 &lt;= A.length == A[0].length &lt;= 100</code></li>
 * <li><code>-100 &lt;= A[i][j] &lt;= 100</code></li>
 * </ol>
 * </div>
 *
 * @author leammin
 * @date 2019-05-03
 */
public interface MinimumFallingPathSum {
    int minFallingPathSum(int[][] a);

    static Testsuite<MinimumFallingPathSum> testsuite() {
        return Testsuite.<MinimumFallingPathSum>builder()
                .add(ExpectedTestcase.of(s -> s.minFallingPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}), 12))
                .add(ExpectedTestcase.of(s -> s.minFallingPathSum(new int[][]{{1, -2, 3}, {4, 5, 1}, {7, 1, 9}}), 0))
                .add(ExpectedTestcase.of(s -> s.minFallingPathSum(new int[][]{{1, -2, 3}, {4, 5, 6}, {7, 0, 9}}), 2))
                .build();
    }


    class Solution implements MinimumFallingPathSum {

        @Override
        public int minFallingPathSum(int[][] a) {
            int n = a.length;
            for (int i = n - 2; i >= 0; i--) {
                a[i][0] = Math.min(a[i + 1][0], a[i + 1][1]) + a[i][0];
                a[i][n - 1] = Math.min(a[i + 1][n - 1], a[i + 1][n - 2]) + a[i][n - 1];
                for (int j = 1; j < n - 1; j++) {
                    a[i][j] = a[i][j] + Math.min(Math.min(a[i + 1][j - 1], a[i + 1][j]), a[i + 1][j + 1]);
                }
            }
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (a[0][j] < min) {
                    min = a[0][j];
                }
            }
            return min;
        }
    }
}

class MinimumFallingPathSumTest extends AbstractTest<MinimumFallingPathSum> {
}
