package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 59. 螺旋矩阵 II
 * 
 * <p>给定一个正整数&nbsp;<em>n</em>，生成一个包含 1 到&nbsp;<em>n</em><sup>2</sup>&nbsp;所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。</p>
 * 
 * <p><strong>示例:</strong></p>
 * 
 * <pre><strong>输入:</strong> 3
 * <strong>输出:</strong>
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]</pre>
 * 
 * 
 * @author Leammin
 * @date 2021-02-09
 */
public interface SpiralMatrixIi {
    int[][] generateMatrix(int n);

    static Testsuite<SpiralMatrixIi> testsuite() {
        return Testsuite.<SpiralMatrixIi>builder()
                .add(ExpectedTestcase.of(t -> t.generateMatrix(3), new int[][]{
                        {1, 2, 3},
                        {8, 9, 4},
                        {7, 6, 5}
                }))
                .add(ExpectedTestcase.of(t -> t.generateMatrix(1), new int[][]{
                        {1},
                }))
                .add(ExpectedTestcase.of(t -> t.generateMatrix(2), new int[][]{
                        {1, 2},
                        {4, 3},
                }))
                .build();
    }


    class Solution implements SpiralMatrixIi {

        @Override
        public int[][] generateMatrix(int n) {
            int[][] res = new int[n][n];
            int num = 1, k = 1;
            int i = 0, j = 0;
            while (k <= n / 2) {
                while (j < n - k) {
                    res[i][j++] = num++;
                }
                while (i < n - k) {
                    res[i++][j] = num++;
                }
                while (j >= k) {
                    res[i][j--] = num++;
                }
                while (i >= k) {
                    res[i--][j] = num++;
                }
                i++;
                j++;
                k++;
            }
            if ((n & 1) == 1) {
                res[i][j] = num;
            }
            return res;
        }
    }
}

class SpiralMatrixIiTest extends AbstractTest<SpiralMatrixIi> {
}
