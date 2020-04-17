package com.leammin.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 355. 设计推特
 *
 * <p>设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：</p>
 *
 * <ol>
 * 	<li><strong>postTweet(userId, tweetId)</strong>: 创建一条新的推文</li>
 * 	<li><strong>getNewsFeed(userId)</strong>: 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。</li>
 * 	<li><strong>follow(followerId, followeeId)</strong>: 关注一个用户</li>
 * 	<li><strong>unfollow(followerId, followeeId)</strong>: 取消关注一个用户</li>
 * </ol>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre>
 * Twitter twitter = new Twitter();
 *
 * // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
 * twitter.postTweet(1, 5);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * twitter.getNewsFeed(1);
 *
 * // 用户1关注了用户2.
 * twitter.follow(1, 2);
 *
 * // 用户2发送了一个新推文 (推文id = 6).
 * twitter.postTweet(2, 6);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -&gt; [6, 5].
 * // 推文id6应当在推文id5之前，因为它是在5之后发送的.
 * twitter.getNewsFeed(1);
 *
 * // 用户1取消关注了用户2.
 * twitter.unfollow(1, 2);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * // 因为用户1已经不再关注用户2.
 * twitter.getNewsFeed(1);
 * </pre>
 *
 * @author Leammin
 * @date 2020-04-13
 */
public interface DesignTwitter {
    /** Initialize your data structure here. */

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId);

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId);

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId);

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId);

    class Solution implements DesignTwitter {
        static final LinkedList<TweetNode> EMPTY_LIST = new LinkedList<>();

        Map<Integer, Set<Integer>> follow = new HashMap<>();
        Map<Integer, LinkedList<TweetNode>> tweet = new HashMap<>();

        @Override
        public void postTweet(int userId, int tweetId) {
            tweet.computeIfAbsent(userId, k -> new LinkedList<>()).addFirst(new TweetNode(tweetId));
        }

        @Override
        public List<Integer> getNewsFeed(int userId) {
            List<Iterator<TweetNode>> tweets = follow.getOrDefault(userId, Collections.emptySet()).stream()
                    .map(followee -> tweet.getOrDefault(followee, EMPTY_LIST).iterator())
                    .collect(Collectors.toList());
            tweets.add(tweet.getOrDefault(userId, EMPTY_LIST).iterator());

            PriorityQueue<TweetNode> minHeap = new PriorityQueue<>(10);
            for (Iterator<TweetNode> tweetItr : tweets) {
                while (tweetItr.hasNext()) {
                    TweetNode tweet = tweetItr.next();
                    if (minHeap.size() < 10) {
                        minHeap.add(tweet);
                    } else if (minHeap.peek().time < tweet.time) {
                        minHeap.poll();
                        minHeap.add(tweet);
                    } else {
                        break;
                    }
                }
            }

            LinkedList<Integer> ans = new LinkedList<>();
            while (!minHeap.isEmpty()) {
                ans.addFirst(minHeap.poll().tweetId);
            }
            return ans;
        }

        @Override
        public void follow(int followerId, int followeeId) {
            if (followerId != followeeId) {
                follow.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
            }
        }

        @Override
        public void unfollow(int followerId, int followeeId) {
            follow.getOrDefault(followerId, Collections.emptySet()).remove(followeeId);
        }

        static class TweetNode implements Comparable<TweetNode> {
            static int systemTime = 0;

            final int tweetId;
            final int time;

            public TweetNode(int tweetId) {
                this.tweetId = tweetId;
                time = systemTime++;
            }

            @Override
            public int compareTo(TweetNode o) {
                return Integer.compare(time, o.time);
            }
        }
    }
}
