package com.leammin.leetcode.util.leetcode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class LeetcodeQuestions {
    private static final Path LEETCODE_FILE_PATH = Paths.get("src", "main", "resources", "leetcode.json");


    public static void writeLeetcodeFile(List<Question> questions) {
        String questionStr = JSON.toJSONString(questions, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);

        try {
            Files.writeString(LEETCODE_FILE_PATH, questionStr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Question> getAllQuestionsFromFile() {
        try {
            String questionStr = Files.readString(LEETCODE_FILE_PATH);
            return JSONArray.parseArray(questionStr, Question.class).stream()
                    .filter(q -> !q.needInit()).collect(Collectors.toList());
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

        List<Question> fileNotExist = questionsFromLeetcode.stream()
                .filter(q -> !idsFromFile.contains(q.getQuestionId()))
                .collect(Collectors.toList());
        questionsFromFile.addAll(fileNotExist);
        try {
            for (Question question : questionsFromFile) {
                if (question.needInit()) {
                    System.out.println("初始化中: " + question);
                    question.init();
                }
            }
        } finally {
            LeetcodeQuestions.writeLeetcodeFile(questionsFromFile);
        }
        return questionsFromFile;
    }

    public static Question getQuestion(String key) {
        List<Question> allQuestions = getAllQuestionsFromFile();
        return getQuestionByKey(allQuestions, key)
                .or(() -> getQuestionByKey(getAllQuestions(), key))
                .orElseThrow(() -> new RuntimeException("该 key 不存在: " + key));
    }

    private static Optional<Question> getQuestionByKey(List<Question> allQuestions, String key) {
        return allQuestions.stream()
                .filter(question -> Objects.equals(question.getQuestionFrontendId(), key) ||
                        Objects.equals(question.getTitleSlug(), key) ||
                        Objects.equals(question.getTitle(), key) ||
                        Objects.equals(question.getTranslatedTitle(), key)
                )
                .findFirst().filter(q -> !q.needInit());
    }

    public static void main(String[] args) {
        getAllQuestions();
    }
}
