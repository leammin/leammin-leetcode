package com.leammin.leetcode.main;

import java.util.Scanner;

/**
 * @author Leammin
 * @date 2019-07-13
 */
public final class Leetcoder {

    public static void main(String[] args) {
        String key;
        if (args.length > 0) {
            key = args[0];
        } else {
            Scanner sc = new Scanner(System.in).useDelimiter("\n");
            System.out.print("请输入id/title/url: ");
            key = sc.next();
        }

        Question question = LeetcodeQuestions.getQuestion(key);
        System.out.println("\n" + LeetcodeClass.getClassName(question));
        System.out.println(question.getJavaCode());
        LeetcodeClass.createCodeFile(question);
    }
}
