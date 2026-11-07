## Jenkins CI Integration

This project is integrated with Jenkins for automated execution of UI Smoke and UI Regression test suites.

### Jenkins Pipeline Jobs

| Jenkins Job | Test Suite | Maven Profile | Execution |
|---|---|---|---|
| UIHRM-Smoke | Smoke Tests | `smoke` | `mvn clean test -Psmoke` |
| UIHRM-Regression | Regression Tests | `regression` | `mvn clean test -Pregression` |

### Pipeline Implementation

- Configured separate Jenkins Pipeline jobs for Smoke and Regression execution.
- Integrated the GitHub repository with Jenkins using Git SCM.
- Used dedicated Jenkinsfiles for the two execution pipelines.
- Configured JDK and Maven tools in Jenkins.
- Used Maven profiles to select the appropriate TestNG groups.
- Configured Jenkins test-result publication using Maven Surefire XML reports.

### Execution Flow

GitHub Repository → Jenkins SCM Checkout → Maven Build → TestNG Group Selection → Selenium WebDriver Execution → Test Reports

### Jenkins Pipeline Files

- `UIHRMAutomationFramework/Jenkinsfile` – UI Smoke pipeline.
- `UIHRMAutomationFramework/Jenkinsfile-regression` – UI Regression pipeline.

### Execution Evidence

See the `docs/jenkins/` folder for screenshots of the Jenkins jobs and build results.
