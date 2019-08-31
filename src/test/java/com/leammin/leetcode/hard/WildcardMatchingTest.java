package com.leammin.leetcode.hard;

import com.leammin.leetcode.undone.hard.WildcardMatching;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-08-31
 */
class WildcardMatchingTest extends AbstractTest<WildcardMatching> {
    @Override
    protected Testsuite<WildcardMatching> testsuite() {
        return Testsuite.<WildcardMatching>builder()
                .add(ExpectedTestcase.of(false, t -> t.isMatch("aa", "a")))
                .add(ExpectedTestcase.of(false, t -> t.isMatch("cb", "?a")))
                .add(ExpectedTestcase.of(false, t -> t.isMatch("acdcb", "a*c?b")))
                .add(ExpectedTestcase.of(true, t -> t.isMatch("aa", "*")))
                .add(ExpectedTestcase.of(true, t -> t.isMatch("adceb", "*a*b")))
                .add(ExpectedTestcase.of(true, t -> t.isMatch("adcasdeb", "*a*d*")))
                .add(ExpectedTestcase.of(true, t -> t.isMatch("aaaa", "***a")))
                .add(ExpectedTestcase.of(true, t -> t.isMatch("", "*")))
                .add(ExpectedTestcase.of(true, t -> t.isMatch("c", "*?*")))
                .add(ExpectedTestcase.of(true, t -> t.isMatch("ho", "ho**")))
                .add(ExpectedTestcase.of(false, t -> t.isMatch("mississippi", "m??*ss*?i*pi")))
                .add(ExpectedTestcase.of(false, t -> t.isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbabababa", "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b*")))
                .add(ExpectedTestcase.of(false, t -> t.isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb", "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb")))
                .build();
    }
}