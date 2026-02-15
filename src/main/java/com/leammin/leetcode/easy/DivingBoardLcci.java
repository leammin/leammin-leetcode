package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 面试题 16.11. 跳水板
 * 
 * <p>你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为<code>shorter</code>，长度较长的木板长度为<code>longer</code>。你必须正好使用<code>k</code>块木板。编写一个方法，生成跳水板所有可能的长度。</p>
 * <p>返回的长度需要从小到大排列。</p>
 * <p><strong>示例：</strong></p>
 * <pre><strong>输入：</strong>
 * shorter = 1
 * longer = 2
 * k = 3
 * <strong>输出：</strong> {3,4,5,6}
 * </pre>
 * <p><strong>提示：</strong></p>
 * <ul>
 * <li>0 < shorter <= longer</li>
 * <li>0 <= k <= 100000</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2020-07-08
 */
public interface DivingBoardLcci {
    int[] divingBoard(int shorter, int longer, int k);

    static Testsuite<DivingBoardLcci> testsuite() {
        return Testsuite.<DivingBoardLcci>builder()
                .add(ExpectedTestcase.of(t -> t.divingBoard(1, 2, 3), new int[]{3, 4, 5, 6}))
                .add(ExpectedTestcase.of(t -> t.divingBoard(1, 1, 0), new int[]{}))
                .add(ExpectedTestcase.of(t -> t.divingBoard(1, 1, 100000), new int[]{100000}))
                .build();
    }


    class Solution implements DivingBoardLcci {

        @Override
        public int[] divingBoard(int shorter, int longer, int k) {
            if (k == 0) {
                return new int[0];
            }
            if (shorter == longer) {
                return new int[]{k * shorter};
            }
            int[] res = new int[k + 1];
            for (int i = 0; i <= k; i++) {
                res[i] = (k - i) * shorter + i * longer;
            }
            return res;
        }
    }
}

class DivingBoardLcciTest extends AbstractTest<DivingBoardLcci> {
}
