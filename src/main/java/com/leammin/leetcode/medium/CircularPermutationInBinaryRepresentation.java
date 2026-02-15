package com.leammin.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 1238. 循环码排列
 *
 * <p>给你两个整数&nbsp;<code>n</code> 和 <code>start</code>。你的任务是返回任意 <code>(0,1,2,,...,2^n-1)</code> 的排列 <code>p</code>，并且满足：</p>
 *
 * <ul>
 * 	<li><code>p[0] = start</code></li>
 * 	<li><code>p[i]</code> 和 <code>p[i+1]</code>&nbsp;的二进制表示形式只有一位不同</li>
 * 	<li><code>p[0]</code> 和 <code>p[2^n -1]</code>&nbsp;的二进制表示形式也只有一位不同</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>n = 2, start = 3
 * <strong>输出：</strong>[3,2,0,1]
 * <strong>解释：</strong>这个排列的二进制表示是 (11,10,00,01)
 *      所有的相邻元素都有一位是不同的，另一个有效的排列是 [3,1,0,2]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输出：</strong>n = 3, start = 2
 * <strong>输出：</strong>[2,6,7,5,4,0,1,3]
 * <strong>解释：</strong>这个排列的二进制表示是 (010,110,111,101,100,000,001,011)
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= n &lt;= 16</code></li>
 * 	<li><code>0 &lt;= start&nbsp;&lt;&nbsp;2^n</code></li>
 * </ul>
 *
 * @author Leammin
 * @date 2023-02-23
 */
public interface CircularPermutationInBinaryRepresentation {
    List<Integer> circularPermutation(int n, int start);

    static Testsuite<CircularPermutationInBinaryRepresentation> testsuite() {
        return Testsuite.<CircularPermutationInBinaryRepresentation>builder()
//                .addExpected(t -> t.circularPermutation(2, 3), List.of(3,2,0,1))
                .addExpected(t -> t.circularPermutation(3, 2), List.of(2, 3, 1, 0, 4, 5, 7, 6))
                .build();
    }


    class Solution implements CircularPermutationInBinaryRepresentation {
//        0000 0
//        0001 1
//        0011 2
//        0010 1
//        0110 3
//        0111 1
//        0101 2
//        0100 1
//        1100 4
//        1101 1
//        1111 2
//        1110 1
//        1010 3
//        1011 1
//        1001 2
//        1000 1

        @Override
        public List<Integer> circularPermutation(int n, int start) {
            int[] xor = new int[1 << n];
            xor[0] = 0;
            xor[1] = 1;
            for (int x = 1; x < n; x++) {
                int i = 1 << x;
                xor[i] = 1 << x;
                System.arraycopy(xor, 1, xor, i + 1, i - 1);
            }
            List<Integer> res = new ArrayList<>(1 << n);
            int last = start;
            for (int j : xor) {
                last ^= j;
                res.add(last);
            }
            return res;
        }
    }
}

class CircularPermutationInBinaryRepresentationTest extends AbstractTest<CircularPermutationInBinaryRepresentation> {
}
