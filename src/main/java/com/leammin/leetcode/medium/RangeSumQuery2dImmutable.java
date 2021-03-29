package com.leammin.leetcode.medium;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 * 
 * <p>给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (<em>row</em>1,&nbsp;<em>col</em>1) ，右下角为 (<em>row</em>2,&nbsp;<em>col</em>2)。</p>
 * 
 * <p><img alt="Range Sum Query 2D" src="https://assets.leetcode-cn.com/aliyun-lc-upload/images/304.png" style="width: 130px;"><br>
 * <small>上图子矩阵左上角&nbsp;(row1, col1) = <strong>(2, 1)</strong>&nbsp;，右下角(row2, col2) = <strong>(4, 3)，</strong>该子矩形内元素的总和为 8。</small></p>
 * 
 * <p><strong>示例:</strong></p>
 * 
 * <pre>给定 matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 * 
 * sumRegion(2, 1, 4, 3) -&gt; 8
 * sumRegion(1, 1, 2, 2) -&gt; 11
 * sumRegion(1, 2, 2, 4) -&gt; 12
 * </pre>
 * 
 * <p><strong>说明:</strong></p>
 * 
 * <ol>
 * 	<li>你可以假设矩阵不可变。</li>
 * 	<li>会多次调用&nbsp;<em>sumRegion&nbsp;</em>方法<em>。</em></li>
 * 	<li>你可以假设&nbsp;<em>row</em>1 &le; <em>row</em>2 且&nbsp;<em>col</em>1 &le; <em>col</em>2。</li>
 * </ol>
 * 
 * 
 * @author Leammin
 * @date 2021-03-02
 */
public abstract class RangeSumQuery2dImmutable {

    public RangeSumQuery2dImmutable(int[][] matrix) {

    }

    public abstract int sumRegion(int row1, int col1, int row2, int col2);

    public static class Solution extends RangeSumQuery2dImmutable {
        private int[][] sum;

        public Solution(int[][] matrix) {
            super(matrix);
            sum = matrix.length == 0 || matrix[0].length == 0 ? new int[0][0] : new int[matrix.length][matrix[0].length];
            for (int i = 0; i < sum.length; i++) {
                for (int j = 0; j < sum[i].length; j++) {
                    sum[i][j] = matrix[i][j] + getSum(i - 1, j) + getSum(i, j - 1) - getSum(i - 1, j - 1);
                }
            }
        }

        private int getSum(int i, int j) {
            return i < sum.length && i >= 0 && j < sum[i].length && j >= 0 ? sum[i][j] : 0;
        }

        @Override
        public int sumRegion(int row1, int col1, int row2, int col2) {
            return getSum(row2, col2) - getSum(row2, col1 - 1) - getSum(row1 - 1, col2) + getSum(row1 - 1, col1 - 1);
        }
    }
}
