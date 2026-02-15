package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 面试题13. 机器人的运动范围
 * 
 * <p>地上有一个m行n列的方格，从坐标 <code>[0,0]</code> 到坐标 <code>[m-1,n-1]</code> 。一个机器人从坐标 <code>[0, 0] </code>的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输入：</strong>m = 2, n = 3, k = 1
 * <strong>输出：</strong>3
 * </pre>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输入：</strong>m = 3, n = 1, k = 0
 * <strong>输出：</strong>1
 * </pre>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= n,m &lt;= 100</code></li>
 * 	<li><code>0 &lt;= k&nbsp;&lt;= 20</code></li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2020-04-08
 */
public interface JiQiRenDeYunDongFanWeiLcof {
    int movingCount(int m, int n, int k);

    static Testsuite<JiQiRenDeYunDongFanWeiLcof> testsuite() {
        return Testsuite.<JiQiRenDeYunDongFanWeiLcof>builder()
                .add(ExpectedTestcase.of(t -> t.movingCount(2, 3, 1), 3))
                .add(ExpectedTestcase.of(t -> t.movingCount(3, 1, 0), 1))
                .add(ExpectedTestcase.of(t -> t.movingCount(11, 8, 16), 88))
                .add(ExpectedTestcase.of(t -> t.movingCount(38, 15, 9), 135))
                .build();
    }


    class Solution implements JiQiRenDeYunDongFanWeiLcof {

        @Override
        public int movingCount(int m, int n, int k) {
            return moving(new int[m][n], 0, 0, k);
        }

        private int moving(int[][] matrix, int i, int j, int k) {
            if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length || matrix[i][j] != 0
                    || digitsSum(i) + digitsSum(j) > k) {
                return 0 ;
            }
            matrix[i][j] = 1;
            return 1 + moving(matrix, i + 1, j, k)
                    + moving(matrix, i - 1, j, k)
                    + moving(matrix, i, j + 1, k)
                    + moving(matrix, i, j - 1, k);
        }

        private int digitsSum(int num) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            return sum;
        }
    }

}

class JiQiRenDeYunDongFanWeiLcofTest extends AbstractTest<JiQiRenDeYunDongFanWeiLcof> {
}
