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
            return Arrays.asList(questions);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Question> getAllQuestions() {
        List<Question> questionsFromLeetcode = LeetcodeRequests.problemsAll();
        List<Question> questionsFromFile = LeetcodeQuestions.getAllQuestionsFromFile();
        Set<String> titleFromFile = questionsFromFile.stream()
                .map(Question::getTitleSlug)
                .collect(Collectors.toSet());
        Set<String> titleFromLeetcode = questionsFromLeetcode.stream()
                .map(Question::getTitleSlug)
                .collect(Collectors.toSet());

        Stream<Question> fileNotExist = questionsFromLeetcode.stream().filter(q -> !titleFromFile.contains(q.getTitleSlug()));
        List<Question> allQuestions = Stream.concat(questionsFromFile.stream(), fileNotExist)
                .filter(q -> {
                    boolean inLeetcode = titleFromLeetcode.contains(q.getTitleSlug());
                    if (!inLeetcode) {
                        System.out.println("删除: " + q.getTitleSlug());
                    }
                    return inLeetcode;
                })
                .sorted(Comparator.comparingInt(q -> Integer.parseInt(q.getQuestionId())))
                .collect(Collectors.toList());
        try {
            int initCount = 0;
            for (int i = 0; i < allQuestions.size(); i++) {
                Question q = allQuestions.get(i);
                if (q.needInit()) {
                    if (initCount != 0) {
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.printf("初始化中(%d): %s\n", i, q.getTitleSlug());
                    Question nq = LeetcodeRequests.questionData(q.getTitleSlug());
                    allQuestions.set(i, nq);
                    initCount++;
                    if (initCount % 10 == 0) {
                        LeetcodeQuestions.writeLeetcodeFile(allQuestions);
                    }
                }
            }
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
