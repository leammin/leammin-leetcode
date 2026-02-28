package com.leammin.leetcode.main;

import java.nio.file.Path;

/**
 * 将题目从难度目录移回 todo 目录，并更新 package 声明。
 * 移动成功后自动 git commit & push。
 * 重复执行仅提醒，不报错；若有未提交/未推送的变更会自动补上。
 *
 * @author Leammin
 */
public final class LeetcodeTodo {

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

        Path donePath = LeetcodeClass.donePath(difficulty, className);
        Path todoPath = LeetcodeClass.todoPath(difficulty, className);

        if (donePath.toFile().exists()) {
            LeetcodeClass.moveFile(donePath, todoPath,
                    "com.leammin.leetcode." + difficulty,
                    "com.leammin.leetcode.todo." + difficulty);
            System.out.println("撤回: " + donePath + " -> " + todoPath);
        } else if (todoPath.toFile().exists()) {
            System.out.println("题目已在未完成目录: " + todoPath);
        } else {
            System.err.println("文件不存在: " + donePath);
            System.exit(1);
            return;
        }

        LeetcodeResolver.gitCommit("todo: " + className,
                donePath.toString(), todoPath.toString());
    }
}
