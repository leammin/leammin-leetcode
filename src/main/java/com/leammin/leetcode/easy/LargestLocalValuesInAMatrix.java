package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.convert.IntMatrixConverter;
import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 2373. 矩阵中的局部最大值
 * 
 * <p>给你一个大小为 <code>n x n</code> 的整数矩阵 <code>grid</code> 。</p>
 * 
 * <p>生成一个大小为&nbsp;<code>(n - 2) x (n - 2)</code> 的整数矩阵&nbsp; <code>maxLocal</code> ，并满足：</p>
 * 
 * <ul>
 * 	<li><code>maxLocal[i][j]</code> 等于 <code>grid</code> 中以 <code>i + 1</code> 行和 <code>j + 1</code> 列为中心的 <code>3 x 3</code> 矩阵中的 <strong>最大值</strong> 。</li>
 * </ul>
 * 
 * <p>换句话说，我们希望找出 <code>grid</code> 中每个&nbsp;<code>3 x 3</code> 矩阵中的最大值。</p>
 * 
 * <p>返回生成的矩阵。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2022/06/21/ex1.png" style="width: 371px; height: 210px;" /></p>
 * 
 * <pre>
 * <strong>输入：</strong>grid = [[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]
 * <strong>输出：</strong>[[9,9],[8,6]]
 * <strong>解释：</strong>原矩阵和生成的矩阵如上图所示。
 * 注意，生成的矩阵中，每个值都对应 grid 中一个相接的 3 x 3 矩阵的最大值。</pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2022/07/02/ex2new2.png" style="width: 436px; height: 240px;" /></p>
 * 
 * <pre>
 * <strong>输入：</strong>grid = [[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]
 * <strong>输出：</strong>[[2,2,2],[2,2,2],[2,2,2]]
 * <strong>解释：</strong>注意，2 包含在 grid 中每个 3 x 3 的矩阵中。
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ul>
 * 	<li><code>n == grid.length == grid[i].length</code></li>
 * 	<li><code>3 &lt;= n &lt;= 100</code></li>
 * 	<li><code>1 &lt;= grid[i][j] &lt;= 100</code></li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2023-03-01
 */
public interface LargestLocalValuesInAMatrix {
    int[][] largestLocal(int[][] grid);
    static Testsuite<LargestLocalValuesInAMatrix> testsuite() {
        return Testsuite.<LargestLocalValuesInAMatrix>builder()
                .addExpected(t -> t.largestLocal(new IntMatrixConverter().convert("[[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]")),
                        new IntMatrixConverter().convert("[[9,9],[8,6]]"))
                .addExpected(t -> t.largestLocal(new IntMatrixConverter().convert("[[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]")),
                        new IntMatrixConverter().convert("[[2,2,2],[2,2,2],[2,2,2]]"))
                .build();
    }

    class Solution implements LargestLocalValuesInAMatrix {

        @Override
        public int[][] largestLocal(int[][] grid) {
            int n = grid.length;
            int[][] res = new int[n - 2][n - 2];
            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    int max = 0;
                    for (int k = i - 1; k <= i + 1; k++) {
                        for (int l = j - 1; l <= j + 1; l++) {
                            max = Math.max(max, grid[k][l]);
                        }
                    }
                    res[i - 1][j - 1] = max;
                }
            }
            return res;
        }
    }
}

class LargestLocalValuesInAMatrixTest extends AbstractTest<LargestLocalValuesInAMatrix> {
}
