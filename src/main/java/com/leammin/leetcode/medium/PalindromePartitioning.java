package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;
import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/palindrome-partitioning/">131. 分割回文串</a>
 *
 * <p>给你一个字符串 <code>s</code>，请你将<em> </em><code>s</code><em> </em>分割成一些子串，使每个子串都是 <strong>回文串</strong> 。返回 <code>s</code> 所有可能的分割方案。</p>
 *
 * <p><strong>回文串</strong> 是正着读和反着读都一样的字符串。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = "aab"
 * <strong>输出：</strong>[["a","a","b"],["aa","b"]]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = "a"
 * <strong>输出：</strong>[["a"]]
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>1 <= s.length <= 16</code></li>
 * 	<li><code>s</code> 仅由小写英文字母组成</li>
 * </ul>
 *
 *
 * @author Leammin
 * @date 2026-02-20
 */
public interface PalindromePartitioning {
    List<List<String>> partition(String s);

    static Testsuite<PalindromePartitioning> testsuite() {
        return Testsuite.<PalindromePartitioning>builder()
            .addExpected(
                t -> t.partition("aab"),
                List.of(List.of("a", "a", "b"), List.of("aa", "b"))
            )
            .addExpected(t -> t.partition("a"), List.of(List.of("a")))
            .addExpected(
                t -> t.partition("aba"),
                List.of(List.of("a", "b", "a"), List.of("aba"))
            )
            .build();
    }

    class Solution implements PalindromePartitioning {

        @Override
        public List<List<String>> partition(String s) {
            Boolean[][] isPalindromeCache = new Boolean[17][17];
            List<List<String>>[][] cache = new List[17][17];
            return doPartition(s, 0, s.length(), cache, isPalindromeCache);
        }

        public List<List<String>> doPartition(
            String s,
            int left,
            int right,
            List<List<String>>[][] cache,
            Boolean[][] isPalindromeCache
        ) {
            if (left >= right) {
                return List.of(List.of());
            }
            if (cache[left][right] != null) {
                return cache[left][right];
            }
            if (left + 1 == right) {
                return cache[left][right] = List.of(
                    List.of(s.substring(left, right))
                );
            }
            List<List<String>> res = new ArrayList<>();
            for (int i = left + 1; i <= right; i++) {
                if (isPalindrome(s, left, i, isPalindromeCache)) {
                    var nextParts = doPartition(
                        s,
                        i,
                        right,
                        cache,
                        isPalindromeCache
                    );
                    for (var p : nextParts) {
                        List<String> part = new ArrayList<>();
                        part.add(s.substring(left, i));
                        part.addAll(p);
                        res.add(part);
                    }
                }
            }
            return cache[left][right] = res;
        }

        public boolean isPalindrome(
            String s,
            int left,
            int right,
            Boolean[][] isPalindromeCache
        ) {
            if (isPalindromeCache[left][right] != null) {
                return isPalindromeCache[left][right];
            }
            if (left >= right) {
                return isPalindromeCache[left][right] = false;
            }
            if (left + 1 == right) {
                return isPalindromeCache[left][right] = true;
            }
            int i=left;
            int j=right;
            while (i < j) {
                if (s.charAt(i) != s.charAt(j - 1)) {
                    return isPalindromeCache[left][right] = false;
                }
                i++;
                j--;
            }
            return isPalindromeCache[left][right] = true;
        }
    }
}

class PalindromePartitioningTest extends AbstractTest<PalindromePartitioning> {}
