package com.leammin.leetcode.main;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 解析题目标识（id/title/url/类名）并运行对应的测试。
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
        String key = readKey(args);
        String testClass = resolve(key);
        System.out.println("Running: " + testClass);
        System.exit(exec("mvn", "test", "-Dtest=" + testClass));
    }

    private static String resolve(String key) {
        String testClass = findTestClass(key);
        if (testClass != null) {
            return testClass;
        }
        try {
            Question question = LeetcodeQuestions.getQuestion(key);
            String className = LeetcodeClass.getClassName(question);
            testClass = findTestClass(className);
            if (testClass != null) {
                return testClass;
            }
            System.err.println("文件未找到: " + className + ".java");
        } catch (RuntimeException e) {
            System.err.println("未找到题目: " + key);
        }
        System.exit(1);
        return null;
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

    static String readKey(String[] args) {
        if (args.length > 0 && !args[0].isEmpty()) {
            return args[0];
        }
        System.out.print("请输入id/title/url: ");
        return new Scanner(System.in).useDelimiter("\n").next();
    }

    static String findDifficulty(String className) {
        for (String diff : new String[]{"easy", "medium", "hard"}) {
            if (Paths.get(BASE, "undone", diff, className + ".java").toFile().exists()
                    || Paths.get(BASE, diff, className + ".java").toFile().exists()) {
                return diff;
            }
        }
        return null;
    }

    static void gitCommit(String commitMessage, String... paths) {
        List<String> toStage = new ArrayList<>();
        for (String path : paths) {
            if (Paths.get(path).toFile().exists()
                    || execQuiet("git", "ls-files", "--error-unmatch", "--", path) == 0) {
                toStage.add(path);
            }
        }
        if (toStage.isEmpty()) {
            return;
        }
        List<String> addCmd = new ArrayList<>(List.of("git", "add", "--"));
        addCmd.addAll(toStage);
        execQuiet(addCmd.toArray(new String[0]));

        List<String> diffCmd = new ArrayList<>(List.of("git", "diff", "--cached", "--quiet", "--"));
        diffCmd.addAll(toStage);
        if (execQuiet(diffCmd.toArray(new String[0])) != 0) {
            List<String> commitCmd = new ArrayList<>(List.of("git", "commit", "-m", commitMessage, "--"));
            commitCmd.addAll(toStage);
            exec(commitCmd.toArray(new String[0]));
        }
    }

    static int exec(String... command) {
        return exec(true, command);
    }

    static int execQuiet(String... command) {
        return exec(false, command);
    }

    private static int exec(boolean inheritIO, String... command) {
        try {
            List<String> cmd = new ArrayList<>();
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                cmd.add("cmd.exe");
                cmd.add("/c");
            }
            Collections.addAll(cmd, command);
            ProcessBuilder pb = new ProcessBuilder(cmd);
            if (inheritIO) {
                pb.inheritIO();
            } else {
                pb.redirectOutput(ProcessBuilder.Redirect.DISCARD);
                pb.redirectError(ProcessBuilder.Redirect.DISCARD);
            }
            return pb.start().waitFor();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
