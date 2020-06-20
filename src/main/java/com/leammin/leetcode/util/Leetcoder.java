package com.leammin.leetcode.util;

import com.google.common.base.Splitter;
import com.google.common.collect.Streams;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Leammin
 * @date 2019-07-13
 */
public final class Leetcoder {


    private static Question getQuestion(String key) {
        List<Question> allQuestions = LeetcodeFiles.getAllQuestionsFromFile();
        return getQuestionByKey(allQuestions, key)
                .or(() -> getQuestionByKey(LeetcodeFiles.getAllQuestions(), key))
                .orElseThrow(() -> new RuntimeException("该 key 不存在: " + key));
    }

    private static Optional<Question> getQuestionByKey(List<Question> allQuestions, String key) {
        return allQuestions.stream()
                .filter(question -> Objects.equals(question.getQuestionFrontendId(), key) ||
                        Objects.equals(question.getTitleSlug(), key) ||
                        Objects.equals(question.getTitle(), key) ||
                        Objects.equals(question.getTranslatedTitle(), key)
                )
                .findFirst().filter(q -> !q.needInit());
    }

    private static String getClassName(Question question) {
        return Streams.stream(Splitter.on('-').trimResults().omitEmptyStrings().split(question.getTitleSlug()))
                .map(t -> Character.toUpperCase(t.charAt(0)) + (t.length() > 1 ? t.substring(1) : ""))
                .collect(Collectors.joining());
    }

    private static String getPackage(Question question) {
        return "com.leammin.leetcode.undone." + question.getDifficulty().toLowerCase();
    }

    private static String generateCode(Question question) {
        String className = getClassName(question);
        return "package " + getPackage(question) + ";\n" +
                "\n" +
                "/**\n" +
                " * " + question.getQuestionFrontendId() + ". " + question.getTranslatedTitle() + "\n" +
                " * \n" +
                " * " + commentContent(question.getTranslatedContent()) + "\n" +
                " * \n" +
                " * @author Leammin\n" +
                " * @date " + LocalDate.now().toString() + "\n" +
                " */\n" +
                "public interface " + className + " {\n" +
                "    \n" +
                "    class Solution implements " + className + " {\n" +
                "        \n" +
                "    }\n" +
                "}\n";
    }

    private static String commentContent(String content) {
        return content.replace("\n", "\n * ");
    }

    private static Path getCodePath(Question question) {
        return Paths.get("src", "main", "java", "com", "leammin", "leetcode", "undone",
                question.getDifficulty().toLowerCase(),
                getClassName(question) + ".java");
    }

    private static void createCodeFile(Question question) {
        createFile(getCodePath(question), generateCode(question));
    }

    private static void createFile(Path path, String content) {
        File file = path.toFile();
        if (file.exists()) {
            throw new RuntimeException("文件已存在: " + file.getAbsolutePath());
        }
        try {
            Files.createDirectories(path.getParent());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (Writer writer = new BufferedWriter(new FileWriter(file))) {
            writer.append(content);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String generateTest(Question question) {
        String className = getClassName(question);
        return "package " + "com.leammin.leetcode." + question.getDifficulty().toLowerCase() + ";\n" +
                "\n" +
                "import " + getPackage(question) + "." + className + ";\n" +
                "import com.leammin.leetcode.util.AbstractTest;\n" +
                "import com.leammin.leetcode.util.Testsuite;\n" +
                "\n" +
                "/**\n" +
                " * @author Leammin\n" +
                " * @date " + LocalDate.now().toString() + "\n" +
                " */\n" +
                "class " + className + "Test extends AbstractTest<" + className + "> {\n" +
                "    @Override\n" +
                "    protected Testsuite<" + className + "> testsuite() {\n" +
                "        return Testsuite.<" + className + ">builder()\n" +
                "                .build();\n" +
                "    }\n" +
                "}";
    }

    private static Path getTestPath(Question question) {
        return Paths.get("src", "test", "java", "com", "leammin", "leetcode",
                question.getDifficulty().toLowerCase(),
                getClassName(question) + "Test.java");
    }

    private static void createTestFile(Question question) {
        createFile(getTestPath(question), generateTest(question));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in)
                .useDelimiter("\n");
        System.out.println("0.生成全部");
        System.out.println("1.生成代码");
        System.out.println("2.生成测试");
        System.out.print("请输入要执行的操作：");
        int op = sc.nextInt();
        System.out.print("请输入id/title: ");
        String key = sc.next();

        Question question = getQuestion(key);
        System.out.println(question.getJavaCode());
        if (op == 0 || op == 2) {
            createTestFile(question);
        }
        if (op == 0 || op == 1) {
            createCodeFile(question);
        }
    }

}
