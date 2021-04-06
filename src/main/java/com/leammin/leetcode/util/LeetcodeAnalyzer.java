package com.leammin.leetcode.util;

import com.leammin.leetcode.util.leetcode.LeetcodeQuestions;
import com.leammin.leetcode.util.leetcode.Question;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LeetcodeAnalyzer {
    public static void main(String[] args) {
        List<Question> allQuestions = LeetcodeQuestions.getAllQuestions();
        Map<String, Long> map = allQuestions.stream()
                .map(Question::getDifficulty)
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        System.out.println("easy: " + map.remove("easy"));
        System.out.println("medium: " + map.remove("medium"));
        System.out.println("hard: " + map.remove("hard"));
    }
}
