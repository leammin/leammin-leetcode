package com.leammin.leetcode.main;

import java.util.Scanner;

/**
 * @author Leammin
 * @date 2019-07-13
 */
public final class Leetcoder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in)
                .useDelimiter("\n");
        System.out.print("请输入id/title/url: ");
        String key = sc.next();

        Question question = LeetcodeQuestions.getQuestion(key);
        System.out.println("\n" + LeetcodeClass.getClassName(question));
        System.out.println(question.getJavaCode());
        try {
            LeetcodeClass.createTestFile(question);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        LeetcodeClass.createCodeFile(question);
    }

}
