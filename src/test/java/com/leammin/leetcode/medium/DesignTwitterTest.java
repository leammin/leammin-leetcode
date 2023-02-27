package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testcase;
import com.leammin.leetcode.util.test.Testsuite;
import org.assertj.core.api.Assertions;

import java.util.List;

/**
 * @author Leammin
 * @date 2020-04-13
 */
class DesignTwitterTest extends AbstractTest<DesignTwitter> {
    @Override
    protected Testsuite<DesignTwitter> testsuite() {
        return Testsuite.<DesignTwitter>builder()
                .add(Testcase.of(t -> {
                    long before = System.nanoTime();

                    t.postTweet(1, 5);
                    List<Integer> f1 = t.getNewsFeed(1);
                    t.follow(1, 2);
                    t.postTweet(2, 6);
                    List<Integer> f2 = t.getNewsFeed(1);
                    t.unfollow(1, 2);
                    List<Integer> f3 = t.getNewsFeed(1);

                    long time = System.nanoTime() - before;

                    Assertions.assertThat(f1).containsExactly(5);
                    Assertions.assertThat(f2).containsExactly(6, 5);
                    Assertions.assertThat(f3).containsExactly(5);

                    return time;
                }))

                .add(Testcase.of(t -> {
                    long before = System.nanoTime();

                    t.postTweet(1, 5);
                    t.postTweet(1, 3);
                    t.postTweet(1, 101);
                    t.postTweet(1, 13);
                    t.postTweet(1, 10);
                    t.postTweet(1, 2);
                    t.postTweet(1, 94);
                    t.postTweet(1, 505);
                    t.postTweet(1, 333);
                    List<Integer> f = t.getNewsFeed(1);

                    long time = System.nanoTime() - before;

                    Assertions.assertThat(f).containsExactly(333,505,94,2,10,13,101,3,5);

                    return time;
                }))
                .build();
    }
}