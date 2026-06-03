# CI Workflows — Software Engineering II Project

## m4-mutation.yml

Continuous Integration pipeline for Milestone 4 (De Angelis testing module).

**Triggers:**
- Every push to `master` that touches `m4_mutation/` or this workflow file
- Pull requests to `master`
- Manual dispatch (`workflow_dispatch`)

**Steps:**
1. Checkout the repository
2. Setup JDK 11 (Temurin) with Maven cache
3. Compile main sources (`mvn compile`)
4. Compile test sources (`mvn test-compile`)
5. Run JUnit tests (`mvn test`)
6. Run PIT mutation coverage analysis
7. Upload HTML mutation report as a workflow artifact (retained 30 days)

**Purpose:** automatically validates that the refactored `Math.java` keeps compiling,
all unit tests keep passing, and the mutation score does not regress on every change.
