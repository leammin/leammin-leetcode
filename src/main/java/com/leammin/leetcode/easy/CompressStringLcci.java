package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 面试题 01.06. 字符串压缩
 * 
 * <p>字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串<code>aabcccccaaa</code>会变为<code>a2b1c5a3</code>。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。</p>
 * 
 * <p> <strong>示例1:</strong></p>
 * 
 * <pre>
 * <strong> 输入</strong>："aabcccccaaa"
 * <strong> 输出</strong>："a2b1c5a3"
 * </pre>
 * 
 * <p> <strong>示例2:</strong></p>
 * 
 * <pre>
 * <strong> 输入</strong>："abbccd"
 * <strong> 输出</strong>："abbccd"
 * <strong> 解释</strong>："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * </pre>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ol>
 * <li>字符串长度在[0, 50000]范围内。</li>
 * </ol>
 * 
 * 
 * @author Leammin
 * @date 2020-03-16
 */
public interface CompressStringLcci {
    String compressString(String S);

    static Testsuite<CompressStringLcci> testsuite() {
        return Testsuite.<CompressStringLcci>builder()
                .add(ExpectedTestcase.of(t -> t.compressString("aabcccccaaa"), "a2b1c5a3"))
                .add(ExpectedTestcase.of(t -> t.compressString("abbccd"), "abbccd"))
                .build();
    }


    class Solution implements CompressStringLcci {

        @Override
        public String compressString(String S) {
            if (S == null || S.isEmpty()) {
                return S;
            }
            StringBuilder builder = new StringBuilder(S.length());
            char last = S.charAt(0);
            int lastCount = 1;
            for (int i = 1; i < S.length(); i++) {
                char c = S.charAt(i);
                if (c == last) {
                    lastCount++;
                } else {
                    builder.append(last).append(lastCount);
                    last = c;
                    lastCount = 1;
                }
            }
            builder.append(last).append(lastCount);
            return builder.length() >= S.length() ? S : builder.toString();
        }
    }
}

class CompressStringLcciTest extends AbstractTest<CompressStringLcci> {
}
