package com.leammin.leetcode.undone.medium;

/**
 * 647. 回文子串
 *
 * <div><p>给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。</p>
 *
 * <p>具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong> "abc"
 * <strong>输出:</strong> 3
 * <strong>解释:</strong> 三个回文子串: "a", "b", "c".
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入:</strong> "aaa"
 * <strong>输出:</strong> 6
 * <strong>说明:</strong> 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * </pre>
 *
 * <p><strong>注意:</strong></p>
 *
 * <ol>
 * <li>输入的字符串长度不会超过1000。</li>
 * </ol>
 * </div>
 *
 * @author Leammin
 * @date 2019-05-03
 */
public interface PalindromicSubstrings {
    int countSubstrings(String s);

//    class Solution implements PalindromicSubstrings {
//        @Override
//        public int countSubstrings(String s) {
//            int res = s.length();
//            LinkedList<Character> stack = new LinkedList<>();
//            LinkedList<Character> temp = new LinkedList<>();
//            for (int i = 0; i < s.length(); i++) {
//                char c = s.charAt(i);
//                if (temp.isEmpty()) {
//                    // 目前无回文
//                    Character last = stack.pollLast();
//                    Character secondLast = stack.pollLast();
//                    if (last != null && last == c) {
//                        // 发现回文
//                        res++;
//                        temp.addFirst(last);
//                        temp.addLast(c);
//                    } else if (secondLast != null && secondLast == c) {
//                        // 发现回文
//                        res++;
//                        temp.add(secondLast);
//                        temp.add(last);
//                        temp.add(c);
//                    } else {
//                        // 无回文
//                        if (last != null) {
//                            if (secondLast != null) {
//                                stack.addLast(secondLast);
//                            }
//                            stack.addLast(last);
//                        }
//                        stack.add(c);
//                    }
//                } else {
//                    // 目前有回文
//                    Character last = stack.pollLast();
//                    if (last != null && last == c) {
//                        // 依然是回文
//                        res++;
//                        temp.addFirst(last);
//                        temp.addLast(c);
//                    } else {
//                        // 不是回文 将temp回写stack i--
//                        if (last != null) {
//                            stack.addLast(last);
//                        }
//                        stack.addAll(temp);
//                        temp.clear();
//                        i--;
//                    }
//                }
//            }
//            return res;
//        }
//    }

    class Solution1 implements PalindromicSubstrings {

        @Override
        public int countSubstrings(String s) {
            char[] c = s.toCharArray();
            int res = s.length();
            for (int subLength = 2; subLength <= s.length(); subLength++) {
                for (int i = 0; i < s.length() - subLength + 1; i++) {
                    boolean isPalindromic = true;
                    int start = i;
                    int end = i + subLength - 1;
                    while (start < end) {
                        if (c[start++] != c[end--]) {
                            isPalindromic = false;
                            break;
                        }
                    }
                    if (isPalindromic) {
                        res++;
                    }
                }
            }
            return res;
        }
    }
}
