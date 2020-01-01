package com.leammin.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 763. 划分字母区间
 * 
 * <p>字符串 <code>S</code> 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre><strong>输入:</strong> S = &quot;ababcbacadefegdehijhklij&quot;
 * <strong>输出:</strong> [9,7,8]
 * <strong>解释:</strong>
 * 划分结果为 &quot;ababcbaca&quot;, &quot;defegde&quot;, &quot;hijhklij&quot;。
 * 每个字母最多出现在一个片段中。
 * 像 &quot;ababcbacadefegde&quot;, &quot;hijhklij&quot; 的划分是错误的，因为划分的片段数较少。
 * </pre>
 * 
 * <p><strong>注意:</strong></p>
 * 
 * <ol>
 * 	<li><code>S</code>的长度在<code>[1, 500]</code>之间。</li>
 * 	<li><code>S</code>只包含小写字母<code>&#39;a&#39;</code>到<code>&#39;z&#39;</code>。</li>
 * </ol>
 * 
 * 
 * @author Leammin
 * @date 2019-08-31
 */
public interface PartitionLabels {
    List<Integer> partitionLabels(String s);

    class Solution implements PartitionLabels {
        @Override
        public List<Integer> partitionLabels(String s) {
            Range[] ranges = new Range[26];
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (ranges[chars[i] - 'a'] == null) {
                    ranges[chars[i] - 'a'] = new Range(i);
                } else {
                    ranges[chars[i] - 'a'].right = i;
                }
            }
            Arrays.sort(ranges, Comparator.nullsLast(Comparator.comparingInt(o -> o.left)));
            List<Integer> res = new ArrayList<>(26);
            int left = ranges[0].left;
            int right = ranges[0].right;
            for (int i = 1; i < ranges.length && ranges[i] != null; i++) {
                if (right > ranges[i].left) {
                    right = Math.max(ranges[i].right, right);
                } else {
                    res.add(right - left + 1);
                    left = ranges[i].left;
                    right = ranges[i].right;
                }
            }
            res.add(right - left + 1);
            return res;
        }

        static class Range {
            int left;
            int right;
            Range(int i) {
                this.left = i;
                this.right = i;
            }
        }
    }
}
