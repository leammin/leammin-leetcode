package com.leammin.leetcode.main;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class Question {
    private String questionId;
    private String questionFrontendId;
    private String content;
    private String difficulty;
    private String title;
    private String titleSlug;
    private String translatedTitle;
    private String translatedContent;
    private String exampleTestcases;
    private String jsonExampleTestcases;
    private Boolean isPaidOnly;
    private List<CodeSnippet> codeSnippets;

    public String getQuestionId() {
        return questionId;
    }

    public String getQuestionFrontendId() {
        return questionFrontendId;
    }

    public String getContent() {
        return content;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getTitle() {
        return title;
    }

    public String getTitleSlug() {
        return titleSlug;
    }

    public String getTranslatedTitle() {
        return translatedTitle;
    }

    public String getTranslatedContent() {
        return translatedContent;
    }

    public List<CodeSnippet> getCodeSnippets() {
        return codeSnippets;
    }

    public String getJavaCode() {
        if (codeSnippets == null) {
            return null;
        }
        return codeSnippets.stream()
                .filter(cs -> "Java".equalsIgnoreCase(cs.getLang()))
                .findAny()
                .map(CodeSnippet::getCode)
                .orElse(null);
    }

    public boolean needInit() {
        if (isPaidOnly != null && isPaidOnly) {
            return false;
        }
        return codeSnippets == null || codeSnippets.isEmpty()
                || StringUtils.isEmpty(translatedContent)
                || StringUtils.isEmpty(jsonExampleTestcases)
                ;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public void setQuestionFrontendId(String questionFrontendId) {
        this.questionFrontendId = questionFrontendId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTitleSlug(String titleSlug) {
        this.titleSlug = titleSlug;
    }

    public void setTranslatedTitle(String translatedTitle) {
        this.translatedTitle = translatedTitle;
    }

    public void setTranslatedContent(String translatedContent) {
        this.translatedContent = translatedContent;
    }

    public void setCodeSnippets(List<CodeSnippet> codeSnippets) {
        this.codeSnippets = codeSnippets;
    }

    public Boolean getIsPaidOnly() {
        return isPaidOnly;
    }

    public void setIsPaidOnly(Boolean paidOnly) {
        isPaidOnly = paidOnly;
    }

    public String getExampleTestcases() {
        return exampleTestcases;
    }

    public void setExampleTestcases(String exampleTestcases) {
        this.exampleTestcases = exampleTestcases;
    }

    public String getJsonExampleTestcases() {
        return jsonExampleTestcases;
    }

    public void setJsonExampleTestcases(String jsonExampleTestcases) {
        this.jsonExampleTestcases = jsonExampleTestcases;
    }

    public static class CodeSnippet {
        private String lang;
        private String code;

        public String getLang() {
            return lang;
        }

        public String getCode() {
            return code;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public void setCode(String code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return "CodeSnippet{" +
                    "lang='" + lang + '\'' +
                    ", code='" + code + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId='" + questionId + '\'' +
                ", questionFrontendId='" + questionFrontendId + '\'' +
                ", content='" + content + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", title='" + title + '\'' +
                ", titleSlug='" + titleSlug + '\'' +
                ", translatedTitle='" + translatedTitle + '\'' +
                ", translatedContent='" + translatedContent + '\'' +
                ", isPaidOnly=" + isPaidOnly +
                ", codeSnippets=" + codeSnippets +
                '}';
    }
}

