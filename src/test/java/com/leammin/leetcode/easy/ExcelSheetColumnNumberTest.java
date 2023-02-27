package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-04-10
 */
class ExcelSheetColumnNumberTest extends AbstractTest<ExcelSheetColumnNumber> {
    @Override
    protected Testsuite<ExcelSheetColumnNumber> testsuite() {
        return Testsuite.<ExcelSheetColumnNumber>builder()
                .add(ExpectedTestcase.of(t->t.titleToNumber("A"), 1))
                .add(ExpectedTestcase.of(t->t.titleToNumber("AB"), 28))
                .add(ExpectedTestcase.of(t->t.titleToNumber("ZY"), 701))
                .build();
    }
}