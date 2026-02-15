package com.leammin.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 733. 图像渲染
 *
 * <p>有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。</p>
 *
 * <p>给你一个坐标&nbsp;<code>(sr, sc)</code>&nbsp;表示图像渲染开始的像素值（行 ，列）和一个新的颜色值&nbsp;<code>newColor</code>，让你重新上色这幅图像。</p>
 *
 * <p>为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，&hellip;&hellip;，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。</p>
 *
 * <p>最后返回经过上色渲染后的图像。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong>
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * <strong>输出:</strong> [[2,2,2],[2,2,0],[2,0,1]]
 * <strong>解析:</strong>
 * 在图像的正中间，(坐标(sr,sc)=(1,1)),
 * 在路径上所有符合条件的像素点的颜色都被更改成2。
 * 注意，右下角的像素没有更改为2，
 * 因为它不是在上下左右四个方向上与初始点相连的像素点。
 * </pre>
 *
 * <p><strong>注意:</strong></p>
 *
 * <ul>
 * 	<li><code>image</code> 和&nbsp;<code>image[0]</code>&nbsp;的长度在范围&nbsp;<code>[1, 50]</code> 内。</li>
 * 	<li>给出的初始点将满足&nbsp;<code>0 &lt;= sr &lt; image.length</code> 和&nbsp;<code>0 &lt;= sc &lt; image[0].length</code>。</li>
 * 	<li><code>image[i][j]</code> 和&nbsp;<code>newColor</code>&nbsp;表示的颜色值在范围&nbsp;<code>[0, 65535]</code>内。</li>
 * </ul>
 *
 * @author Leammin
 * @date 2020-06-11
 */
public interface FloodFill {
    int[][] floodFill(int[][] image, int sr, int sc, int newColor);

    static Testsuite<FloodFill> testsuite() {
        return Testsuite.<FloodFill>builder()
                .add(ExpectedTestcase.of(t -> t.floodFill(new int[][]{
                        {1, 1, 1},
                        {1, 1, 0},
                        {1, 0, 1},
                }, 1, 1, 2), new int[][]{
                        {2, 2, 2},
                        {2, 2, 0},
                        {2, 0, 1},
                }))
                .build();
    }


    class Solution implements FloodFill {

        @Override
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int oldColor = image[sr][sc];
            if (oldColor == newColor) {
                return image;
            }
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{sr, sc});
            while (!queue.isEmpty()) {
                int[] s = queue.poll();
                image[s[0]][s[1]] = newColor;
                add(queue, image, s[0] - 1, s[1], oldColor);
                add(queue, image, s[0] + 1, s[1], oldColor);
                add(queue, image, s[0], s[1] - 1, oldColor);
                add(queue, image, s[0], s[1] + 1, oldColor);
            }
            return image;
        }

        private void add(Queue<int[]> queue, int[][] image, int r, int c, int oldColor) {
            if (r >= 0 && c >= 0 && r < image.length && c < image[r].length && image[r][c] == oldColor) {
                queue.add(new int[]{r, c});
            }
        }
    }

    class Solution2 implements FloodFill {

        @Override
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int oldColor = image[sr][sc];
            if (oldColor == newColor) {
                return image;
            }
            return floodFill(image, sr, sc, newColor, oldColor);
        }

        private int[][] floodFill(int[][] image, int r, int c, int newColor, int oldColor) {
            image[r][c] = newColor;
            fill(image, r + 1, c, newColor, oldColor);
            fill(image, r - 1, c, newColor, oldColor);
            fill(image, r, c + 1, newColor, oldColor);
            fill(image, r, c - 1, newColor, oldColor);
            return image;
        }

        private void fill(int[][] image, int r, int c, int newColor, int oldColor) {
            if (r >= 0 && c >= 0 && r < image.length && c < image[r].length && image[r][c] == oldColor) {
                floodFill(image, r, c, newColor, oldColor);
            }
        }
    }
}

class FloodFillTest extends AbstractTest<FloodFill> {
}
