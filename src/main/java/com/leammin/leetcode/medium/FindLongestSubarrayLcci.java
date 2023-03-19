package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.Testsuite;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/find-longest-subarray-lcci/">面试题 17.05.  字母与数字</a>
 * 
 * <p>给定一个放有字母和数字的数组，找到最长的子数组，且包含的字母和数字的个数相同。</p>
 * 
 * <p>返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre>
 * <strong>输入: </strong>["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]
 * 
 * <strong>输出: </strong>["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
 * </pre>
 * 
 * <p><strong>示例 2:</strong></p>
 * 
 * <pre>
 * <strong>输入: </strong>["A","A"]
 * 
 * <strong>输出: </strong>[]
 * </pre>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ul>
 * 	<li><code>array.length <= 100000</code></li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2023-03-17
 */
public interface FindLongestSubarrayLcci {
    public String[] findLongestSubarray(String[] array);
    static Testsuite<FindLongestSubarrayLcci> testsuite() {
        return Testsuite.<FindLongestSubarrayLcci>builder()
                .addExpected(t -> t.findLongestSubarray(new String[]{"A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"}), new String[]{"A","1","B","C","D","2","3","4","E","5","F","G","6","7"})
                .build();
    }

    class Solution implements FindLongestSubarrayLcci {

        @Override
        public String[] findLongestSubarray(String[] array) {
            Map<Integer, Integer> m = new HashMap<>();
            m.put(0, -1);
            int d = 0;
            int max = 0;
            int maxi = 0;
            for(int i = 0; i < array.length; i++) {
                char c = array[i].charAt(0);
                if (c >= '0' && c <= '9') {
                    d++;
                } else {
                    d--;
                }
                Integer j = m.putIfAbsent(d, i);
                if (j != null && i - j > max) {
                    max = i - j;
                    maxi = j + 1;
                }
            }
            return Arrays.copyOfRange(array, maxi, max + maxi);
        }
    }
}
