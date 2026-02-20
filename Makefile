BASE = src/main/java/com/leammin/leetcode

.PHONY: test test-all new done

# Create a new problem file
# Usage: make new                  - interactive input
#        make new two-sum          - directly by title/id/url
new:
	mvn -q exec:java -Dexec.mainClass="com.leammin.leetcode.main.Leetcoder" \
		$(if $(filter-out $@,$(MAKECMDGOALS)),-Dexec.args="$(filter-out $@,$(MAKECMDGOALS))")

# Run all easy/medium/hard tests (excluding undone)
# Usage: make test-all
test-all:
	mvn test -Dtest="com.leammin.leetcode.easy.*Test, com.leammin.leetcode.medium.*Test, com.leammin.leetcode.hard.*Test"

# Run test by id/title/url/class name
# Usage: make test two-sum
#        make test 1
#        make test TwoSum
#        make test https://leetcode.cn/problems/two-sum/
test:
	@TEST_CLASS=$$(mvn -q exec:java \
		-Dexec.mainClass="com.leammin.leetcode.main.LeetcodeResolver" \
		$(if $(filter-out $@,$(MAKECMDGOALS)),-Dexec.args="$(filter-out $@,$(MAKECMDGOALS))") \
		| grep '^TEST:' | cut -d: -f2); \
	if [ -z "$$TEST_CLASS" ]; then exit 1; fi; \
	echo "Running: $$TEST_CLASS"; \
	mvn test -Dtest="$$TEST_CLASS"

# Mark problem as done (move from undone to done directory)
# Re-running on completed problem only prints a reminder, no error.
# Usage: make done two-sum
#        make done 1
#        make done TwoSum
#        make done https://leetcode.cn/problems/two-sum/
done:
	mvn -q exec:java -Dexec.mainClass="com.leammin.leetcode.main.LeetcodeDone" \
		$(if $(filter-out $@,$(MAKECMDGOALS)),-Dexec.args="$(filter-out $@,$(MAKECMDGOALS))")

# Catch extra arguments so make doesn't complain about unknown targets
%:
	@:
