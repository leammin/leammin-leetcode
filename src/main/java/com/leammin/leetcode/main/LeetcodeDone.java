package com.leammin.leetcode.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 将题目从 undone 目录移动到对应的难度目录，并更新 package 声明。
 * 移动成功后自动 git commit & push。
 * 重复执行仅提醒，不报错；若有未提交/未推送的变更会自动补上。
 *
 * @author Leammin
 */
public final class LeetcodeDone {

    private static final String BASE = "src/main/java/com/leammin/leetcode";

    public static void main(String[] args) {
        String key = LeetcodeResolver.readKey(args);

        String className;
        String difficulty;

        try {
            Question question = LeetcodeQuestions.getQuestion(key);
            className = LeetcodeClass.getClassName(question);
            difficulty = question.getDifficulty().toLowerCase();
        } catch (RuntimeException e) {
            className = key;
            difficulty = LeetcodeResolver.findDifficulty(className);
            if (difficulty == null) {
                System.err.println("未找到题目: " + key);
                System.exit(1);
                return;
            }
        }

        Path donePath = Paths.get(BASE, difficulty, className + ".java");
        Path undonePath = Paths.get(BASE, "undone", difficulty, className + ".java");

        if (undonePath.toFile().exists()) {
            moveFile(undonePath, donePath, difficulty);
            System.out.println("完成: " + undonePath + " -> " + donePath);
        } else if (donePath.toFile().exists()) {
            System.out.println("题目已完成: " + donePath);
        } else {
            System.err.println("文件不存在: " + undonePath);
            System.exit(1);
            return;
        }

        LeetcodeResolver.gitCommit("done: " + className,
                donePath.toString(), undonePath.toString());
    }

    private static void moveFile(Path from, Path to, String difficulty) {
        try {
            String content = Files.readString(from);
            content = content.replace(
                    "package com.leammin.leetcode.undone." + difficulty,
                    "package com.leammin.leetcode." + difficulty
            );
            Files.createDirectories(to.getParent());
            Files.writeString(to, content);
            Files.delete(from);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
