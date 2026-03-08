package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/find-unique-binary-string/">1980. 找出不同的二进制字符串</a>
 *
 * <p>给你一个字符串数组 <code>nums</code> ，该数组由 <code>n</code> 个 <strong>互不相同</strong> 的二进制字符串组成，且每个字符串长度都是 <code>n</code> 。请你找出并返回一个长度为&nbsp;<code>n</code>&nbsp;且&nbsp;<strong>没有出现</strong> 在 <code>nums</code> 中的二进制字符串<em>。</em>如果存在多种答案，只需返回 <strong>任意一个</strong> 即可。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = ["01","10"]
 * <strong>输出：</strong>"11"
 * <strong>解释：</strong>"11" 没有出现在 nums 中。"00" 也是正确答案。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = ["00","01"]
 * <strong>输出：</strong>"11"
 * <strong>解释：</strong>"11" 没有出现在 nums 中。"10" 也是正确答案。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = ["111","011","001"]
 * <strong>输出：</strong>"101"
 * <strong>解释：</strong>"101" 没有出现在 nums 中。"000"、"010"、"100"、"110" 也是正确答案。</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>n == nums.length</code></li>
 * 	<li><code>1 &lt;= n &lt;= 16</code></li>
 * 	<li><code>nums[i].length == n</code></li>
 * 	<li><code>nums[i] </code>为 <code>'0'</code> 或 <code>'1'</code></li>
 * 	<li><code>nums</code> 中的所有字符串 <strong>互不相同</strong></li>
 * </ul>
 *
 * @author Leammin
 * @date 2026-03-08
 */
public interface FindUniqueBinaryString {
    String findDifferentBinaryString(String[] nums);

    static Testsuite<FindUniqueBinaryString> testsuite() {
        return Testsuite.<FindUniqueBinaryString>builder()
                .addAnyExpected(t -> t.findDifferentBinaryString(new String[]{"00", "01"}), List.of("11", "10"))
                .addAnyExpected(t -> t.findDifferentBinaryString(new String[]{"11", "10"}), List.of("00", "01"))
                .addAnyExpected(t -> t.findDifferentBinaryString(new String[]{"01", "10"}), List.of("11", "00"))
                .addAnyExpected(t -> t.findDifferentBinaryString(new String[]{"111", "011", "001"}), List.of("101", "000", "010", "100", "110"))
                .build();
    }

    class Solution implements FindUniqueBinaryString {

        @Override
        public String findDifferentBinaryString(String[] nums) {
            var set = new HashSet<Integer>(nums.length);
            for (String num : nums) {
                set.add(Integer.parseInt(num, 2));
            }
            for (int i = 0; i < (1 << nums.length); i++) {
                if (!set.contains(i)) {
                    String res = Integer.toBinaryString(i);
                    return "0".repeat(nums.length - res.length()) + res;
                }

            }
            return "";
        }
    }

    class Solution2 implements FindUniqueBinaryString {

        @Override
        public String findDifferentBinaryString(String[] nums) {
            char[] res = new char[nums.length];
            for (int i = 0; i < nums.length; i++) {
                res[i] = (char) (((nums[i].charAt(i) - '0') ^ 1) + '0');
            }
            return String.valueOf(res);
        }
    }
}

class FindUniqueBinaryStringTest extends AbstractTest<FindUniqueBinaryString> {
}
