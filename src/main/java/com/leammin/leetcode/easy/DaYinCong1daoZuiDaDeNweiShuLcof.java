package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 面试题17. 打印从1到最大的n位数
 * 
 * <p>输入数字 <code>n</code>，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre><strong>输入:</strong> n = 1
 * <strong>输出:</strong> [1,2,3,4,5,6,7,8,9]
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p>说明：</p>
 * 
 * <ul>
 * 	<li>用返回一个整数列表来代替打印</li>
 * 	<li>n 为正整数</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2021-09-07
 */
public interface DaYinCong1daoZuiDaDeNweiShuLcof {
    int[] printNumbers(int n);

    static Testsuite<DaYinCong1daoZuiDaDeNweiShuLcof> testsuite() {
        return Testsuite.<DaYinCong1daoZuiDaDeNweiShuLcof>builder()
                .addExpected(t -> t.printNumbers(1), new int[]{1,2,3,4,5,6,7,8,9})
                .build();
    }


    class Solution implements DaYinCong1daoZuiDaDeNweiShuLcof {

        @Override
        public int[] printNumbers(int n) {
            int max = (int) Math.pow(10, n);
            int[] res = new int[max - 1];
            for (int i = 1; i < max; i++) {
                res[i - 1] = i;
            }
            return res;
        }
    }
}

class DaYinCong1daoZuiDaDeNweiShuLcofTest extends AbstractTest<DaYinCong1daoZuiDaDeNweiShuLcof> {
}
