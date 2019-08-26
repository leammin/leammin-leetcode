package com.leammin.leetcode.util;

import com.google.common.base.Splitter;
import com.google.common.collect.Streams;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.codec.Charsets;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Leammin
 * @date 2019-07-13
 */
public final class Leetcoder {
    private static final CloseableHttpClient HTTP_CLIENT = HttpClientBuilder.create().build();
    private static final String LEETCODE_ALL_PROBLEMS_URL = "https://leetcode-cn.com/api/problems/all";
    private static final String LEETCODE_GRAPHQL_URL = "https://leetcode-cn.com/graphql";
    private static final Path LEETCODE_FILE_PATH = Paths.get("src", "main", "resources", "leetcode.json");

    private static String getAllQuestionsParams() {
        return "{\"operationName\": \"allQuestions\",\"variables\": {},\"query\": \"query allQuestions{ allQuestions{ " +
                "...questionSummaryFields\\n__typename\\n } } fragment questionSummaryFields on QuestionNode{ " +
                "title\\n titleSlug\\n translatedTitle\\n questionId\\n questionFrontendId\\n difficulty\\n translatedTitle\\n " +
                "translatedContent\\n content\\n codeSnippets{ lang\\n code }\\n __typename }\"}";
    }

    private static String requestAllQuestions() {
        HttpPost http = new HttpPost(LEETCODE_GRAPHQL_URL);
        http.addHeader("content-type", "application/json");
        http.addHeader("accept-encoding", "gzip, deflate, br");
        http.addHeader("accept-language", "zh-CN,zh;q=0.9,zh-TW;q=0.8");
        http.addHeader("dnt", "1");
        http.addHeader("accept", "*/*");
        http.addHeader("authority", "leetcode-cn.com");
        http.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");
        http.addHeader("origin", "https://leetcode-cn.com");
        http.addHeader("referer", "https://leetcode-cn.com");
        http.addHeader("sec-fetch-mode", "cors");
        http.addHeader("sec-fetch-site", "same-origin");
//        http.addHeader("cookie", "csrftoken=cTFH9oarSwffuR9OSCGtoGdlaHy67uZilBckjt6i36r2DMHiCD3JwHADMZsxMDKQ;");
//        http.addHeader("x-csrftoken", "cTFH9oarSwffuR9OSCGtoGdlaHy67uZilBckjt6i36r2DMHiCD3JwHADMZsxMDKQ");
        http.setEntity(new StringEntity(getAllQuestionsParams(), Charsets.UTF_8));
        try (CloseableHttpResponse response = HTTP_CLIENT.execute(http)) {
            String responseStr = EntityUtils.toString(response.getEntity());

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("获取详情失败：code=" + response.getStatusLine().getStatusCode());
            }

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Map result = gson.fromJson(responseStr, Map.class);
            Map data = (Map) result.get("data");
            return gson.toJson(data.get("allQuestions"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeLeetcodeFile(String content) {
        File file = LEETCODE_FILE_PATH.toFile();
        try (Writer writer = new BufferedWriter(new FileWriter(file))) {
            writer.append(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Question> getAllQuestions() {
        File file = LEETCODE_FILE_PATH.toFile();
        if (!file.exists()) {
            writeLeetcodeFile(requestAllQuestions());
        }
        try {
            Reader reader = new BufferedReader(new FileReader(file));
            Question[] questions = new Gson().fromJson(reader, Question[].class);
            return Arrays.asList(questions);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static Optional<Question> getQuestion(String questionId) {
        return getAllQuestions().stream()
                .filter(question -> Objects.equals(question.getQuestionFrontendId(), questionId) ||
                        Objects.equals(question.getTitleSlug(), questionId) ||
                        Objects.equals(question.getTitle(), questionId) ||
                        Objects.equals(question.getTranslatedTitle(), questionId)
                )
                .findFirst();
    }

    private static String getClassName(Question question) {
        String title = question.getTitle();
        return Streams.stream(Splitter.on(' ').trimResults().omitEmptyStrings().split(question.getTitle()))
                .map(t -> Character.toUpperCase(t.charAt(0)) + (t.length() > 1 ? t.substring(1) : ""))
                .collect(Collectors.joining());
    }

    private static String getPackage(Question question) {
        return "com.leammin.leetcode.undone." + question.getDifficulty().toLowerCase();
    }

    private static String generateCode(Question question) {
        String className = getClassName(question);
        return "package " + getPackage(question) + ";\n" +
                "\n" +
                "/**\n" +
                " * " + question.getQuestionId() + ". " + question.getTranslatedTitle() + "\n" +
                " * \n" +
                " * " + commentContent(question.getTranslatedContent()) + "\n" +
                " * \n" +
                " * @author Leammin\n" +
                " * @date " + LocalDate.now().toString() + "\n" +
                " */\n" +
                "public interface " + className + " {\n" +
                "    \n" +
                "    class Solution implements " + className + " {\n" +
                "        \n" +
                "    }\n" +
                "}\n";
    }

    private static String commentContent(String content) {
        return content.replace("\n", "\n * ");
    }

    private static Path getCodePath(Question question) {
        return Paths.get("src", "main", "java", "com", "leammin", "leetcode", "undone",
                question.getDifficulty().toLowerCase(),
                getClassName(question) + ".java");
    }

    private static void createCodeFile(Question question) {
        createFile(getCodePath(question), generateCode(question));
    }

    private static void createFile(Path path, String content) {
        File file = path.toFile();
        if (file.exists()) {
            throw new RuntimeException("文件已存在: " + file.getAbsolutePath());
        }
        try {
            Files.createDirectories(path.getParent());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (Writer writer = new BufferedWriter(new FileWriter(file))) {
            writer.append(content);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String generateTest(Question question) {
        String className = getClassName(question);
        return "package " + "com.leammin.leetcode." + question.getDifficulty().toLowerCase() + ";\n" +
                "\n" +
                "import " + getPackage(question) + "." + className + ";\n" +
                "import com.leammin.leetcode.util.AbstractTest;\n" +
                "import com.leammin.leetcode.util.Testsuite;\n" +
                "\n" +
                "/**\n" +
                " * @author Leammin\n" +
                " * @date " + LocalDate.now().toString() + "\n" +
                " */\n" +
                "class " + className + "Test extends AbstractTest<" + className + "> {\n" +
                "    @Override\n" +
                "    protected Testsuite<" + className + "> testsuite() {\n" +
                "        return Testsuite.<" + className + ">builder()\n" +
                "                .build();\n" +
                "    }\n" +
                "}";
    }

    private static Path getTestPath(Question question) {
        return Paths.get("src", "test", "java", "com", "leammin", "leetcode",
                question.getDifficulty().toLowerCase(),
                getClassName(question) + "Test.java");
    }

    private static void createTestFile(Question question) {
        createFile(getTestPath(question), generateTest(question));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("0.生成全部");
        System.out.println("1.生成代码");
        System.out.println("2.生成测试");
        System.out.print("请输入要执行的操作：");
        int op;
        try {
            op = sc.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
            op = 0;
        }
        System.out.print("请输入id/title: ");
        String questionId = sc.next();

        Question question = getQuestion(questionId)
                .orElseThrow(() -> new RuntimeException("该 questionId 不存在: " + questionId));
        if (op == 0 || op == 2) {
            createTestFile(question);
        }
        if (op == 0 || op == 1) {
            createCodeFile(question);
        }
        System.out.println(question.getJavaCode());
    }

}
