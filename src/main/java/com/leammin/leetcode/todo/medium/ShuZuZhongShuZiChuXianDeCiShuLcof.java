package com.leammin.leetcode.todo.medium;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;
import com.leammin.leetcode.util.test.VerifiableTestcase;
import org.assertj.core.api.Assertions;

/**
 * 面试题56 - I. 数组中数字出现的次数
 * 
 * <p>一个整型数组 <code>nums</code> 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输入：</strong>nums = [4,1,4,6]
 * <strong>输出：</strong>[1,6] 或 [6,1]
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre><strong>输入：</strong>nums = [1,2,10,4,1,4,3,3]
 * <strong>输出：</strong>[2,10] 或 [10,2]</pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>限制：</strong></p>
 * 
 * <ul>
 * 	<li><code>2 &lt;= nums &lt;= 10000</code></li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * 
 * 
 * @author Leammin
 * @date 2020-04-28
 */
public interface ShuZuZhongShuZiChuXianDeCiShuLcof {
    int[] singleNumbers(int[] nums);

    static Testsuite<ShuZuZhongShuZiChuXianDeCiShuLcof> testsuite() {
        return Testsuite.<ShuZuZhongShuZiChuXianDeCiShuLcof>builder()
                .add(VerifiableTestcase.ofConsumer(t -> t.singleNumbers(new int[]{4, 1, 4, 6}),
                        res -> Assertions.assertThat(res).containsExactlyInAnyOrder(1, 6)))
                .add(VerifiableTestcase.ofConsumer(t -> t.singleNumbers(new int[]{1, 2, 10, 4, 1, 4, 3, 3}),
                        res -> Assertions.assertThat(res).containsExactlyInAnyOrder(2, 10)))
                .build();
    }


    class Solution implements ShuZuZhongShuZiChuXianDeCiShuLcof {

        @Override
        public int[] singleNumbers(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (set.contains(num)) {
                    set.remove(num);
                } else {
                    set.add(num);
                }
            }
            Iterator<Integer> it = set.iterator();
            return new int[]{it.next(), it.next()};
        }
    }

    class Best implements ShuZuZhongShuZiChuXianDeCiShuLcof {

        @Override
        public int[] singleNumbers(int[] nums) {
            int k = 0;
            for (int num : nums) {
                k ^= num;
            }
            int mask = 1;
            while ((k & mask) == 0) {
                mask <<= 1;
            }
            int a = 0;
            int b = 0;
            for (int num : nums) {
                if ((num & mask) == 0) {
                    a ^= num;
                } else {
                    b ^= num;
                }
            }
            return new int[]{a, b};
        }
    }


}

class ShuZuZhongShuZiChuXianDeCiShuLcofTest extends AbstractTest<ShuZuZhongShuZiChuXianDeCiShuLcof> {
}
