package com.leammin.leetcode.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class LeetcodeClass {

    private static final String BASE = "src/main/java/com/leammin/leetcode";

    static Path todoPath(String difficulty, String className) {
        return Paths.get(BASE, "todo", difficulty, className + ".java");
    }

    static Path donePath(String difficulty, String className) {
        return Paths.get(BASE, difficulty, className + ".java");
    }

    static String todoPackage(String difficulty) {
        return "com.leammin.leetcode.todo." + difficulty;
    }

    static String donePackage(String difficulty) {
        return "com.leammin.leetcode." + difficulty;
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

    private static String generateCode(Question question) {
        String className = question.getClassName();
        return "package " + todoPackage(question.getDifficulty().toLowerCase()) + ";\n" +
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
        createFile(todoPath(difficulty, question.getClassName()), generateCode(question));
    }


}
