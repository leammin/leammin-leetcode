package com.leammin.leetcode.util;

import com.google.common.reflect.TypeToken;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractTest<PROBLEM> {
    private static final Logger logger = LoggerFactory.getLogger(AbstractTest.class);

    protected abstract Testsuite<PROBLEM> testsuite();

    @SuppressWarnings("unchecked")
    protected Class<PROBLEM> problem() {
        TypeToken<PROBLEM> typeToken = new TypeToken<PROBLEM>(getClass()) {
        };
        return (Class<PROBLEM>) typeToken.getRawType();
    }

    protected List<Class<? extends PROBLEM>> solutions() {
        Class<PROBLEM> problem = problem();
        return Stream.of(problem.getDeclaredClasses())
                .map((Function<Class<?>, Class<? extends PROBLEM>>) solution -> solution.asSubclass(problem))
                .sorted(Comparator.comparing(Class::getName))
                .collect(Collectors.toList());
    }

    @Test
    public void test() {
        Testsuite<PROBLEM> testsuite = testsuite();
        Assertions.assertThat(testsuite.isEmpty())
                .withFailMessage("Testsuite cannot be empty")
                .isFalse();

        List<Class<? extends PROBLEM>> solutions = solutions();
        Assertions.assertThat(solutions)
                .withFailMessage("Number of solutions must be greater than zero")
                .hasSizeGreaterThan(0);

        logger.info("Problem: {}", problem().getSimpleName());

        for (Class<? extends PROBLEM> solution : solutions) {
            long time = testsuite.test(solution);
            logger.info("{}-{} Running Time: {}ms", problem().getSimpleName(), solution.getSimpleName(), time / 1000000.0);
        }
    }
}
