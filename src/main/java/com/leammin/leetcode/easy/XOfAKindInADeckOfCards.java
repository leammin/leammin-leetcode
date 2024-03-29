package com.leammin.leetcode.easy;

/**
 * 914. 卡牌分组
 * 
 * <p>给定一副牌，每张牌上都写着一个整数。</p>
 * 
 * <p>此时，你需要选定一个数字 <code>X</code>，使我们可以将整副牌按下述规则分成 1 组或更多组：</p>
 * 
 * <ul>
 * 	<li>每组都有&nbsp;<code>X</code>&nbsp;张牌。</li>
 * 	<li>组内所有的牌上都写着相同的整数。</li>
 * </ul>
 * 
 * <p>仅当你可选的 <code>X &gt;= 2</code> 时返回&nbsp;<code>true</code>。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输入：</strong>[1,2,3,4,4,3,2,1]
 * <strong>输出：</strong>true
 * <strong>解释：</strong>可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre><strong>输入：</strong>[1,1,1,2,2,2,3,3]
 * <strong>输出：</strong>false
 * <strong>解释：</strong>没有满足要求的分组。
 * </pre>
 * 
 * <p><strong>示例 3：</strong></p>
 * 
 * <pre><strong>输入：</strong>[1]
 * <strong>输出：</strong>false
 * <strong>解释：</strong>没有满足要求的分组。
 * </pre>
 * 
 * <p><strong>示例 4：</strong></p>
 * 
 * <pre><strong>输入：</strong>[1,1]
 * <strong>输出：</strong>true
 * <strong>解释：</strong>可行的分组是 [1,1]
 * </pre>
 * 
 * <p><strong>示例 5：</strong></p>
 * 
 * <pre><strong>输入：</strong>[1,1,2,2,2,2]
 * <strong>输出：</strong>true
 * <strong>解释：</strong>可行的分组是 [1,1]，[2,2]，[2,2]
 * </pre>
 * 
 * <p><br>
 * <strong>提示：</strong></p>
 * 
 * <ol>
 * 	<li><code>1 &lt;= deck.length &lt;= 10000</code></li>
 * 	<li><code>0 &lt;= deck[i] &lt;&nbsp;10000</code></li>
 * </ol>
 * 
 * <p>&nbsp;</p>
 * 
 * 
 * @author Leammin
 * @date 2020-03-27
 */
public interface XOfAKindInADeckOfCards {
    boolean hasGroupsSizeX(int[] deck);

    class Solution implements XOfAKindInADeckOfCards {

        @Override
        public boolean hasGroupsSizeX(int[] deck) {
            int[] count = new int[10000];
            for (int i : deck) {
                count[i]++;
            }
            int ans = 0;
            for (int i : count) {
                if (i != 0) {
                    ans = gcd(i, ans);
                    if (ans == 1) {
                        return false;
                    }
                }
            }
            return true;
        }

        private int gcd(int x, int y) {
            if (y == 0) {
                return x;
            }
            return gcd(y, x % y);
        }
    }
}
