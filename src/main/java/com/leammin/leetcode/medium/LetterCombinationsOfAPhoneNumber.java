package com.leammin.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * 
 * <p>给定一个仅包含数字&nbsp;<code>2-9</code>&nbsp;的字符串，返回所有它能表示的字母组合。</p>
 * 
 * <p>给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。</p>
 * 
 * <p><img src="https://assets.leetcode-cn.com/aliyun-lc-upload/original_images/17_telephone_keypad.png" style="width: 200px;"></p>
 * 
 * <p><strong>示例:</strong></p>
 * 
 * <pre><strong>输入：</strong>&quot;23&quot;
 * <strong>输出：</strong>[&quot;ad&quot;, &quot;ae&quot;, &quot;af&quot;, &quot;bd&quot;, &quot;be&quot;, &quot;bf&quot;, &quot;cd&quot;, &quot;ce&quot;, &quot;cf&quot;].
 * </pre>
 * 
 * <p><strong>说明:</strong><br>
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。</p>
 * 
 * 
 * @author Leammin
 * @date 2020-03-19
 */
public interface LetterCombinationsOfAPhoneNumber {
    List<String> letterCombinations(String digits);

    class Solution implements LetterCombinationsOfAPhoneNumber {


        @Override
        public List<String> letterCombinations(String digits) {
            if (digits.isEmpty()) {
                return Collections.emptyList();
            }
            char[][] map = new char[][]{
                    {'a','b','c'},
                    {'d','e','f'},
                    {'g','h','i'},
                    {'j','k','l'},
                    {'m','n','o'},
                    {'p','q','r','s'},
                    {'t','u','v'},
                    {'w','x','y','z'},
            };
            char[] chars = map[digits.charAt(0) - '2'];
            List<String> strings = letterCombinations(digits.substring(1));
            if (strings.isEmpty()) {
                strings = Collections.singletonList("");
            }
            List<String> result = new ArrayList<>(strings.size() * chars.length);
            for (char c : chars) {
                for (String str : strings) {
                    result.add(c + str);
                }
            }
            return result;
        }
    }

    class Solution2 implements LetterCombinationsOfAPhoneNumber {
        char[][] map = new char[][]{
                {'a','b','c'},
                {'d','e','f'},
                {'g','h','i'},
                {'j','k','l'},
                {'m','n','o'},
                {'p','q','r','s'},
                {'t','u','v'},
                {'w','x','y','z'},
        };
        int n;
        List<char[]> results;

        @Override
        public List<String> letterCombinations(String digits) {
            if (digits.isEmpty()) {
                return Collections.emptyList();
            }
            n = digits.length();

            int count79 = 0;
            for (int i = 0; i < n; i++) {
                char c = digits.charAt(i);
                if (c == '7' || c == '9') {
                    count79++;
                }
            }
            int size = (int) (Math.pow(3, n - count79) * Math.pow(4, count79));
            results = new ArrayList<>(size);
            char[] result = new char[n];
            results.add(result);
            combinate(digits, 0, result);

            List<String> ans = new ArrayList<>(results.size());
            for (char[] chars : results) {
                ans.add(String.valueOf(chars));
            }
            return ans;
        }

        public void combinate(String digits, int index, char[] result) {
            if (index >= n) {
                return;
            }
            char[] chars = map[digits.charAt(index) - '2'];
            result[index] = chars[0];
            combinate(digits, index + 1, result);
            for (int i = 1; i < chars.length; i++) {
                char[] r = result.clone();
                results.add(r);
                r[index] = chars[i];
                combinate(digits, index + 1, r);
            }
        }
    }
}
