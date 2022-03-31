## Run using official jacoco 0.8.7:
`./gradlew app:testDebugUnitTestCoverage`

## Run using forked jacoco:
`./gradlew app:testDebugUnitTestCoverage -PuseFork`

## Open report (OS X):
`open app/build/reports/jacoco/testDebugUnitTestCoverage/html/index.html`

## Saved reports run on my machine:
- Forked `reports/testDebugUnitTestCoverageFork/html/index.html`
- 0.8.7 `reports/testDebugUnitTestCoverageJacoco/html/index.html`