package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 892. 三维形体的表面积
 *
 * <p>在&nbsp;<code>N&nbsp;*&nbsp;N</code>&nbsp;的网格上，我们放置一些&nbsp;<code>1 * 1 * 1&nbsp;</code>&nbsp;的立方体。</p>
 *
 * <p>每个值&nbsp;<code>v = grid[i][j]</code>&nbsp;表示&nbsp;<code>v</code>&nbsp;个正方体叠放在对应单元格&nbsp;<code>(i, j)</code>&nbsp;上。</p>
 *
 * <p>请你返回最终形体的表面积。</p>
 *
 * <p>&nbsp;</p>
 *
 * <ul>
 * </ul>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>[[2]]
 * <strong>输出：</strong>10
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>[[1,2],[3,4]]
 * <strong>输出：</strong>34
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre><strong>输入：</strong>[[1,0],[0,2]]
 * <strong>输出：</strong>16
 * </pre>
 *
 * <p><strong>示例 4：</strong></p>
 *
 * <pre><strong>输入：</strong>[[1,1,1],[1,0,1],[1,1,1]]
 * <strong>输出：</strong>32
 * </pre>
 *
 * <p><strong>示例&nbsp;5：</strong></p>
 *
 * <pre><strong>输入：</strong>[[2,2,2],[2,1,2],[2,2,2]]
 * <strong>输出：</strong>46
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= N &lt;= 50</code></li>
 * 	<li><code>0 &lt;= grid[i][j] &lt;= 50</code></li>
 * </ul>
 *
 * @author Leammin
 * @date 2020-03-25
 */
public interface SurfaceAreaOf3dShapes {
    int surfaceArea(int[][] grid);

    static Testsuite<SurfaceAreaOf3dShapes> testsuite() {
        return Testsuite.<SurfaceAreaOf3dShapes>builder()
                .add(ExpectedTestcase.of(t -> t.surfaceArea(new int[][]{{1, 2}, {3, 4}}), 34))
                .add(ExpectedTestcase.of(t -> t.surfaceArea(new int[][]{{2}}), 10))
                .add(ExpectedTestcase.of(t -> t.surfaceArea(new int[][]{{1, 0}, {0, 2}}), 16))
                .add(ExpectedTestcase.of(t -> t.surfaceArea(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}), 32))
                .add(ExpectedTestcase.of(t -> t.surfaceArea(new int[][]{{2, 2, 2}, {2, 1, 2}, {2, 2, 2}}), 46))
                .build();
    }


    class Solution implements SurfaceAreaOf3dShapes {

        @Override
        public int surfaceArea(int[][] grid) {
            int ans = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] > 0) {
                        ans += 2 + 4 * grid[i][j];
                        ans -= Math.min(get(grid, i - 1, j), grid[i][j]);
                        ans -= Math.min(get(grid, i + 1, j), grid[i][j]);
                        ans -= Math.min(get(grid, i, j - 1), grid[i][j]);
                        ans -= Math.min(get(grid, i, j + 1), grid[i][j]);
                    }
                }
            }
            return ans;
        }

        private int get(int[][] grid, int i, int j) {
            return i >= 0 && j >= 0 && i < grid.length && j < grid[i].length ? grid[i][j] : 0;
        }
    }
}

class SurfaceAreaOf3dShapesTest extends AbstractTest<SurfaceAreaOf3dShapes> {
}
