package com.leammin.leetcode.medium;

import com.leammin.leetcode.undone.medium.ContainsDuplicateIii;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-03-31
 */
class ContainsDuplicateIiiTest extends AbstractTest<ContainsDuplicateIii> {
    @Override
    protected Testsuite<ContainsDuplicateIii> testsuite() {
        return Testsuite.<ContainsDuplicateIii>builder()
                .addExpected(t -> t.containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3 , 0), true)
                .addExpected(t -> t.containsNearbyAlmostDuplicate(new int[]{1,0,1,1}, 1 , 2), true)
                .addExpected(t -> t.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2 , 3), false)
                .addExpected(t -> t.containsNearbyAlmostDuplicate(new int[]{-2147483648,2147483647}, 1 , 1), false)
                .addExpected(t -> t.containsNearbyAlmostDuplicate(new int[]{1,3,6,2}, 1 , 2), true)
                .addExpected(t -> t.containsNearbyAlmostDuplicate(new int[]{1,2,5,6,7,2,4}, 4 , 0), true)
                .addExpected(t -> t.containsNearbyAlmostDuplicate(new int[]{-3, 3}, 2 , 4), false)
                .build();
    }
}