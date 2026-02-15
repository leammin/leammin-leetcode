package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 1103. 分糖果 II
 *
 * <p>排排坐，分糖果。</p>
 *
 * <p>我们买了一些糖果 <code>candies</code>，打算把它们分给排好队的 <strong><code>n = num_people</code></strong> 个小朋友。</p>
 *
 * <p>给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 <code>n</code>&nbsp;颗糖果。</p>
 *
 * <p>然后，我们再回到队伍的起点，给第一个小朋友 <code>n&nbsp;+ 1</code> 颗糖果，第二个小朋友 <code>n&nbsp;+ 2</code> 颗，依此类推，直到给最后一个小朋友 <code>2 * n</code>&nbsp;颗糖果。</p>
 *
 * <p>重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。</p>
 *
 * <p>返回一个长度为 <code>num_people</code>、元素之和为 <code>candies</code> 的数组，以表示糖果的最终分发情况（即 <code>ans[i]</code> 表示第 <code>i</code> 个小朋友分到的糖果数）。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>candies = 7, num_people = 4
 * <strong>输出：</strong>[1,2,3,1]
 * <strong>解释：</strong>
 * 第一次，ans[0] += 1，数组变为 [1,0,0,0]。
 * 第二次，ans[1] += 2，数组变为 [1,2,0,0]。
 * 第三次，ans[2] += 3，数组变为 [1,2,3,0]。
 * 第四次，ans[3] += 1（因为此时只剩下 1 颗糖果），最终数组变为 [1,2,3,1]。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>candies = 10, num_people = 3
 * <strong>输出：</strong>[5,2,3]
 * <strong>解释：</strong>
 * 第一次，ans[0] += 1，数组变为 [1,0,0]。
 * 第二次，ans[1] += 2，数组变为 [1,2,0]。
 * 第三次，ans[2] += 3，数组变为 [1,2,3]。
 * 第四次，ans[0] += 4，最终数组变为 [5,2,3]。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= candies &lt;= 10^9</code></li>
 * 	<li><code>1 &lt;= num_people &lt;= 1000</code></li>
 * </ul>
 *
 * @author Leammin
 * @date 2020-03-05
 */
public interface DistributeCandiesToPeople {
    int[] distributeCandies(int candies, int num_people);

    static Testsuite<DistributeCandiesToPeople> testsuite() {
        return Testsuite.<DistributeCandiesToPeople>builder()
                .add(ExpectedTestcase.of(t -> t.distributeCandies(7, 4), new int[]{1, 2, 3, 1}))
                .add(ExpectedTestcase.of(t -> t.distributeCandies(10, 3), new int[]{5, 2, 3}))
                .add(ExpectedTestcase.of(t -> t.distributeCandies(100, 5), new int[]{18, 21, 24, 22, 15}))
                .add(ExpectedTestcase.of(t -> t.distributeCandies(10, 5), new int[]{1, 2, 3, 4, 0}))
                .add(ExpectedTestcase.of(t -> t.distributeCandies(1000000000, 10), new int[]{100014472, 99980504, 99984976, 99989448, 99993920, 99998392,
                                100002864, 100007336, 100011808, 100016280}
                ))
                .build();
    }


    class Solution implements DistributeCandiesToPeople {

        @Override
        public int[] distributeCandies(int candies, int num_people) {
            int n = (int) ((Math.sqrt(8 * (long) candies + 1) - 1) / 2);
            int m = n / num_people;
            int firstM = 1 + (m - 1) * num_people;
            int firstS = (1 + firstM) * m / 2;
            int remainingCandies = candies;
            int[] people = new int[num_people];
            for (int i = 0, c = firstS; i < people.length; i++, c += m) {
                people[i] = c;
                remainingCandies -= c;
            }
            for (int i = 0, c = firstM + num_people; i < people.length && remainingCandies > 0; i++, c++) {
                people[i] += Math.min(remainingCandies, c);
                remainingCandies -= c;
            }
            return people;
        }
    }
}

class DistributeCandiesToPeopleTest extends AbstractTest<DistributeCandiesToPeople> {
}
