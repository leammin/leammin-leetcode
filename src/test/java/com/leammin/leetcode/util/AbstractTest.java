package com.leammin.leetcode.util;

import com.google.common.reflect.TypeToken;
import com.leammin.leetcode.util.test.Testsuite;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractTest<PROBLEM> {
    protected static final Logger logger = LoggerFactory.getLogger(AbstractTest.class);

    @SuppressWarnings("unchecked")
    protected Testsuite<PROBLEM> testsuite() {
        Class<PROBLEM> problem = problem();
        try {
            Method method = problem.getDeclaredMethod("testsuite");
            method.setAccessible(true);
            return (Testsuite<PROBLEM>) method.invoke(null);
        } catch (Throwable e) {
            return (Testsuite<PROBLEM>) Testsuite.builder().build();
        }
    }

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
        Collections.reverse(solutions);
        boolean hasExecute = solutions.stream()
                .map(s -> s.getDeclaredAnnotation(Execute.class))
                .anyMatch(e -> e != null && e.value());
        return solutions.stream()
                .filter(s -> {
                    Execute execute = s.getDeclaredAnnotation(Execute.class);
                    return (!hasExecute && execute == null) ||
                            (hasExecute && execute != null && execute.value());
                })
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
        if (solutions.isEmpty()) {
            throw new IllegalArgumentException("Number of solutions must be greater than zero");
        }

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
