package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 771. 宝石与石头
 * 
 * <p>&nbsp;给定字符串<code>J</code>&nbsp;代表石头中宝石的类型，和字符串&nbsp;<code>S</code>代表你拥有的石头。&nbsp;<code>S</code>&nbsp;中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。</p>
 * 
 * <p><code>J</code>&nbsp;中的字母不重复，<code>J</code>&nbsp;和&nbsp;<code>S</code>中的所有字符都是字母。字母区分大小写，因此<code>&quot;a&quot;</code>和<code>&quot;A&quot;</code>是不同类型的石头。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre><strong>输入:</strong> J = &quot;aA&quot;, S = &quot;aAAbbbb&quot;
 * <strong>输出:</strong> 3
 * </pre>
 * 
 * <p><strong>示例 2:</strong></p>
 * 
 * <pre><strong>输入:</strong> J = &quot;z&quot;, S = &quot;ZZ&quot;
 * <strong>输出:</strong> 0
 * </pre>
 * 
 * <p><strong>注意:</strong></p>
 * 
 * <ul>
 * 	<li><code>S</code>&nbsp;和&nbsp;<code>J</code>&nbsp;最多含有50个字母。</li>
 * 	<li>&nbsp;<code>J</code>&nbsp;中的字符不重复。</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2020-06-28
 */
public interface JewelsAndStones {
    int numJewelsInStones(String J, String S);

    static Testsuite<JewelsAndStones> testsuite() {
        return Testsuite.<JewelsAndStones>builder()
                .add(ExpectedTestcase.of(t -> t.numJewelsInStones("aA", "aAAbbbb"), 3))
                .add(ExpectedTestcase.of(t -> t.numJewelsInStones("z", "ZZ"), 0))
                .build();
    }


    class Solution implements JewelsAndStones {

        @Override
        public int numJewelsInStones(String J, String S) {
            int res = 0;
            boolean[] jewels = new boolean[52];
            for (int i = 0; i < J.length(); i++) {
                jewels[getIndex(J.charAt(i))] = true;
            }
            for (int i = 0; i < S.length(); i++) {
                if (jewels[getIndex(S.charAt(i))]) {
                    res++;
                }
            }
            return res;
        }

        private int getIndex(char c) {
            if (c >= 'a' && c <= 'z') {
                return c - 'a';
            } else {
                return c - 'A' + 26;
            }
        }
    }
}

class JewelsAndStonesTest extends AbstractTest<JewelsAndStones> {
}
