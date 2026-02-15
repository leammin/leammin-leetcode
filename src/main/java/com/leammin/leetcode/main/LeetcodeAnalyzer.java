package com.leammin.leetcode.main;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LeetcodeAnalyzer {

    public static void main(String[] args) {
        List<Question> allQuestions = LeetcodeQuestions.getAllQuestions();
        Map<String, Long> map = allQuestions
            .stream()
            .map(Question::getDifficulty)
            .map(d -> d == null ? "unknown" : d)
            .map(String::toLowerCase)
            .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        map.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
    }
}
