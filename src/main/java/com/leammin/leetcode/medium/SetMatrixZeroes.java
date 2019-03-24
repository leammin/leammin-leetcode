package com.leammin.leetcode.medium;

/**
 * 73. 矩阵置零
 * 
 * <div><p>给定一个&nbsp;<em>m</em> x <em>n</em> 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用<strong><a href="http://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank">原地</a></strong>算法<strong>。</strong></p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre><strong>输入:</strong> 
 * [
 * &nbsp; [1,1,1],
 * &nbsp; [1,0,1],
 * &nbsp; [1,1,1]
 * ]
 * <strong>输出:</strong> 
 * [
 * &nbsp; [1,0,1],
 * &nbsp; [0,0,0],
 * &nbsp; [1,0,1]
 * ]
 * </pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入:</strong> 
 * [
 * &nbsp; [0,1,2,0],
 * &nbsp; [3,4,5,2],
 * &nbsp; [1,3,1,5]
 * ]
 * <strong>输出:</strong> 
 * [
 * &nbsp; [0,0,0,0],
 * &nbsp; [0,4,5,0],
 * &nbsp; [0,3,1,0]
 * ]</pre>
 *
 * <p><strong>进阶:</strong></p>
 *
 * <ul>
 * 	<li>一个直接的解决方案是使用 &nbsp;O(<em>m</em><em>n</em>)&nbsp;的额外空间，但这并不是一个好的解决方案。</li>
 * 	<li>一个简单的改进方案是使用 O(<em>m</em>&nbsp;+&nbsp;<em>n</em>) 的额外空间，但这仍然不是最好的解决方案。</li>
 * 	<li>你能想出一个常数空间的解决方案吗？</li>
 * </ul>
 * </div>
 * 
 * @author Leammin
 * @date 2018-11-04
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < row.length; i++) {
            if (row[i]) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < col.length; j++) {
            if (col[j]) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

    }
}
