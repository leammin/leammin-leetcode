package com.leammin.leetcode.util;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.util.List;

public abstract class AbstractTest<PROBLEM> {
    protected SoftAssertions assertions;

    public abstract List<Testcase<PROBLEM>> testcases();



    @BeforeAll
    public void beforeAll() {
        assertions = new SoftAssertions();
    }

    @AfterAll
    public void assertAll() {
        assertions.assertAll();
    }
}
