package com.leammin.leetcode.undone.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 378. 有序矩阵中第K小的元素
 * 
 * <p>给定一个&nbsp;<em>n x n&nbsp;</em>矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。<br />
 * 请注意，它是排序后的第k小元素，而不是第k个元素。</p>
 * 
 * <p><strong>示例:</strong></p>
 * 
 * <pre>
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 * 
 * 返回 13。
 * </pre>
 * 
 * <p><strong>说明: </strong><br />
 * 你可以假设 k 的值永远是有效的, 1 &le; k &le; n<sup>2&nbsp;</sup>。</p>
 * 
 * 
 * @author Leammin
 * @date 2020-07-02
 */
public interface KthSmallestElementInASortedMatrix {
    int kthSmallest(int[][] matrix, int k);

    static Testsuite<KthSmallestElementInASortedMatrix> testsuite() {
        return Testsuite.<KthSmallestElementInASortedMatrix>builder()
                .add(ExpectedTestcase.of(t -> t.kthSmallest(new int[][]{
                        {1, 5, 9},
                        {10, 11, 13},
                        {12, 13, 15}
                }, 8), 13))
                .build();
    }


    class Solution implements KthSmallestElementInASortedMatrix {

        @Override
        public int kthSmallest(int[][] matrix, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(k + 1, Comparator.reverseOrder());
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    queue.add(matrix[i][j]);
                    if (queue.size() > k) {
                        queue.poll();
                    }
                }
            }
            return queue.peek();
        }
    }
}

class KthSmallestElementInASortedMatrixTest extends AbstractTest<KthSmallestElementInASortedMatrix> {
}
