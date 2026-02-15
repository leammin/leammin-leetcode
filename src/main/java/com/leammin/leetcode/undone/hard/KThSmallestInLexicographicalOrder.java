package com.leammin.leetcode.undone.hard;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * <a href="https://leetcode.cn/problems/k-th-smallest-in-lexicographical-order/">440. 字典序的第K小数字</a>
 * 
 * <p>给定整数&nbsp;<code>n</code>&nbsp;和&nbsp;<code>k</code>，返回&nbsp;&nbsp;<code>[1, n]</code>&nbsp;中字典序第&nbsp;<code>k</code>&nbsp;小的数字。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre>
 * <strong>输入: </strong>n = 13, k = 2
 * <strong>输出: </strong>10
 * <strong>解释: </strong>字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 * </pre>
 * 
 * <p><strong>示例 2:</strong></p>
 * 
 * <pre>
 * <strong>输入:</strong> n = 1, k = 1
 * <strong>输出:</strong> 1
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= k &lt;= n &lt;= 10<sup>9</sup></code></li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2025-06-09
 */
public interface KThSmallestInLexicographicalOrder {
    int findKthNumber();

    static Testsuite<KThSmallestInLexicographicalOrder> testsuite() {
        return Testsuite.<KThSmallestInLexicographicalOrder>builder()
                .build();
    }

    class Solution implements KThSmallestInLexicographicalOrder {

        @Override
        public int findKthNumber() {
            return 0;
        }
    }
}

class KThSmallestInLexicographicalOrderTest extends AbstractTest<KThSmallestInLexicographicalOrder> {
}
