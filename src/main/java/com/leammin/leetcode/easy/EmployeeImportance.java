package com.leammin.leetcode.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import com.leammin.leetcode.easy.EmployeeImportance.Employee;
import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 690. 员工的重要性
 * 
 * <p>给定一个保存员工信息的数据结构，它包含了员工<strong>唯一的id</strong>，<strong>重要度&nbsp;</strong>和 <strong>直系下属的id</strong>。</p>
 * 
 * <p>比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于<strong>并不是直系</strong>下属，因此没有体现在员工1的数据结构中。</p>
 * 
 * <p>现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre>
 * <strong>输入:</strong> [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * <strong>输出:</strong> 11
 * <strong>解释:</strong>
 * 员工1自身的重要度是5，他有两个直系下属2和3，而且2和3的重要度均为3。因此员工1的总重要度是 5 + 3 + 3 = 11。
 * </pre>
 * 
 * <p><strong>注意:</strong></p>
 * 
 * <ol>
 * 	<li>一个员工最多有一个<strong>直系</strong>领导，但是可以有多个<strong>直系</strong>下属</li>
 * 	<li>员工数量不超过2000。</li>
 * </ol>
 * 
 * 
 * @author Leammin
 * @date 2021-05-06
 */
public interface EmployeeImportance {
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    int getImportance(List<Employee> employees, int id);

    static Testsuite<EmployeeImportance> testsuite() {
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


    class Solution implements EmployeeImportance {

        @Override
        public int getImportance(List<Employee> employees, int id) {
            Map<Integer, Employee> employeeMap = new HashMap<>((int)((employees.size() / 0.75) + 1));
            for(Employee emp : employees) {
                employeeMap.put(emp.id, emp);
            }
            int result = 0;
            Queue<Employee> queue = new LinkedList<>();
            queue.add(employeeMap.get(id));
            while(!queue.isEmpty()) {
                Employee emp = queue.remove();
                result += emp.importance;
                for(Integer sid : emp.subordinates) {
                    queue.add(employeeMap.get(sid));
                }
            }
            return result;
        }
    }
}

class EmployeeImportanceTest extends AbstractTest<EmployeeImportance> {
}
