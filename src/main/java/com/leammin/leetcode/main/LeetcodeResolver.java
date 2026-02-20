package com.leammin.leetcode.main;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * 解析题目标识（id/title/url/类名）并输出对应的测试类全限定名。
 * 供 Makefile test 目标调用。
 *
 * @author Leammin
 */
public final class LeetcodeResolver {

    private static final String BASE = "src/main/java/com/leammin/leetcode";
    private static final String[] SEARCH_DIRS = {
            "easy", "medium", "hard",
            "undone/easy", "undone/medium", "undone/hard"
    };

    public static void main(String[] args) {
        String key;
        if (args.length > 0 && !args[0].isEmpty()) {
            key = args[0];
        } else {
            System.err.print("请输入id/title/url: ");
            Scanner sc = new Scanner(System.in).useDelimiter("\n");
            key = sc.next();
        }

        String testClass = findTestClass(key);
        if (testClass != null) {
            System.out.println("TEST:" + testClass);
            return;
        }

        try {
            Question question = LeetcodeQuestions.getQuestion(key);
            String className = LeetcodeClass.getClassName(question);
            testClass = findTestClass(className);
            if (testClass != null) {
                System.out.println("TEST:" + testClass);
                return;
            }
            System.err.println("文件未找到: " + className + ".java");
        } catch (RuntimeException e) {
            System.err.println("未找到题目: " + key);
        }
        System.exit(1);
    }

    static String findTestClass(String className) {
        for (String dir : SEARCH_DIRS) {
            Path path = Paths.get(BASE, dir.split("/")).resolve(className + ".java");
            if (path.toFile().exists()) {
                String pkg = "com.leammin.leetcode." + dir.replace('/', '.');
                return pkg + "." + className + "Test";
            }
        }
        return null;
    }
}
