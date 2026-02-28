.PHONY: test test-all new done undone

MVN_EXEC = mvn -q exec:java
ARGS = $(if $(filter-out $@,$(MAKECMDGOALS)),-Dexec.args="$(filter-out $@,$(MAKECMDGOALS))")

# Usage: make new [id/title/url]
new:
	$(MVN_EXEC) -Dexec.mainClass="com.leammin.leetcode.main.Leetcoder" $(ARGS)

# Usage: make test-all
test-all:
	mvn test -Dtest="com.leammin.leetcode.easy.*Test, com.leammin.leetcode.medium.*Test, com.leammin.leetcode.hard.*Test"

# Usage: make test [id/title/url/class]
test:
	$(MVN_EXEC) -Dexec.mainClass="com.leammin.leetcode.main.LeetcodeResolver" $(ARGS)

# Usage: make done [id/title/url/class]
done:
	$(MVN_EXEC) -Dexec.mainClass="com.leammin.leetcode.main.LeetcodeDone" $(ARGS)

# Usage: make undone [id/title/url/class]
undone:
	$(MVN_EXEC) -Dexec.mainClass="com.leammin.leetcode.main.LeetcodeUndone" $(ARGS)

%:
	@:
