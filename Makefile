BASE = src/main/java/com/leammin/leetcode

.PHONY: test test-all new

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

# Run exact test by problem name
# Usage: make test AddBinary
test:
	@FILE=$$(find $(BASE)/easy $(BASE)/medium $(BASE)/hard $(BASE)/undone \
		-name "$(filter-out $@,$(MAKECMDGOALS)).java" 2>/dev/null | head -1); \
	if [ -z "$$FILE" ]; then \
		echo "Error: '$(filter-out $@,$(MAKECMDGOALS))' not found"; exit 1; \
	fi; \
	CLASS=$$(basename "$$FILE" .java); \
	PKG=$$(head -1 "$$FILE" | sed 's/package //;s/;//'); \
	echo "Running: $$PKG.$${CLASS}Test"; \
	mvn test -Dtest="$$PKG.$${CLASS}Test"

# Fuzzy search and run matching tests (case-insensitive)
# Usage: make search sort
search:
	@FILES=$$(find $(BASE)/easy $(BASE)/medium $(BASE)/hard $(BASE)/undone \
		-iname "*$(filter-out $@,$(MAKECMDGOALS))*.java" 2>/dev/null); \
	if [ -z "$$FILES" ]; then \
		echo "Error: No problem matching '$(filter-out $@,$(MAKECMDGOALS))'"; exit 1; \
	fi; \
	TESTS=""; \
	for FILE in $$FILES; do \
		CLASS=$$(basename "$$FILE" .java); \
		PKG=$$(head -1 "$$FILE" | sed 's/package //;s/;//'); \
		TESTS="$${TESTS:+$$TESTS, }$$PKG.$${CLASS}Test"; \
	done; \
	echo "Running: $$TESTS"; \
	mvn test -Dtest="$$TESTS"

# Catch extra arguments so make doesn't complain about unknown targets
%:
	@:
