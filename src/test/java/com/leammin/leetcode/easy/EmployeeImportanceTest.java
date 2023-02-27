package com.leammin.leetcode.easy;

import java.util.List;

import com.leammin.leetcode.easy.EmployeeImportance.Employee;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-05-06
 */
class EmployeeImportanceTest extends AbstractTest<EmployeeImportance> {
    @Override
    protected Testsuite<EmployeeImportance> testsuite() {
        return Testsuite.<EmployeeImportance>builder()
            .addExpected(t -> {
                Employee e1 = new Employee();
                e1.id = 1;
                e1.importance = 5;
                e1.subordinates = List.of(2, 3);
                Employee e2 = new Employee();
                e2.id = 2;
                e2.importance = 3;
                e2.subordinates = List.of();
                Employee e3 = new Employee();
                e3.id = 3;
                e3.importance = 3;
                e3.subordinates = List.of();
                return t.getImportance(List.of(e1,e2,e3), 1);
            }, 11)
                .build();
    }
}