package com.leammin.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;
import java.util.Arrays;

/**
 * 54. 螺旋矩阵
 *
 * <p>给定一个包含&nbsp;<em>m</em> x <em>n</em>&nbsp;个元素的矩阵（<em>m</em> 行, <em>n</em> 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * <strong>输出:</strong> [1,2,3,6,9,8,7,4,5]
 * </pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * <strong>输出:</strong> [1,2,3,4,8,12,11,10,9,5,6,7]
 * </pre>
 *
 * @author Leammin
 * @date 2020-06-05
 */
public interface SpiralMatrix {
    List<Integer> spiralOrder(int[][] matrix);

    static Testsuite<SpiralMatrix> testsuite() {
        return Testsuite.<SpiralMatrix>builder()
                .add(ExpectedTestcase.of(t -> t.spiralOrder(new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                }), Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5)))
                .add(ExpectedTestcase.of(t -> t.spiralOrder(new int[][]{
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12}
                }), Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)))
                .add(ExpectedTestcase.of(t -> t.spiralOrder(new int[][]{
                        {1, 2, 3, 4, 13},
                        {5, 6, 7, 8, 14},
                        {9, 10, 11, 12, 15}
                }), Arrays.asList(1, 2, 3, 4, 13, 14, 15, 12, 11, 10, 9, 5, 6, 7, 8)))
                .build();
    }


    class Solution implements SpiralMatrix {

        @Override
        public List<Integer> spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return Collections.emptyList();
            }
            List<Integer> res = new ArrayList<>(matrix.length * matrix[0].length);
            for (int offset = 0; offset < (matrix.length + 1) / 2 && offset < (matrix[0].length + 1) / 2; offset++) {
                int i = offset;
                int j = offset;
                if (offset == matrix.length - offset - 1) {
                    for (; j < matrix[0].length - offset; j++) {
                        res.add(matrix[i][j]);
                    }
                } else if (offset == matrix[0].length - offset - 1) {
                    for (; i < matrix.length - offset; i++) {
                        res.add(matrix[i][j]);
                    }
                } else {
                    for (; j < matrix[0].length - offset - 1; j++) {
                        res.add(matrix[i][j]);
                    }
                    for (; i < matrix.length - offset - 1; i++) {
                        res.add(matrix[i][j]);
                    }
                    for (; j > offset; j--) {
                        res.add(matrix[i][j]);
                    }
                    for (; i > offset; i--) {
                        res.add(matrix[i][j]);
                    }
                }
            }
            return res;
        }
    }
}

class SpiralMatrixTest extends AbstractTest<SpiralMatrix> {
}
