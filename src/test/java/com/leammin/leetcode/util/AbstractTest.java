package com.leammin.leetcode.util;

import com.leammin.leetcode.easy.RangeSumQueryImmutable;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractTest<PROBLEM> {
    protected abstract Testsuite<PROBLEM> testsuite();

    @SuppressWarnings("unchecked")
    protected Class<PROBLEM> problem() {
        return (Class<PROBLEM>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected List<Class<? extends PROBLEM>> solutions() {
        Class<PROBLEM> problem = problem();
        return Stream.of(problem.getDeclaredClasses())
                .map((Function<Class<?>, Class<? extends PROBLEM>>) solution -> solution.asSubclass(problem))
                .collect(Collectors.toList());
    }

    @Test
    public void test() {
        Testsuite<PROBLEM> testsuite = testsuite();
        List<Class<? extends PROBLEM>> solutions = solutions();
        for (Class<? extends PROBLEM> solution : solutions) {
            long time = testsuite.test(solution);
            print(solution, time);
        }
    }

    private void print(Class<? extends PROBLEM> solution, long time) {
        System.out.println(ClassUtils.getSolutionName(solution) + ": " + time / 1000000.0 + "ms");
    }
}
