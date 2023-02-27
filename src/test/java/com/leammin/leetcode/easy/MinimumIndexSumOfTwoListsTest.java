package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-27
 */
class MinimumIndexSumOfTwoListsTest extends AbstractTest<MinimumIndexSumOfTwoLists> {
    @Override
    protected Testsuite<MinimumIndexSumOfTwoLists> testsuite() {
        return Testsuite.<MinimumIndexSumOfTwoLists>builder()
                .add(ExpectedTestcase.of(t -> t.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                        new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"}), new String[]{"Shogun"}))
                .add(ExpectedTestcase.of(t -> t.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                        new String[]{"KFC", "Shogun", "Burger King"}), new String[]{"Shogun"}))
                .add(ExpectedTestcase.of(t -> t.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                        new String[]{"KFC", "Burger King", "Tapioca Express", "Shogun"}), new String[]{"KFC", "Burger King", "Tapioca Express", "Shogun"}))
                .build();
    }
}