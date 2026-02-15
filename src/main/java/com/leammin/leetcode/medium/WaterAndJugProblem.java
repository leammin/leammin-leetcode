package com.leammin.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 365. 水壶问题
 *
 * <p>有两个容量分别为&nbsp;<em>x</em>升 和<em> y</em>升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好&nbsp;<em>z</em>升 的水？</p>
 *
 * <p>如果可以，最后请用以上水壶中的一或两个来盛放取得的&nbsp;<em>z升&nbsp;</em>水。</p>
 *
 * <p>你允许：</p>
 *
 * <ul>
 * 	<li>装满任意一个水壶</li>
 * 	<li>清空任意一个水壶</li>
 * 	<li>从一个水壶向另外一个水壶倒水，直到装满或者倒空</li>
 * </ul>
 *
 * <p><strong>示例 1:</strong> (From the famous <a href="https://www.youtube.com/watch?v=BVtQNK_ZUJg"><em>&quot;Die Hard&quot;</em> example</a>)</p>
 *
 * <pre>输入: x = 3, y = 5, z = 4
 * 输出: True
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre>输入: x = 2, y = 6, z = 5
 * 输出: False
 * </pre>
 *
 * @author Leammin
 * @date 2020-03-21
 */
public interface WaterAndJugProblem {
    boolean canMeasureWater(int x, int y, int z);

    static Testsuite<WaterAndJugProblem> testsuite() {
        return Testsuite.<WaterAndJugProblem>builder()
                .add(ExpectedTestcase.of(t -> t.canMeasureWater(3, 5, 4), true))
                .add(ExpectedTestcase.of(t -> t.canMeasureWater(2, 6, 5), false))
                .add(ExpectedTestcase.of(t -> t.canMeasureWater(22003, 31237, 1), true))
                .build();
    }


    class Solution implements WaterAndJugProblem {
        @Override
        public boolean canMeasureWater(int x, int y, int z) {
            if (x == y) {
                return x == z || 2 * x == z || z == 0;
            }
            if (x == z || y == z || x + y == z) {
                return true;
            }
            if (x + y < z) {
                return false;
            }
            int a = Math.max(x, y);
            int b = Math.min(x, y);
            int[][] record = new int[a + 1][b + 1];

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0});
            while (!queue.isEmpty()) {
                int[] mn = queue.poll();
                int m = mn[0];
                int n = mn[1];
                if (m + n == z) {
                    return true;
                }
                record[m][n] = 1;
                addQueue(record, queue, a, n);
                addQueue(record, queue, m, b);
                addQueue(record, queue, 0, n);
                addQueue(record, queue, m, 0);
                if (m + n < b) {
                    addQueue(record, queue, 0, m + n);
                }
                if (m + n > b) {
                    addQueue(record, queue, m + n - b, b);
                }
                if (m + n < a) {
                    addQueue(record, queue, m + n, 0);
                }
                if (m + n > a) {
                    addQueue(record, queue, a, m + n - a);
                }
            }
            return false;
        }

        private void addQueue(int[][] record, Queue<int[]> queue, int a, int b) {
            if (record[a][b] == 0) {
                queue.add(new int[]{a, b});
            }
        }
    }

    class Best implements WaterAndJugProblem {

        @Override
        public boolean canMeasureWater(int x, int y, int z) {
            if (x + y < z) return false;
            if (x == 0 || y == 0) return z == 0 || x + y == z;
            return z % gcd(x, y) == 0;
        }

        private int gcd(int x, int y) {
            while (y != 0) {
                int tmp = x % y;
                x = y;
                y = tmp;
            }
            return x;
        }
    }
}

class WaterAndJugProblemTest extends AbstractTest<WaterAndJugProblem> {
}
