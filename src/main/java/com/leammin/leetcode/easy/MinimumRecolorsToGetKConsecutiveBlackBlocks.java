package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * <a href="https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/">2379. 得到 K 个黑块的最少涂色次数</a>
 * 
 * <p>给你一个长度为 <code>n</code>&nbsp;下标从 <strong>0</strong>&nbsp;开始的字符串&nbsp;<code>blocks</code>&nbsp;，<code>blocks[i]</code>&nbsp;要么是&nbsp;<code>'W'</code>&nbsp;要么是&nbsp;<code>'B'</code>&nbsp;，表示第&nbsp;<code>i</code>&nbsp;块的颜色。字符&nbsp;<code>'W'</code> 和&nbsp;<code>'B'</code>&nbsp;分别表示白色和黑色。</p>
 * 
 * <p>给你一个整数&nbsp;<code>k</code>&nbsp;，表示想要&nbsp;<strong>连续</strong>&nbsp;黑色块的数目。</p>
 * 
 * <p>每一次操作中，你可以选择一个白色块将它 <strong>涂成</strong>&nbsp;黑色块。</p>
 * 
 * <p>请你返回至少出现 <strong>一次</strong>&nbsp;连续 <code>k</code>&nbsp;个黑色块的 <strong>最少</strong>&nbsp;操作次数。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre>
 * <b>输入：</b>blocks = "WBBWWBBWBW", k = 7
 * <b>输出：</b>3
 * <strong>解释：</strong>
 * 一种得到 7 个连续黑色块的方法是把第 0 ，3 和 4 个块涂成黑色。
 * 得到 blocks = "BBBBBBBWBW" 。
 * 可以证明无法用少于 3 次操作得到 7 个连续的黑块。
 * 所以我们返回 3 。
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre>
 * <b>输入：</b>blocks = "WBWBBBW", k = 2
 * <b>输出：</b>0
 * <strong>解释：</strong>
 * 不需要任何操作，因为已经有 2 个连续的黑块。
 * 所以我们返回 0 。
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><b>提示：</b></p>
 * 
 * <ul>
 * 	<li><code>n == blocks.length</code></li>
 * 	<li><code>1 &lt;= n &lt;= 100</code></li>
 * 	<li><code>blocks[i]</code>&nbsp;要么是&nbsp;<code>'W'</code>&nbsp;，要么是&nbsp;<code>'B'</code> 。</li>
 * 	<li><code>1 &lt;= k &lt;= n</code></li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2023-03-09
 */
public interface MinimumRecolorsToGetKConsecutiveBlackBlocks {
    int minimumRecolors(String blocks, int k);
    static Testsuite<MinimumRecolorsToGetKConsecutiveBlackBlocks> testsuite() {
        return Testsuite.<MinimumRecolorsToGetKConsecutiveBlackBlocks>builder()
                .addExpected(t -> t.minimumRecolors("WBBWWBBWBW", 7), 3)
                .addExpected(t -> t.minimumRecolors("WBWBBBW", 2), 0)
                .build();
    }

    class Solution implements MinimumRecolorsToGetKConsecutiveBlackBlocks {

        @Override
        public int minimumRecolors(String blocks, int k) {
            int wc = 0;
            int l = 0, r = 0;
            for (; r < k; r++) {
                if (blocks.charAt(r) == 'W') {
                    wc++;
                }
            }
            int n = blocks.length();
            int min = wc;
            for (; r < n; r++, l++) {
                if (blocks.charAt(r) == 'W') {
                    wc++;
                }
                if (blocks.charAt(l) == 'W') {
                    wc--;
                }
                min = Math.min(min, wc);
            }
            return min;
        }
    }
}

class MinimumRecolorsToGetKConsecutiveBlackBlocksTest extends AbstractTest<MinimumRecolorsToGetKConsecutiveBlackBlocks> {
}
