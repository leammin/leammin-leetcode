package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

import java.util.List;

/**
 * @author Leammin
 * @date 2023-02-07
 */
class AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriodTest extends AbstractTest<AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod> {
    @Override
    protected Testsuite<AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod> testsuite() {
        return Testsuite.<AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod>builder()
                .addExpected(t -> t.alertNames(new String[]{"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"}, new String[]{"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"}), List.of("daniel"))
                .addExpected(t -> t.alertNames(new String[]{"alice", "alice", "alice", "bob", "bob", "bob", "bob"}, new String[]{"12:01", "12:00", "18:00", "21:00", "21:20", "21:30", "23:00"}), List.of("bob"))
                .addExpected(t -> t.alertNames(new String[]{"john", "john", "john"}, new String[]{"23:58", "23:59", "00:01"}), List.of())
                .addExpected(t -> t.alertNames(new String[]{"leslie", "leslie", "leslie", "clare", "clare", "clare", "clare"}, new String[]{"13:00", "13:20", "14:00", "18:00", "18:51", "19:30", "19:49"}), List.of("clare", "leslie"))
                .addExpected(t -> t.alertNames(new String[]{"a","a","a","a","a","a","b","b","b","b","b"}, new String[]{"23:27","03:14","12:57","13:35","13:18","21:58","22:39","10:49","19:37","14:14","10:41"}), List.of("a"))
                .build();
    }
}