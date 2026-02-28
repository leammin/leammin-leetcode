package com.leammin.leetcode.main;

import java.nio.file.Path;

/**
 * @author Leammin
 * @date 2019-07-13
 */
public final class Leetcoder {

    public static void main(String[] args) {
        String key = LeetcodeResolver.readKey(args);

        Question question = LeetcodeQuestions.getQuestion(key);
        String className = LeetcodeClass.getClassName(question);
        String difficulty = question.getDifficulty().toLowerCase();

        System.out.println("\n" + className);
        System.out.println(question.getJavaCode());
        
        Path todoPath = LeetcodeClass.todoPath(difficulty, className);
        Path donePath = LeetcodeClass.donePath(difficulty, className);
        if (todoPath.toFile().exists()) {
            System.out.println("题目已存在(todo): " + todoPath);
            return;
        }
        if (donePath.toFile().exists()) {
            System.out.println("题目已存在(done): " + donePath);
            return;
        }

        LeetcodeClass.createCodeFile(question);
    }
}
