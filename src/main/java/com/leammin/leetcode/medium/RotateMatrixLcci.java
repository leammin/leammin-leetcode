package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 面试题 01.07. 旋转矩阵
 * 
 * <p>给定一幅由N × N矩阵表示的图像，其中每个像素的大小为4字节，编写一种方法，将图像旋转90度。</p>
 * 
 * <p>不占用额外内存空间能否做到？</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre>给定 <strong>matrix</strong> = 
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 * 
 * <strong>原地</strong>旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * </pre>
 * 
 * <p><strong>示例 2:</strong></p>
 * 
 * <pre>给定 <strong>matrix</strong> =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ], 
 * 
 * <strong>原地</strong>旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2020-04-07
 */
public interface RotateMatrixLcci {
    void rotate(int[][] matrix);

    static Testsuite<RotateMatrixLcci> testsuite() {
        return Testsuite.<RotateMatrixLcci>builder()
                .add(ExpectedTestcase.of(t -> {
                    int[][] matrix = {
                            {1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}
                    };
                    t.rotate(matrix);
                    return matrix;
                }, new int[][]{
                        {7, 4, 1},
                        {8, 5, 2},
                        {9, 6, 3}
                }))
                .add(ExpectedTestcase.of(t -> {
                    int[][] matrix = {
                            {5, 1, 9, 11},
                            {2, 4, 8, 10},
                            {13, 3, 6, 7},
                            {15, 14, 12, 16}
                    };
                    t.rotate(matrix);
                    return matrix;
                }, new int[][]{
                        {15, 13, 2, 5},
                        {14, 3, 4, 1},
                        {12, 6, 8, 9},
                        {16, 7, 10, 11}
                }))
                .build();
    }


    class Solution implements RotateMatrixLcci {

        @Override
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n /2; i++) {
                for (int j = i; j < n - 1 - i; j++) {
                    int last = matrix[i][j];
                    for (int k = 0; k < 4; k++) {
                        int tmp = i;
                        i = j;
                        j = n - 1 - tmp;
                        tmp = matrix[i][j];
                        matrix[i][j] = last;
                        last = tmp;
                    }
                }
            }
        }
    }
}

class RotateMatrixLcciTest extends AbstractTest<RotateMatrixLcci> {
}
