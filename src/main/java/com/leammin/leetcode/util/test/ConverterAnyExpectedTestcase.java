package com.leammin.leetcode.util.test;

import com.leammin.leetcode.easy.AddBinary;
import com.leammin.leetcode.util.convert.Converter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ConverterAnyExpectedTestcase<PROBLEM, OUTPUT> implements AnyExpectedTestcase<PROBLEM, OUTPUT> {
    private static final Map<Class<?>, Converter<?>> converters = new HashMap<>();


    private final Function<Class<? extends PROBLEM>, PROBLEM> solutionProducer;

    // string input/output
    private final String stringInput;
    private final List<String> stringExpected;

    // problem
    private Class<PROBLEM> problemClass;
    private Method problemMethod;
    private Class<?> returnType;
    private Class<?>[] parameterTypes;

    // object input/output
    private Object[] input;
    private Iterable<Object> excepted;

    public ConverterAnyExpectedTestcase() {
        this("", "");
    }

    public ConverterAnyExpectedTestcase(String input, String... expected) {
        this.solutionProducer = TestcaseUtils.defaultSolutionProducer();
        this.stringInput = input;
        this.stringExpected = List.of(expected);
    }

    @Override
    public Iterable<OUTPUT> anyExpected() {

        return null;
    }

    @Override
    public OUTPUT run(PROBLEM solution) {
        if (this.problemClass == null) {
            initProblem(solution.getClass());
        }
        return null;
    }

    @Override
    public PROBLEM solution(Class<? extends PROBLEM> clazz) throws ReflectiveOperationException {
        if (this.problemClass == null) {
            initProblem(clazz);
        }
        return solutionProducer.apply(clazz);
    }

    private void initProblem(Class<?> solutionClass) {
        this.problemClass = findProblemClass(solutionClass);
        this.problemMethod = findProblemMethod(problemClass);
        this.returnType = problemMethod.getReturnType();
        this.parameterTypes = problemMethod.getParameterTypes();

    }

    private Class<PROBLEM> findProblemClass(Class<?> solutionClass) {
        Class<?>[] interfaces = solutionClass.getInterfaces();
        Class<PROBLEM> problemClass = null;
        for (Class<?> anInterface : interfaces) {
            String packageName = anInterface.getPackageName();
            if (packageName.contains("easy") || packageName.contains("hard") || packageName.contains("medium")) {
                problemClass = (Class<PROBLEM>) anInterface;
                break;
            }
        }
        if (problemClass == null) {
            throw new RuntimeException("can not find the problem interface " + solutionClass.getSimpleName());
        }
        return problemClass;
    }

    private Method findProblemMethod(Class<PROBLEM> problemClass) {
        Method[] problemMethods = problemClass.getDeclaredMethods();
        if (problemMethods.length != 1) {
            throw new RuntimeException("can not find the problem method " + problemClass.getSimpleName());
        }
        return problemMethods[0];
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        ConverterAnyExpectedTestcase<AddBinary.Solution, Object> t = new ConverterAnyExpectedTestcase<>();
        Method problemMethod = t.findProblemMethod(AddBinary.Solution.class);
        System.out.println(problemMethod.getReturnType());
        System.out.println(problemMethod.getReturnType().equals(String.class));
        AddBinary.Solution solution = new AddBinary.Solution();
        Object invoke = problemMethod.invoke(solution, "11", "1");
        System.out.println(invoke);
    }
}
