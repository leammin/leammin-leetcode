package com.leammin.leetcode.easy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;
import com.leammin.leetcode.util.test.VerifiableTestcase;
import org.assertj.core.api.Assertions;

/**
 * 349. 两个数组的交集
 *
 * <div><p>给定两个数组，编写一个函数来计算它们的交集。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入: </strong>nums1 = [1,2,2,1], nums2 = [2,2]
 * <strong>输出: </strong>[2]
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入: </strong>nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * <strong>输出: </strong>[9,4]</pre>
 *
 * <p><strong>说明:</strong></p>
 *
 * <ul>
 * <li>输出结果中的每个元素一定是唯一的。</li>
 * <li>我们可以不考虑输出结果的顺序。</li>
 * </ul>
 * </div>
 *
 * @author Leammin
 * @date 2018-09-25
 */
public interface IntersectionOfTwoArrays {
    int[] intersection(int[] nums1, int[] nums2);

    static Testsuite<IntersectionOfTwoArrays> testsuite() {
        return Testsuite.<IntersectionOfTwoArrays>builder()
                .add(VerifiableTestcase.ofConsumer(t -> t.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}),
                        r -> Assertions.assertThat(r).containsExactlyInAnyOrder(2)))
                .add(VerifiableTestcase.ofConsumer(t -> t.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}),
                        r -> Assertions.assertThat(r).containsExactlyInAnyOrder(9, 4)))
                .build();
    }


    class Solution implements IntersectionOfTwoArrays {
        @Override
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set = new HashSet<>(nums2.length);
            for (int num : nums2) {
                set.add(num);
            }
            Set<Integer> res = new HashSet<>(nums1.length);
            for (int num : nums1) {
                if (set.contains(num)) {
                    res.add(num);
                }
            }
            int[] result = new int[res.size()];
            int i = 0;
            for (Iterator<Integer> iterator = res.iterator(); iterator.hasNext(); i++) {
                result[i] = iterator.next();
            }
            return result;
        }
    }

}

class IntersectionOfTwoArraysTest extends AbstractTest<IntersectionOfTwoArrays> {
}
