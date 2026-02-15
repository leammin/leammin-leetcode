package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 面试题 01.09. 字符串轮转
 * 
 * <p>字符串轮转。给定两个字符串<code>s1</code>和<code>s2</code>，请编写代码检查<code>s2</code>是否为<code>s1</code>旋转而成（比如，<code>waterbottle</code>是<code>erbottlewat</code>旋转后的字符串）。</p>
 * 
 * <p><strong>示例1:</strong></p>
 * 
 * <pre><strong> 输入</strong>：s1 = &quot;waterbottle&quot;, s2 = &quot;erbottlewat&quot;
 * <strong> 输出</strong>：True
 * </pre>
 * 
 * <p><strong>示例2:</strong></p>
 * 
 * <pre><strong> 输入</strong>：s1 = &quot;aa&quot;, &quot;aba&quot;
 * <strong> 输出</strong>：False
 * </pre>
 * 
 * <ol>
 * </ol>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ol>
 * 	<li>字符串长度在[0, 100000]范围内。</li>
 * </ol>
 * 
 * <p><strong>说明:</strong></p>
 * 
 * <ol>
 * 	<li>你能只调用一次检查子串的方法吗？</li>
 * </ol>
 * 
 * 
 * @author Leammin
 * @date 2022-09-29
 */
public interface StringRotationLcci {
    boolean isFlipedString(String s1, String s2);

    static Testsuite<StringRotationLcci> testsuite() {
        return Testsuite.<StringRotationLcci>builder()
                .addExpected(t -> t.isFlipedString("waterbottle", "erbottlewat"), true)
                .addExpected(t -> t.isFlipedString("aa", "ab"), false)
                .build();
    }


    class Solution implements StringRotationLcci {

        @Override
        public boolean isFlipedString(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            if (s1.length() == 0) {
                return true;
            }
            for (int i = 0; i < s2.length(); i++) {
                if (s1.charAt(0) == s2.charAt(i)) {
                    boolean isFliped = true;
                    for (int j = 1; j < s1.length(); j++) {
                        if (s1.charAt(j) != s2.charAt((i + j) % s1.length())) {
                            isFliped = false;
                            break;
                        }
                    }
                    if (isFliped) {
                        return true;
                    }
                }
            }
            return false;
        }
    }


    class Solution2 implements StringRotationLcci {

        @Override
        public boolean isFlipedString(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            if (s1.length() == 0) {
                return true;
            }
            return (s2 + s2).contains(s1);
        }
    }
}

class StringRotationLcciTest extends AbstractTest<StringRotationLcci> {
}
