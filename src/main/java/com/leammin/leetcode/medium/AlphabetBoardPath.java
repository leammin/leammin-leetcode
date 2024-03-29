package com.leammin.leetcode.medium;

/**
 * 1138. 字母板上的路径
 * 
 * <p>我们从一块字母板上的位置&nbsp;<code>(0, 0)</code>&nbsp;出发，该坐标对应的字符为&nbsp;<code>board[0][0]</code>。</p>
 * 
 * <p>在本题里，字母板为<code>board = [&quot;abcde&quot;, &quot;fghij&quot;, &quot;klmno&quot;, &quot;pqrst&quot;, &quot;uvwxy&quot;, &quot;z&quot;]</code>.</p>
 * 
 * <p>我们可以按下面的指令规则行动：</p>
 * 
 * <ul>
 * 	<li>如果方格存在，<code>&#39;U&#39;</code>&nbsp;意味着将我们的位置上移一行；</li>
 * 	<li>如果方格存在，<code>&#39;D&#39;</code>&nbsp;意味着将我们的位置下移一行；</li>
 * 	<li>如果方格存在，<code>&#39;L&#39;</code>&nbsp;意味着将我们的位置左移一列；</li>
 * 	<li>如果方格存在，<code>&#39;R&#39;</code>&nbsp;意味着将我们的位置右移一列；</li>
 * 	<li><code>&#39;!&#39;</code>&nbsp;会把在我们当前位置 <code>(r, c)</code> 的字符&nbsp;<code>board[r][c]</code>&nbsp;添加到答案中。</li>
 * </ul>
 * 
 * <p>返回指令序列，用最小的行动次数让答案和目标&nbsp;<code>target</code>&nbsp;相同。你可以返回任何达成目标的路径。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输入：</strong>target = &quot;leet&quot;
 * <strong>输出：</strong>&quot;DDR!UURRR!!DDD!&quot;
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre><strong>输入：</strong>target = &quot;code&quot;
 * <strong>输出：</strong>&quot;RR!DDRR!UUL!R!&quot;
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= target.length &lt;= 100</code></li>
 * 	<li><code>target</code>&nbsp;仅含有小写英文字母。</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2023-02-12
 */
public interface AlphabetBoardPath {
    String alphabetBoardPath(String target);
    class Solution implements AlphabetBoardPath {
        @Override
        public String alphabetBoardPath(String target) {
            StringBuilder result = new StringBuilder();
            int x = 0, y = 0;
            for (char c : target.toCharArray()) {
                int idx = c - 'a';
                int a = idx / 5;
                int b = idx % 5;
                if (c == 'z') {
                    if (b < y) {
                        result.append("L".repeat(y - b));
                    } else if (b > y) {
                        result.append("R".repeat(b - y));
                    }
                    if (a < x) {
                        result.append("U".repeat(x - a));
                    } else if (a > x) {
                        result.append("D".repeat(a - x));
                    }
                } else {
                    if (a < x) {
                        result.append("U".repeat(x - a));
                    } else if (a > x) {
                        result.append("D".repeat(a - x));
                    }
                    if (b < y) {
                        result.append("L".repeat(y - b));
                    } else if (b > y) {
                        result.append("R".repeat(b - y));
                    }
                }
                result.append('!');
                x = a;
                y = b;
            }
            return result.toString();
        }
    }
}
