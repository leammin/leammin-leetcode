package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 面试题46. 把数字翻译成字符串
 * 
 * <p>给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 &ldquo;a&rdquo; ，1 翻译成 &ldquo;b&rdquo;，&hellip;&hellip;，11 翻译成 &ldquo;l&rdquo;，&hellip;&hellip;，25 翻译成 &ldquo;z&rdquo;。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre><strong>输入:</strong> 12258
 * <strong>输出:</strong> <code>5
 * </code><strong>解释:</strong> 12258有5种不同的翻译，分别是&quot;bccfi&quot;, &quot;bwfi&quot;, &quot;bczi&quot;, &quot;mcfi&quot;和&quot;mzi&quot;</pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ul>
 * 	<li><code>0 &lt;= num &lt; 2<sup>31</sup></code></li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2020-06-09
 */
public interface BaShuZiFanYiChengZiFuChuanLcof {
    int translateNum(int num);

    static Testsuite<BaShuZiFanYiChengZiFuChuanLcof> testsuite() {
        return Testsuite.<BaShuZiFanYiChengZiFuChuanLcof>builder()
                .add(ExpectedTestcase.of(t -> t.translateNum(12258), 5))
                .add(ExpectedTestcase.of(t -> t.translateNum(542), 1))
                .add(ExpectedTestcase.of(t -> t.translateNum(506), 1))
                .build();
    }


    class Solution implements BaShuZiFanYiChengZiFuChuanLcof {

        @Override
        public int translateNum(int num) {
            int ll = 1;
            int l = 1;
            int li = 30;
            while (num > 0) {
                int i = num % 10;
                int c = l + (i > 0 && i * 10 + li <= 25 ? ll : 0);
                ll = l;
                l = c;
                li = i;
                num /= 10;
            }
            return l;
        }
    }
}

class BaShuZiFanYiChengZiFuChuanLcofTest extends AbstractTest<BaShuZiFanYiChengZiFuChuanLcof> {
}
