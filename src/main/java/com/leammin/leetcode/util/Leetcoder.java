package com.leammin.leetcode.util;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.gson.*;
import org.apache.commons.codec.Charsets;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author Leammin
 * @date 2019-07-13
 */
public final class Leetcoder {
    static {
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");

        System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");

        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.commons.httpclient", "debug");// "stdout"为标准输出格式，"debug"为调试模式
    }
    private static final CloseableHttpClient HTTP_CLIENT = HttpClientBuilder.create().build();
    private static final String LEETCODE_ALL_PROBLEMS_URL = "https://leetcode.com/api/problems/all";
    private static final String LEETCODE_GRAPHQL_URL = "https://leetcode-cn.com/graphql";
    private static final Path LEETCODE_FILE_PATH = Paths.get("src", "main", "resources", "leetcode.txt");

    private static Map<String, String> getAllProblems() {
        Map<String, String> result = new TreeMap<>(Comparator.comparingInt(Integer::valueOf));
        HttpGet httpGet = new HttpGet(LEETCODE_ALL_PROBLEMS_URL);
        try (CloseableHttpResponse response = HTTP_CLIENT.execute(httpGet)) {
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("获取列表失败：code=" + response.getStatusLine().getStatusCode()
                        + " message=" + EntityUtils.toString(response.getEntity()));
            }
            InputStreamReader reader = new InputStreamReader(new BufferedInputStream(response.getEntity().getContent()), Charsets.UTF_8);
            JsonObject json = new JsonParser().parse(reader).getAsJsonObject();
            JsonArray array = json.getAsJsonArray("stat_status_pairs");
            for (JsonElement jsonElement : array) {
                JsonObject stat = jsonElement.getAsJsonObject().getAsJsonObject("stat");
                String questionId = stat.getAsJsonPrimitive("question_id").getAsString();
                String questionTitleSlug = stat.getAsJsonPrimitive("question__title_slug").getAsString();
                result.put(questionId, questionTitleSlug);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private static void writeProblemsFile() {
        Map<String, String> problems = getAllProblems();
        String result = new GsonBuilder().setPrettyPrinting().create().toJson(problems);
        File file = LEETCODE_FILE_PATH.toFile();
        try(Writer writer = new BufferedWriter(new FileWriter(file))) {
            writer.append(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    private static Map<String, String> readProblemsFile() {
        File file = LEETCODE_FILE_PATH.toFile();
        if (!file.exists()) {
            return Collections.emptyMap();
        }
        try {
            return new Gson().fromJson(new BufferedReader(new FileReader(file)), Map.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getTitleSlug(String questionId) {
        Map<String, String> problems = readProblemsFile();
        if (problems == null || problems.isEmpty()) {
            writeProblemsFile();
            problems = readProblemsFile();
            if (problems == null || problems.isEmpty()) {
                throw new RuntimeException("无法获取列表");
            }
        }
        String titleSlug = problems.get(questionId);
        if (titleSlug == null) {
            throw new RuntimeException("不存在此questionId：" + questionId);
        }
        return titleSlug;
    }

    private static String getQuestionDataParams(String titleSlug) {
        List<String> propertiesList = Arrays.asList("questionId", "content", "difficulty", "title", "titleSlug", "translatedTitle", "translatedContent");
        String properties = Joiner.on("　\\n　").join(propertiesList);
        String query = "query questionData($titleSlug: String!){question(titleSlug: $titleSlug) {" + properties + "}}";
        Map<String, Serializable> params = ImmutableMap.of(
                "operationName", "questionData",
                "query", query,
                "variables", ImmutableMap.of("titleSlug", titleSlug)
        );
        return new Gson().toJson(params);
    }

    private static Question getQuestionData(String titleSlug) {
        HttpPost http = new HttpPost(LEETCODE_GRAPHQL_URL);
        http.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        http.addHeader(HttpHeaders.USER_AGENT, "application/json");
        http.setEntity(new StringEntity(getQuestionDataParams(titleSlug), Charsets.UTF_8));

        try (CloseableHttpResponse response = HTTP_CLIENT.execute(http)) {
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("获取详情失败：code=" + response.getStatusLine().getStatusCode()
                        + " message=" + EntityUtils.toString(response.getEntity()));
            }
            InputStreamReader reader = new InputStreamReader(new BufferedInputStream(response.getEntity().getContent()), Charsets.UTF_8);
            JsonObject json = new JsonParser().parse(reader).getAsJsonObject();
            JsonObject jsonObject = json.getAsJsonObject("data").getAsJsonObject("question");
            return new Gson().fromJson(jsonObject, Question.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        System.out.println(getQuestionData(getTitleSlug("1")));
    }

    private class Question {
        private String questionId;
        private String content;
        private String difficulty;
        private String title;
        private String titleSlug;
        private String translatedTitle;
        private String translatedContent;

        public String getQuestionId() {
            return questionId;
        }

        public void setQuestionId(String questionId) {
            this.questionId = questionId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDifficulty() {
            return difficulty;
        }

        public void setDifficulty(String difficulty) {
            this.difficulty = difficulty;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitleSlug() {
            return titleSlug;
        }

        public void setTitleSlug(String titleSlug) {
            this.titleSlug = titleSlug;
        }

        public String getTranslatedTitle() {
            return translatedTitle;
        }

        public void setTranslatedTitle(String translatedTitle) {
            this.translatedTitle = translatedTitle;
        }

        public String getTranslatedContent() {
            return translatedContent;
        }

        public void setTranslatedContent(String translatedContent) {
            this.translatedContent = translatedContent;
        }
    }
}
