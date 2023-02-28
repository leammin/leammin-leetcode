package com.leammin.leetcode.main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetcodeRequestsTest {

    @Test
    void questionData() {
        Question question = LeetcodeRequests.questionData("longest-substring-without-repeating-characters");
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(question));

    }
}