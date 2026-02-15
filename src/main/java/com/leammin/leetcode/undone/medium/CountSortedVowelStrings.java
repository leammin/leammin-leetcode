package com.leammin.leetcode.undone.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/count-sorted-vowel-strings/">1641. 统计字典序元音字符串的数目</a>
 *
 * <p>给你一个整数 <code>n</code>，请返回长度为 <code>n</code> 、仅由元音 (<code>a</code>, <code>e</code>, <code>i</code>, <code>o</code>, <code>u</code>) 组成且按 <strong>字典序排列</strong> 的字符串数量。</p>
 *
 * <p>字符串 <code>s</code> 按 <strong>字典序排列</strong> 需要满足：对于所有有效的 <code>i</code>，<code>s[i]</code> 在字母表中的位置总是与 <code>s[i+1]</code> 相同或在 <code>s[i+1]</code> 之前。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>n = 1
 * <strong>输出：</strong>5
 * <strong>解释：</strong>仅由元音组成的 5 个字典序字符串为 <code>["a","e","i","o","u"]</code>
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>n = 2
 * <strong>输出：</strong>15
 * <strong>解释：</strong>仅由元音组成的 15 个字典序字符串为
 * ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
 * 注意，"ea" 不是符合题意的字符串，因为 'e' 在字母表中的位置比 'a' 靠后
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>n = 33
 * <strong>输出：</strong>66045
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>1 <= n <= 50</code> </li>
 * </ul>
 *
 * @author Leammin
 * @date 2023-03-29
 */
public interface CountSortedVowelStrings {
    int countVowelStrings(int n);

    static Testsuite<CountSortedVowelStrings> testsuite() {
        return Testsuite.<CountSortedVowelStrings>builder()
                .addExpected(t -> t.countVowelStrings(1), 5)
                .addExpected(t -> t.countVowelStrings(2), 15)
                .addExpected(t -> t.countVowelStrings(33), 66045)
                .build();
    }

    class Solution implements CountSortedVowelStrings {

        @Override
        public int countVowelStrings(int n) {
            int[] dp = new int[]{1, 2, 3, 4, 5};
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < 5; j++) {
                    dp[j] += dp[j - 1];
                }
            }
            return dp[4];
        }
    }


    class Solution2 implements CountSortedVowelStrings {

        @Override
        public int countVowelStrings(int n) {
            int[] dp = new int[]{1, 2, 3, 4, 5};
            for (int i = 1; i < n; i++) {
                System.out.println(Arrays.toString(dp));
                for (int j = 1; j < 5; j++) {
                    dp[j] += dp[j - 1];
                }
            }
            return dp[4];
        }
    }
}

class CountSortedVowelStringsTest extends AbstractTest<CountSortedVowelStrings> {
}
