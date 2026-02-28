package com.leammin.leetcode.main;

import com.google.common.base.Splitter;
import com.google.common.collect.Streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class LeetcodeClass {

    private static final String BASE = "src/main/java/com/leammin/leetcode";

    static Path todoPath(String difficulty, String className) {
        return Paths.get(BASE, "todo", difficulty, className + ".java");
    }

    static Path donePath(String difficulty, String className) {
        return Paths.get(BASE, difficulty, className + ".java");
    }

    static void moveFile(Path from, Path to, String fromPkg, String toPkg) {
        try {
            String content = Files.readString(from);
            content = content.replace("package " + fromPkg, "package " + toPkg);
            Files.createDirectories(to.getParent());
            Files.writeString(to, content);
            Files.delete(from);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getClassName(Question question) {
        String titleSlug = question.getTitleSlug();
        char fst = titleSlug.charAt(0);
        if (!Character.isLowerCase(fst) && !Character.isUpperCase(fst)) {
            titleSlug = "L" + titleSlug;
        }
        return Streams.stream(Splitter.on('-').trimResults().omitEmptyStrings().split(titleSlug))
                .map(t -> Character.toUpperCase(t.charAt(0)) + (t.length() > 1 ? t.substring(1) : ""))
                .collect(Collectors.joining());
    }

    private static String getPackage(Question question) {
        return "com.leammin.leetcode.todo." + question.getDifficulty().toLowerCase();
    }

    private static String generateCode(Question question) {
        String className = getClassName(question);
        return "package " + getPackage(question) + ";\n" +
                "\n" +
                "import com.leammin.leetcode.util.test.AbstractTest;\n" +
                "import com.leammin.leetcode.util.test.Testsuite;\n" +
                "\n" +
                "/**\n" +
                " * <a href=\"https://leetcode.cn/problems/" + question.getTitleSlug() + "/\">" + question.getQuestionFrontendId() + ". " + question.getTranslatedTitle() + "</a>\n" +
                " * \n" +
                " * " + commentContent(question.getTranslatedContent()) + "\n" +
                " * \n" +
                " * @author Leammin\n" +
                " * @date " + LocalDate.now() + "\n" +
                " */\n" +
                "public interface " + className + " {\n" +
                "    \n" +
                "    static Testsuite<" + className + "> testsuite() {\n" +
                "        return Testsuite.<" + className + ">builder()\n" +
                "                .build();\n" +
                "    }\n" +
                "\n" +
                "    class Solution implements " + className + " {\n" +
                "        \n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "class " + className + "Test extends AbstractTest<" + className + "> {\n" +
                "}\n";
    }

    private static String commentContent(String content) {
        return content.replace("\n", "\n * ");
    }

    private static void createFile(Path path, String content) {
        if (Files.exists(path)) {
            throw new RuntimeException("文件已存在: " + path.toAbsolutePath());
        }
        try {
            Files.createDirectories(path.getParent());
            Files.writeString(path, content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createCodeFile(Question question) {
        String difficulty = question.getDifficulty().toLowerCase();
        createFile(todoPath(difficulty, getClassName(question)), generateCode(question));
    }


}
