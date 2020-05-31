package com.leammin.leetcode.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class LeetcodeRequests {
    private static final String LEETCODE_GRAPHQL_URL = "https://leetcode-cn.com/graphql";
    private static final String[] LEETCODE_REQUEST_HEADERS = new String[]{
            "content-type", "application/json",
            "accept-encoding", "deflate, br",
            "accept-language", "zh-CN,zh;q=0.9,zh-TW;q=0.8",
            "dnt", "1",
            "accept", "*/*",
            "authority", "leetcode-cn.com",
            "User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36",
            "origin", "https://leetcode-cn.com",
            "referer", "https://leetcode-cn.com",
            "sec-fetch-mode", "cors",
            "sec-fetch-site", "same-origin"
    };
    private static final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();

    private static String sendRequest(HttpRequest request) {
        try {
            HttpResponse<String> resp = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            if (resp.statusCode() != 200) {
                throw new RuntimeException("获取详情失败：code=" + resp.statusCode());
            }
            return resp.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Deprecated
    public static List<Question> allQuestions() {
        HttpRequest request = HttpRequest.newBuilder(URI.create(LEETCODE_GRAPHQL_URL))
                .headers(LEETCODE_REQUEST_HEADERS)
                .POST(HttpRequest.BodyPublishers.ofString(allQuestionsBody()))
                .build();

        String body = sendRequest(request);
        return JSONObject.parseObject(body)
                .getJSONObject("data")
                .getJSONArray("allQuestions")
                .toJavaList(Question.class);
    }

    @Deprecated
    private static String allQuestionsBody() {
        return "{\"operationName\": \"allQuestions\",\"variables\": {},\"query\": \"query allQuestions{ allQuestions{ " +
                "...questionSummaryFields\\n__typename\\n } } fragment questionSummaryFields on QuestionNode{ " +
                "title\\n titleSlug\\n translatedTitle\\n questionId\\n questionFrontendId\\n difficulty\\n translatedTitle\\n " +
                "translatedContent\\n content\\n codeSnippets{ lang\\n code }\\n __typename }\"}";
    }

    public static List<Question> allQuestionsBeta() {
        HttpRequest request = HttpRequest.newBuilder(URI.create(LEETCODE_GRAPHQL_URL))
                .headers(LEETCODE_REQUEST_HEADERS)
                .POST(HttpRequest.BodyPublishers.ofString(allQuestionsBetaBody()))
                .build();

        String body = sendRequest(request);
        JSONObject jsonObject = JSONObject.parseObject(body);
        JSONObject data = jsonObject.getJSONObject("data");
        JSONArray allQuestionsBeta = data.getJSONArray("allQuestionsBeta");
        List<Question> questions = allQuestionsBeta.toJavaList(Question.class);
        return questions;
    }

    private static String allQuestionsBetaBody() {
        return "{\"operationName\":\"allQuestions\",\"variables\":{}," +
                "\"query\":\"query allQuestions {" +
                "\\n  allQuestionsBeta {" +
                "\\n    ...questionSummaryFields" +
                "\\n    __typename" +
                "\\n  }\\n}\\n\\n" +
                "fragment questionSummaryFields on QuestionNode {" +
                "\\n  title" +
                "\\n  titleSlug" +
                "\\n  translatedTitle" +
                "\\n  questionId" +
                "\\n  questionFrontendId" +
//                "\\n  status" +
                "\\n  difficulty" +
                "\\n  isPaidOnly" +
//                "\\n  categoryTitle" +
                "\\n  __typename" +
                "\\n}\\n\"" +
                "}";
    }

    public static Question questionData(String titleSlug) {
        HttpRequest request = HttpRequest.newBuilder(URI.create(LEETCODE_GRAPHQL_URL))
                .headers(LEETCODE_REQUEST_HEADERS)
                .POST(HttpRequest.BodyPublishers.ofString(questionDataBody(titleSlug)))
                .build();

        String body = sendRequest(request);
        JSONObject jsonObject = JSONObject.parseObject(body);
        JSONObject data = jsonObject.getJSONObject("data");
        return data.getObject("question", Question.class);
    }

    private static String questionDataBody(String titleSlug) {
        return "{\"operationName\":\"questionData\"," +
                "\"variables\":{\"titleSlug\":\"" + titleSlug + "\"}," +
                "\"query\":\"query questionData($titleSlug: String!) {" +
                "\\n  question(titleSlug: $titleSlug) {" +
                "\\n    questionId" +
                "\\n    questionFrontendId" +
//                "\\n    boundTopicId" +
                "\\n    title" +
                "\\n    titleSlug" +
                "\\n    content" +
                "\\n    translatedTitle" +
                "\\n    translatedContent" +
                "\\n    isPaidOnly" +
                "\\n    difficulty" +
//                "\\n    likes" +
//                "\\n    dislikes" +
//                "\\n    isLiked" +
//                "\\n    similarQuestions" +
//                "\\n    contributors {" +
//                "\\n      username" +
//                "\\n      profileUrl" +
//                "\\n      avatarUrl" +
//                "\\n      __typename" +
//                "\\n    }" +
//                "\\n    langToValidPlayground" +
//                "\\n    topicTags {" +
//                "\\n      name" +
//                "\\n      slug" +
//                "\\n      translatedName" +
//                "\\n      __typename" +
//                "\\n    }" +
//                "\\n    companyTagStats" +
                "\\n    codeSnippets {" +
                "\\n      lang" +
//                "\\n      langSlug" +
                "\\n      code" +
                "\\n      __typename" +
                "\\n    }" +
//                "\\n    stats" +
//                "\\n    hints" +
//                "\\n    solution {" +
//                "\\n      id" +
//                "\\n      canSeeDetail" +
//                "\\n      __typename" +
//                "\\n    }" +
//                "\\n    status" +
//                "\\n    sampleTestCase" +
//                "\\n    metaData" +
//                "\\n    judgerAvailable" +
//                "\\n    judgeType" +
//                "\\n    mysqlSchemas" +
//                "\\n    enableRunCode" +
//                "\\n    envInfo" +
//                "\\n    book {" +
//                "\\n      id" +
//                "\\n      bookName" +
//                "\\n      pressName" +
//                "\\n      source" +
//                "\\n      shortDescription" +
//                "\\n      fullDescription" +
//                "\\n      bookImgUrl" +
//                "\\n      pressImgUrl" +
//                "\\n      productUrl" +
//                "\\n      __typename" +
//                "\\n    }" +
//                "\\n    isSubscribed" +
//                "\\n    isDailyQuestion" +
//                "\\n    dailyRecordStatus" +
//                "\\n    editorType" +
//                "\\n    ugcQuestionId" +
                "\\n    __typename" +
                "\\n  }\\n}\\n\"}";
    }

    public static void main(String[] args) {
        Question question = questionData("sort-an-array");
        System.out.println(question);
//        System.out.println("测试");
    }


    private LeetcodeRequests() {

    }
}
