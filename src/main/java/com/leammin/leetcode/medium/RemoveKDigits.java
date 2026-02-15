package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 402. 移掉K位数字
 *
 * <p>给定一个以字符串表示的非负整数&nbsp;<em>num</em>，移除这个数中的 <em>k </em>位数字，使得剩下的数字最小。</p>
 *
 * <p><strong>注意:</strong></p>
 *
 * <ul>
 * 	<li><em>num</em> 的长度小于 10002 且&nbsp;&ge; <em>k。</em></li>
 * 	<li><em>num</em> 不会包含任何前导零。</li>
 * </ul>
 *
 * <p><strong>示例 1 :</strong></p>
 *
 * <pre>
 * 输入: num = &quot;1432219&quot;, k = 3
 * 输出: &quot;1219&quot;
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * </pre>
 *
 * <p><strong>示例 2 :</strong></p>
 *
 * <pre>
 * 输入: num = &quot;10200&quot;, k = 1
 * 输出: &quot;200&quot;
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * </pre>
 *
 * <p>示例<strong> 3 :</strong></p>
 *
 * <pre>
 * 输入: num = &quot;10&quot;, k = 2
 * 输出: &quot;0&quot;
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 * </pre>
 *
 * @author Leammin
 * @date 2022-09-27
 */
public interface RemoveKDigits {
    String removeKdigits(String num, int k);

    static Testsuite<RemoveKDigits> testsuite() {
        return Testsuite.<RemoveKDigits>builder()
                .addExpected(t -> t.removeKdigits("1432219", 3), "1219")
                .addExpected(t -> t.removeKdigits("10200", 1), "200")
                .addExpected(t -> t.removeKdigits("10200", 2), "0")
                .addExpected(t -> t.removeKdigits("10", 2), "0")
                .addExpected(t -> t.removeKdigits("112", 1), "11")
                .build();
    }


    class Solution implements RemoveKDigits {

        @Override
        public String removeKdigits(String num, int k) {
            if (num.length() == k) {
                return "0";
            }
            if (k == 0) {
                return num;
            }
            StringBuilder keep = new StringBuilder(num.length());
            keep.append(num.charAt(0));
            for (int i = 1; i < num.length(); i++) {
                char c = num.charAt(i);
                while (k > 0 && keep.length() > 0 && c < keep.charAt(keep.length() - 1)) {
                    keep.deleteCharAt(keep.length() - 1);
                    k--;
                }
                if (keep.length() != 0 || c != '0') {
                    keep.append(c);
                }
            }
            if (k >= keep.length()) {
                return "0";
            }
            if (k > 0) {
                keep.delete(keep.length() - k, keep.length());
            }
            return keep.toString();
        }
    }
}

class RemoveKDigitsTest extends AbstractTest<RemoveKDigits> {
}
