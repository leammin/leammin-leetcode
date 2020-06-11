package com.leammin.leetcode.medium;

/**
 * 990. 等式方程的可满足性
 *
 * <p>给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 <code>equations[i]</code> 的长度为 <code>4</code>，并采用两种不同的形式之一：<code>&quot;a==b&quot;</code> 或&nbsp;<code>&quot;a!=b&quot;</code>。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。</p>
 *
 * <p>只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回&nbsp;<code>true</code>，否则返回 <code>false</code>。&nbsp;</p>
 *
 * <p>&nbsp;</p>
 *
 * <ol>
 * </ol>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>[&quot;a==b&quot;,&quot;b!=a&quot;]
 * <strong>输出：</strong>false
 * <strong>解释：</strong>如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输出：</strong>[&quot;b==a&quot;,&quot;a==b&quot;]
 * <strong>输入：</strong>true
 * <strong>解释：</strong>我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre><strong>输入：</strong>[&quot;a==b&quot;,&quot;b==c&quot;,&quot;a==c&quot;]
 * <strong>输出：</strong>true
 * </pre>
 *
 * <p><strong>示例 4：</strong></p>
 *
 * <pre><strong>输入：</strong>[&quot;a==b&quot;,&quot;b!=c&quot;,&quot;c==a&quot;]
 * <strong>输出：</strong>false
 * </pre>
 *
 * <p><strong>示例 5：</strong></p>
 *
 * <pre><strong>输入：</strong>[&quot;c==c&quot;,&quot;b==d&quot;,&quot;x!=z&quot;]
 * <strong>输出：</strong>true
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ol>
 * 	<li><code>1 &lt;= equations.length &lt;= 500</code></li>
 * 	<li><code>equations[i].length == 4</code></li>
 * 	<li><code>equations[i][0]</code> 和&nbsp;<code>equations[i][3]</code>&nbsp;是小写字母</li>
 * 	<li><code>equations[i][1]</code> 要么是&nbsp;<code>&#39;=&#39;</code>，要么是&nbsp;<code>&#39;!&#39;</code></li>
 * 	<li><code>equations[i][2]</code>&nbsp;是&nbsp;<code>&#39;=&#39;</code></li>
 * </ol>
 *
 * @author Leammin
 * @date 2020-06-08
 */
public interface SatisfiabilityOfEqualityEquations {
    boolean equationsPossible(String[] equations);

    class Solution implements SatisfiabilityOfEqualityEquations {

        @Override
        public boolean equationsPossible(String[] equations) {
            int[] equals = new int[26];
            for (int i = 0; i < equals.length; i++) {
                equals[i] = 1 << i;
            }
            for (String equation : equations) {
                if (equation.charAt(1) == '=') {
                    int i = equation.charAt(0) - 'a';
                    int j = equation.charAt(3) - 'a';
                    equals[j] = equals[i] |= equals[j];
                }
            }
            for (int i = 0; i < equals.length; i++) {
                for (int j = 0; j < equals.length; j++) {
                    if (i != j && (equals[i] & equals[j]) > 0) {
                        equals[j] = equals[i] |= equals[j];
                    }
                }
            }
            for (String equation : equations) {
                if (equation.charAt(1) == '!') {
                    int i = equation.charAt(0) - 'a';
                    int j = equation.charAt(3) - 'a';
                    if ((equals[i] & equals[j]) > 0) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    class Solution2 implements SatisfiabilityOfEqualityEquations {

        @Override
        public boolean equationsPossible(String[] equations) {
            int[] tree = new int[26];
            for (int i = 0; i < tree.length; i++) {
                tree[i] = i;
            }
            for (String equation : equations) {
                if (equation.charAt(1) == '=') {
                    int i = equation.charAt(0) - 'a';
                    int j = equation.charAt(3) - 'a';
                    union(tree, i , j);
                }
            }
            for (String equation : equations) {
                if (equation.charAt(1) == '!') {
                    int i = equation.charAt(0) - 'a';
                    int j = equation.charAt(3) - 'a';
                    if (find(tree, i) == find(tree, j)) {
                        return false;
                    }
                }
            }
            return true;
        }

        private void union(int[] tree, int i, int j) {
            tree[find(tree, j)] = find(tree, i);
        }

        private int find(int[] tree, int i) {
            while (tree[i] != i) {
                tree[i] = tree[tree[i]];
                i = tree[i];
            }
            return i;
        }
    }
}
