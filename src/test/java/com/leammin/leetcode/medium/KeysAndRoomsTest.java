package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

import java.util.List;

/**
 * @author Leammin
 * @date 2020-06-11
 */
class KeysAndRoomsTest extends AbstractTest<KeysAndRooms> {
    @Override
    protected Testsuite<KeysAndRooms> testsuite() {
        return Testsuite.<KeysAndRooms>builder()
                .add(ExpectedTestcase.of(t -> t.canVisitAllRooms(List.of(List.of())), true))
                .add(ExpectedTestcase.of(t -> t.canVisitAllRooms(List.of(
                        List.of(1),
                        List.of(2),
                        List.of(3),
                        List.of()
                )), true))
                .add(ExpectedTestcase.of(t -> t.canVisitAllRooms(List.of(
                        List.of(1,3),
                        List.of(3,0,1),
                        List.of(2),
                        List.of(0)
                )), false))
                .build();
    }
}