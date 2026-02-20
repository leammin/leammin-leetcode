package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * <a href="https://leetcode.cn/problems/excel-sheet-column-title/">168. Excel表列名称</a>
 *
 * <p>给你一个整数 <code>columnNumber</code> ，返回它在 Excel 表中相对应的列名称。</p>
 *
 * <p>例如：</p>
 *
 * <pre>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>columnNumber = 1
 * <strong>输出：</strong>"A"
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>columnNumber = 28
 * <strong>输出：</strong>"AB"
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>columnNumber = 701
 * <strong>输出：</strong>"ZY"
 * </pre>
 *
 * <p><strong>示例 4：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>columnNumber = 2147483647
 * <strong>输出：</strong>"FXSHRXW"
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>1 <= columnNumber <= 2<sup>31</sup> - 1</code></li>
 * </ul>
 *
 *
 * @author Leammin
 * @date 2026-02-19
 */
public interface ExcelSheetColumnTitle {
    String convertToTitle(int columnNumber);

    static Testsuite<ExcelSheetColumnTitle> testsuite() {
        return Testsuite.<ExcelSheetColumnTitle>builder()
            .addExpected(t -> t.convertToTitle(1), "A")
            .addExpected(t -> t.convertToTitle(28), "AB")
            .addExpected(t -> t.convertToTitle(701), "ZY")
            .addExpected(t -> t.convertToTitle(2147483647), "FXSHRXW")
            .addExpected(t -> t.convertToTitle(52), "AZ")
            .addExpected(t -> t.convertToTitle(26), "Z")
            .addExpected(t -> t.convertToTitle(27), "AA")
            .build();
    }

    class Solution implements ExcelSheetColumnTitle {

        @Override
        public String convertToTitle(int columnNumber) {
            StringBuilder result = new StringBuilder();;
            var cn = columnNumber;
            while (cn > 0) {
                var x = cn % 26;
                cn = cn / 26;
                if (x == 0) {
                    x = 26;
                    cn--;
                }
                result.appendCodePoint('A' - 1 + x);
            }
            return result.reverse().toString();
        }
    }
}

class ExcelSheetColumnTitleTest extends AbstractTest<ExcelSheetColumnTitle> {}
