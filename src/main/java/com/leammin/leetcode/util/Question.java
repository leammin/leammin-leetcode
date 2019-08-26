package com.leammin.leetcode.util;

import java.util.List;

class Question {
    private String questionId;
    private String questionFrontendId;
    private String content;
    private String difficulty;
    private String title;
    private String titleSlug;
    private String translatedTitle;
    private String translatedContent;
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
        return getCodeSnippets().stream()
                .filter(cs -> "Java".equalsIgnoreCase(cs.getLang()))
                .findAny()
                .orElseThrow(() -> new RuntimeException("this question not java code: " + title))
                .getCode();
    }

    static class CodeSnippet {
        private String lang;
        private String code;

        public String getLang() {
            return lang;
        }

        public String getCode() {
            return code;
        }
    }
}

