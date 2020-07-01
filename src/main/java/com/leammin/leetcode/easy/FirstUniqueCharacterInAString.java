package com.leammin.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 *
 * <div><p>给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。</p>
 *
 * <p><strong>案例:</strong></p>
 *
 * <pre>s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>注意事项：</strong>您可以假定该字符串只包含小写字母。</p>
 * </div>
 *
 * @author Leammin
 * @date 2018-09-10
 */
public interface FirstUniqueCharacterInAString {
    int firstUniqChar(String s);

    class Solution implements FirstUniqueCharacterInAString {
        @Override
        public int firstUniqChar(String s) {
            Map<Character, Integer> map = new HashMap<>(s.length());
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (map.containsKey(chars[i])) {
                    map.put(chars[i], null);
                } else {
                    map.put(chars[i], i);
                }
            }
            Integer res;
            for (int i = 0; i < chars.length; i++) {
                res = map.get(chars[i]);
                if (res != null) {
                    return res;
                }
            }
            return -1;
        }
    }

    class Solution1 implements FirstUniqueCharacterInAString {
        @Override
        public int firstUniqChar(String s) {
            int result = -1;
            for (char c = 'a'; c <= 'z'; c++) {
                int index = s.indexOf(c);
                if (index != -1 && index == s.lastIndexOf(c)) {
                    result = result != -1 ? Math.min(result, index) : index;
                }
            }
            return result;
        }
    }
}
