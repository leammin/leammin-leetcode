package com.leammin.leetcode.medium;

import com.leammin.leetcode.undone.medium.ShuZuZhongShuZiChuXianDeCiShuLcof;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;
import com.leammin.leetcode.util.VerifiableTestcase;
import org.assertj.core.api.Assertions;

/**
 * @author Leammin
 * @date 2020-04-28
 */
class ShuZuZhongShuZiChuXianDeCiShuLcofTest extends AbstractTest<ShuZuZhongShuZiChuXianDeCiShuLcof> {
    @Override
    protected Testsuite<ShuZuZhongShuZiChuXianDeCiShuLcof> testsuite() {
        return Testsuite.<ShuZuZhongShuZiChuXianDeCiShuLcof>builder()
                .add(VerifiableTestcase.ofConsumer(t -> t.singleNumbers(new int[]{4, 1, 4, 6}),
                        res -> Assertions.assertThat(res).containsExactlyInAnyOrder(1, 6)))
                .add(VerifiableTestcase.ofConsumer(t -> t.singleNumbers(new int[]{1, 2, 10, 4, 1, 4, 3, 3}),
                        res -> Assertions.assertThat(res).containsExactlyInAnyOrder(2, 10)))
                .build();
    }
}