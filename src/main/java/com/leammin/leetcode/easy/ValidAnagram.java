package com.leammin.leetcode.easy;

import java.util.HashMap;

/**
 * 242. 有效的字母异位词
 *
 * <div><p>给定两个字符串 <em>s</em> 和 <em>t</em> ，编写一个函数来判断 <em>t</em> 是否是 <em>s</em> 的一个字母异位词。</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre><strong>输入:</strong> <em>s</em> = "anagram", <em>t</em> = "nagaram"
 * <strong>输出:</strong> true
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入:</strong> <em>s</em> = "rat", <em>t</em> = "car"
 * <strong>输出: </strong>false</pre>
 *
 * <p><strong>说明:</strong><br>
 * 你可以假设字符串只包含小写字母。</p>
 *
 * <p><strong>进阶:</strong><br>
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？</p>
 * </div>
 *
 * @author Leammin
 * @date 2018-09-15
 */
public interface ValidAnagram {
    class Solution implements ValidAnagram {
        public boolean isAnagram(String s, String t) {
            // 进阶
            if (s == null || t == null) {
                return false;
            }
            if (s.equals(t)) {
                return true;
            }
            if (s.length() != t.length()) {
                return false;
            }
            HashMap<Character, Integer> sMap = new HashMap<>(s.length());
            HashMap<Character, Integer> tMap = new HashMap<>(s.length());
            for (char c : s.toCharArray()) {
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            }
            for (char c : t.toCharArray()) {
                tMap.put(c, tMap.getOrDefault(c, 0) + 1);
            }
            return sMap.equals(tMap);
        }
    }


    class Solution1 implements ValidAnagram {
        public boolean isAnagram(String s, String t) {
            // 只有小写字母
            if (s == null || t == null) {
                return false;
            }
            if (s == t) {
                return true;
            }
            if (s.length() != t.length()) {
                return false;
            }
            int[] sc = new int[26];
            int[] tc = new int[26];
            for (char c : s.toCharArray()) {
                sc[c - 'a']++;
            }
            for (char c : t.toCharArray()) {
                tc[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (sc[i] != tc[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}
