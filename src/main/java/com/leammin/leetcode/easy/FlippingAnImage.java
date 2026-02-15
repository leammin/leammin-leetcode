package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 832. 翻转图像
 * 
 * <p>给定一个二进制矩阵&nbsp;<code>A</code>，我们想先水平翻转图像，然后反转图像并返回结果。</p>
 * 
 * <p>水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转&nbsp;<code>[1, 1, 0]</code>&nbsp;的结果是&nbsp;<code>[0, 1, 1]</code>。</p>
 * 
 * <p>反转图片的意思是图片中的&nbsp;<code>0</code>&nbsp;全部被&nbsp;<code>1</code>&nbsp;替换，&nbsp;<code>1</code>&nbsp;全部被&nbsp;<code>0</code>&nbsp;替换。例如，反转&nbsp;<code>[0, 1, 1]</code>&nbsp;的结果是&nbsp;<code>[1, 0, 0]</code>。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre>
 * <strong>输入: </strong>[[1,1,0],[1,0,1],[0,0,0]]
 * <strong>输出: </strong>[[1,0,0],[0,1,0],[1,1,1]]
 * <strong>解释:</strong> 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 *      然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 * </pre>
 * 
 * <p><strong>示例 2:</strong></p>
 * 
 * <pre>
 * <strong>输入: </strong>[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * <strong>输出: </strong>[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * <strong>解释:</strong> 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 *      然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * </pre>
 * 
 * <p><strong>说明:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= A.length = A[0].length &lt;= 20</code></li>
 * 	<li><code>0 &lt;= A[i][j]&nbsp;&lt;=&nbsp;1</code></li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2021-02-24
 */
public interface FlippingAnImage {
    int[][] flipAndInvertImage(int[][] A);

    static Testsuite<FlippingAnImage> testsuite() {
        return Testsuite.<FlippingAnImage>builder()
                .add(ExpectedTestcase.of(t -> t.flipAndInvertImage(new int[][]{{1,1,0},{1,0,1},{0,0,0}}),
                        new int[][]{{1,0,0},{0,1,0},{1,1,1}}))
                .build();
    }


    class Solution implements FlippingAnImage {

        @Override
        public int[][] flipAndInvertImage(int[][] A) {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < (A[i].length + 1) / 2; j++) {
                    int k = A[i].length - j - 1;
                    int tmp = A[i][j];
                    A[i][j] = A[i][k] ^ 1;
                    if (j != k) {
                        A[i][k] = tmp ^ 1;
                    }
                }
            }
            return A;
        }
    }
}

class FlippingAnImageTest extends AbstractTest<FlippingAnImage> {
}
