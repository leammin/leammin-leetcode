package com.leammin.leetcode.hard;

import com.leammin.leetcode.undone.hard.WildcardMatching;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2019-08-31
 */
class WildcardMatchingTest extends AbstractTest<WildcardMatching> {
    @Override
    protected Testsuite<WildcardMatching> testsuite() {
        return Testsuite.<WildcardMatching>builder()
                .add(ExpectedTestcase.of(t -> t.isMatch("aa", "a"), false))
                .add(ExpectedTestcase.of(t -> t.isMatch("cb", "?a"), false))
                .add(ExpectedTestcase.of(t -> t.isMatch("acdcb", "a*c?b"), false))
                .add(ExpectedTestcase.of(t -> t.isMatch("aa", "*"), true))
                .add(ExpectedTestcase.of(t -> t.isMatch("adceb", "*a*b"), true))
                .add(ExpectedTestcase.of(t -> t.isMatch("adcasdeb", "*a*d*"), true))
                .add(ExpectedTestcase.of(t -> t.isMatch("aaaa", "***a"), true))
                .add(ExpectedTestcase.of(t -> t.isMatch("", "*"), true))
                .add(ExpectedTestcase.of(t -> t.isMatch("c", "*?*"), true))
                .add(ExpectedTestcase.of(t -> t.isMatch("ho", "ho**"), true))
                .add(ExpectedTestcase.of(t -> t.isMatch("mississippi", "m??*ss*?i*pi"), false))
                .add(ExpectedTestcase.of(t -> t.isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbabababa", "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b*"), false))
                .add(ExpectedTestcase.of(t -> t.isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb", "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"), false))
                .build();
    }
}