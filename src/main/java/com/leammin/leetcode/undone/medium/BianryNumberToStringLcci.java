package com.leammin.leetcode.undone.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * <a href="https://leetcode.cn/problems/bianry-number-to-string-lcci/">面试题 05.02. 二进制数转字符串</a>
 *
 * <p>二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字无法精确地用32位以内的二进制表示，则打印“ERROR”。</p>
 *
 * <p><strong>示例1:</strong></p>
 *
 * <pre>
 * <strong> 输入</strong>：0.625
 * <strong> 输出</strong>："0.101"
 * </pre>
 *
 * <p><strong>示例2:</strong></p>
 *
 * <pre>
 * <strong> 输入</strong>：0.1
 * <strong> 输出</strong>："ERROR"
 * <strong> 提示</strong>：0.1无法被二进制准确表示
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li>32位包括输出中的 <code>"0."</code> 这两位。</li>
 * 	<li>题目保证输入用例的小数位数最多只有 <code>6</code> 位</li>
 * </ul>
 *
 * @author Leammin
 * @date 2023-03-02
 */
public interface BianryNumberToStringLcci {
    String printBin(double num);

    static Testsuite<BianryNumberToStringLcci> testsuite() {
        return Testsuite.<BianryNumberToStringLcci>builder()
                .addExpected(t -> t.printBin(0.625), "0.101")
                .addExpected(t -> t.printBin(0.1), "ERROR")
                .build();
    }

    class Solution implements BianryNumberToStringLcci {

        @Override
        public String printBin(double num) {
            StringBuilder sb = new StringBuilder();
            sb.append("0.");
            while (num > 0) {
                num += num;
                if (num >= 1) {
                    num -= 1;
                    sb.append('1');
                } else {
                    sb.append('0');
                }
                if (sb.length() > 32) {
                    return "ERROR";
                }
            }
            return sb.toString();
        }
    }
}

class BianryNumberToStringLcciTest extends AbstractTest<BianryNumberToStringLcci> {
}
