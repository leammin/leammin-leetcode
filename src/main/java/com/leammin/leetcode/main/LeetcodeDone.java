package com.leammin.leetcode.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * 将题目从 undone 目录移动到对应的难度目录，并更新 package 声明。
 * 重复执行仅提醒，不报错。
 *
 * @author Leammin
 */
public final class LeetcodeDone {

    private static final String BASE = "src/main/java/com/leammin/leetcode";

    public static void main(String[] args) {
        String key;
        if (args.length > 0 && !args[0].isEmpty()) {
            key = args[0];
        } else {
            System.err.print("请输入id/title/url: ");
            Scanner sc = new Scanner(System.in).useDelimiter("\n");
            key = sc.next();
        }

        String className;
        String difficulty;

        try {
            Question question = LeetcodeQuestions.getQuestion(key);
            className = LeetcodeClass.getClassName(question);
            difficulty = question.getDifficulty().toLowerCase();
        } catch (RuntimeException e) {
            className = key;
            difficulty = findDifficulty(className);
            if (difficulty == null) {
                System.err.println("未找到题目: " + key);
                System.exit(1);
                return;
            }
        }

        Path donePath = Paths.get(BASE, difficulty, className + ".java");
        Path undonePath = Paths.get(BASE, "undone", difficulty, className + ".java");

        if (donePath.toFile().exists()) {
            System.out.println("题目已完成，无需移动: " + donePath);
            return;
        }

        if (!undonePath.toFile().exists()) {
            System.err.println("文件不存在: " + undonePath);
            System.exit(1);
            return;
        }

        try {
            String content = Files.readString(undonePath);
            content = content.replace(
                    "package com.leammin.leetcode.undone." + difficulty,
                    "package com.leammin.leetcode." + difficulty
            );
            Files.createDirectories(donePath.getParent());
            Files.writeString(donePath, content);
            Files.delete(undonePath);
            System.out.println("完成: " + undonePath + " -> " + donePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String findDifficulty(String className) {
        for (String diff : new String[]{"easy", "medium", "hard"}) {
            if (Paths.get(BASE, "undone", diff, className + ".java").toFile().exists()
                    || Paths.get(BASE, diff, className + ".java").toFile().exists()) {
                return diff;
            }
        }
        return null;
    }
}
