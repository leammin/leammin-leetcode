package com.leammin.leetcode.util;

import com.google.common.reflect.TypeToken;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        List<Class<? extends PROBLEM>> solutions = Stream.of(problem.getDeclaredClasses())
                .filter(problem::isAssignableFrom)
                .map((Function<Class<?>, Class<? extends PROBLEM>>) solution -> solution.asSubclass(problem))
                .collect(Collectors.toList());
        boolean hasSolutionAnnotation = solutions.stream()
                .anyMatch(s -> s.getDeclaredAnnotation(Execute.class) != null);
        if (!hasSolutionAnnotation) {
            return solutions;
        }
        return solutions.stream()
                .filter(s -> s.getDeclaredAnnotation(Execute.class) != null)
                .collect(Collectors.toList());
    }

    @Test
    public void test() {
        Testsuite<PROBLEM> testsuite = testsuite();
        if (testsuite.isEmpty()) {
            logger.warn("Testsuite is empty");
            return;
        }

        List<Class<? extends PROBLEM>> solutions = solutions();
        Assertions.assertThat(solutions)
                .withFailMessage("Number of solutions must be greater than zero")
                .hasSizeGreaterThan(0);

        logger.info("Problem: {}", problem().getSimpleName());
        for (Class<? extends PROBLEM> solution : solutions) {
            test(testsuite, solution);
        }
    }

    private void test(Testsuite<PROBLEM> testsuite, Class<? extends PROBLEM> solution) {
        Execute execute = solution.getDeclaredAnnotation(Execute.class);
        if (execute != null && !execute.value()) {
            return;
        }
        long time;
        if (execute == null) {
            time = testsuite.test(solution);
        } else {
            time = testsuite.test(solution, execute.cases());
        }
        logger.info("{}-{} Running Time: {}ms", problem().getSimpleName(), solution.getSimpleName(), time / 1000000.0);
    }
}
