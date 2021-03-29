package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.Execute;

import java.util.*;

/**
 * 354. 俄罗斯套娃信封问题
 *
 * <p>给定一些标记了宽度和高度的信封，宽度和高度以整数对形式&nbsp;<code>(w, h)</code>&nbsp;出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。</p>
 *
 * <p>请计算最多能有多少个信封能组成一组&ldquo;俄罗斯套娃&rdquo;信封（即可以把一个信封放到另一个信封里面）。</p>
 *
 * <p><strong>说明:</strong><br>
 * 不允许旋转信封。</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong>输入:</strong> envelopes = <code>[[5,4],[6,4],[6,7],[2,3]]</code>
 * <strong>输出:</strong> 3
 * <strong>解释:</strong> 最多信封的个数为 <code>3, 组合为: </code>[2,3] =&gt; [5,4] =&gt; [6,7]。
 * </pre>
 *
 * @author Leammin
 * @date 2021-03-04
 */
public interface RussianDollEnvelopes {
    int maxEnvelopes(int[][] envelopes);

    class Solution implements RussianDollEnvelopes {

        @Override
        public int maxEnvelopes(int[][] envelopes) {
            Arrays.sort(envelopes, Comparator.comparingInt(o -> o[0]));
            int max = 0;
            int[] dp = new int[envelopes.length];
            for (int i = 0; i < envelopes.length; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                        dp[i] = Math.max(dp[i], dp[j]);
                    }
                }
                max = Math.max(max, ++dp[i]);
            }
            return max;
        }
    }

    class Solution1 implements RussianDollEnvelopes {

        @Override
        public int maxEnvelopes(int[][] envelopes) {
            Arrays.sort(envelopes, Comparator.<int[]>comparingInt(o -> o[0]).thenComparingInt(o -> -o[1]));
            int max = 0;
            TreeMap<Integer, Integer> hToNum = new TreeMap<>();
            for (int[] envelope : envelopes) {
                Map.Entry<Integer, Integer> entry = hToNum.lowerEntry(envelope[1]);
                int num = (entry == null ? 0 : entry.getValue()) + 1;
                hToNum.put(envelope[1], num);
                max = Math.max(max, num);
                Map<Integer, Integer> tailMap = hToNum.tailMap(envelope[1], false);
                Iterator<Map.Entry<Integer, Integer>> iterator = tailMap.entrySet().iterator();
                while (iterator.hasNext() && iterator.next().getValue() <= num) {
                    iterator.remove();
                }
            }
            return max;
        }
    }

    @Execute
    class Solution2 implements RussianDollEnvelopes {

        @Override
        public int maxEnvelopes(int[][] envelopes) {
            Arrays.sort(envelopes, Comparator.<int[]>comparingInt(o -> o[0]).thenComparingInt(o -> -o[1]));
            // dp 表示长度为 i+1 的递增序列末位最小值
            int[] dp = new int[envelopes.length];
            int len = 0;
            for (int[] envelope : envelopes) {
                int h = envelope[1];
                int bs = Arrays.binarySearch(dp, 0, len, h);
                if (bs < 0) {
                    bs = -bs - 1;
                }
                dp[bs] = h;
                if (bs == len) {
                    len++;
                }
            }
            return len;
        }
    }
}
