package com.leammin.leetcode.main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeetcodeQuestions {
    private static final Path LEETCODE_FILE_PATH = Paths.get("src", "main", "resources", "leetcode.json");

    public static void writeLeetcodeFile(List<Question> questions) {
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().disableHtmlEscaping().create();
        String questionStr = gson.toJson(questions);
        try {
            Files.writeString(LEETCODE_FILE_PATH, questionStr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Question> getAllQuestionsFromFile() {
        try {
            String questionStr = Files.readString(LEETCODE_FILE_PATH);
            Question[] questions = new GsonBuilder().create().fromJson(questionStr, Question[].class);
            return Arrays.stream(questions)
                    .filter(q -> !q.needInit())
                    .toList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Question> getAllQuestions() {
        List<Question> questionsFromLeetcode = LeetcodeRequests.problemsAll();
        List<Question> questionsFromFile = LeetcodeQuestions.getAllQuestionsFromFile();
        Set<String> idsFromFile = questionsFromFile.stream()
                .map(Question::getQuestionId)
                .collect(Collectors.toSet());

        Stream<Question> fileNotExist = questionsFromLeetcode.stream().filter(q -> !idsFromFile.contains(q.getQuestionId()));
        List<Question> allQuestions = Stream.concat(questionsFromFile.stream(), fileNotExist)
                .toList();
        try {
            allQuestions.stream()
                    .filter(Question::needInit)
                    .forEach(q -> {
                        System.out.println("初始化中: " + q);
                        q.init();
                    });
        } finally {
            LeetcodeQuestions.writeLeetcodeFile(allQuestions);
        }
        return allQuestions;
    }

    private static Optional<Question> getQuestionByKey(List<Question> allQuestions, String key) {
        return allQuestions.stream()
                .filter(question -> Objects.equals(question.getQuestionFrontendId(), key) ||
                        Objects.equals(question.getTitleSlug(), key) ||
                        Objects.equals(question.getTitle(), key) ||
                        Objects.equals(question.getTranslatedTitle(), key)
                )
                .filter(q -> !q.needInit())
                .findFirst();
    }

    public static Question getQuestion(String key) {
        final String finalKey = handleKey(key);
        List<Question> allQuestions = getAllQuestionsFromFile();
        return getQuestionByKey(allQuestions, finalKey)
                .or(() -> getQuestionByKey(getAllQuestions(), finalKey))
                .orElseThrow(() -> new RuntimeException("该 key 不存在: " + finalKey));
    }

    private final static Pattern urlRegex = Pattern.compile(".*leetcode.cn/problems/([A-Za-z0-9-]+).*");

    private static String handleKey(String key) {
        // https://leetcode.cn/problems/count-nice-pairs-in-an-array/
        Matcher matcher = urlRegex.matcher(key);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return key;
    }
}
