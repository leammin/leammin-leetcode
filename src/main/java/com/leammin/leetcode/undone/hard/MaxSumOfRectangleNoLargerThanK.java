package com.leammin.leetcode.undone.hard;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 363. 矩形区域不超过 K 的最大数值和
 * 
 * <p>给定一个非空二维矩阵&nbsp;<em>matrix&nbsp;</em>和一个整数<em> k</em>，找到这个矩阵内部不大于 <em>k</em> 的最大矩形和。</p>
 * 
 * <p><strong>示例:</strong></p>
 * 
 * <pre><strong>输入: </strong>matrix = [[1,0,1],[0,-2,3]], k = 2
 * <strong>输出: </strong>2 
 * <strong>解释:</strong>&nbsp;矩形区域&nbsp;<code>[[0, 1], [-2, 3]]</code>&nbsp;的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
 * </pre>
 * 
 * <p><strong>说明：</strong></p>
 * 
 * <ol>
 * 	<li>矩阵内的矩形区域面积必须大于 0。</li>
 * 	<li>如果行数远大于列数，你将如何解答呢？</li>
 * </ol>
 * 
 * 
 * @author Leammin
 * @date 2021-04-22
 */
public interface MaxSumOfRectangleNoLargerThanK {
    int maxSumSubmatrix(int[][] matrix, int k);

    static Testsuite<MaxSumOfRectangleNoLargerThanK> testsuite() {
        return Testsuite.<MaxSumOfRectangleNoLargerThanK>builder()
            .addExpected(t -> t.maxSumSubmatrix(new int[][]{{1,0,1},{0,-2,3}}, 2), 2)
            .addExpected(t -> t.maxSumSubmatrix(new int[][]{{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}}, 8), 8)
            .build();
    }


    class Solution implements MaxSumOfRectangleNoLargerThanK {

        @Override
        public int maxSumSubmatrix(int[][] matrix, int k) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] sum = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sum[i][j] = matrix[i][j] + get(sum, i - 1, j) + get(sum, i, j - 1) - get(sum, i - 1, j - 1);
                    if (matrix[i][j] == k || sum[i][j] == k) {
                        return k;
                    }
                }
            }
            int res  = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int x = 0; x <= i; x++) {
                        for (int y = 0; y <= j; y++) {
                            int range = sum[i][j] - get(sum, x-1, j) - get(sum, i, y - 1) + get(sum, x-1,y-1);
                            if (range == k) {
                                return k;
                            }
                            if (range <= k) {
                                res = Math.max(res, range);
                            }
                        }
                    }
                }
            }
            return res;
        }

        private int get(int[][] matrix, int i, int j) {
            return i >= 0 && i < matrix.length && j >= 0 && j < matrix[i].length ? matrix[i][j] : 0;
        }
    }
}

class MaxSumOfRectangleNoLargerThanKTest extends AbstractTest<MaxSumOfRectangleNoLargerThanK> {
}
