# SeleniumJava‑WebAutomation

End‑to‑end web UI test automation framework using **Selenium WebDriver** with **Java**, managed by **Maven**, and following best practices for maintainability and readability.

---

## Table of Contents

1. [Overview](#overview)
2. [Features](#features)
3. [Prerequisites](#prerequisites)
4. [Installation & Setup](#installation--setup)
5. [Project Structure](#project-structure)
6. [Configuration](#configuration)
7. [Writing Test Cases](#writing-test-cases)
8. [Execution](#execution)
9. [Reporting](#reporting)
10. [Contributing](#contributing)
11. [License](#license)

---

## Overview

This framework automates web application testing using Selenium WebDriver in Java, providing:

* Page Object Model (POM) for clean separation of page interactions.
* TestNG for test orchestration and annotations.
* Maven for build and dependency management.
* Data‑driven test support via TestNG data providers.

Use this project to write robust, maintainable UI tests that can run locally or in CI environments.

---

## Features

* **Page Object Model**: Encapsulate UI elements and actions.
* **TestNG**: Flexible test grouping, prioritization, and parameterization.
* **Maven**: Simplified build, dependency, and plugin management.
* **Logging**: Integrated logging with Log4j2.
* **Data‑Driven**: Data providers for multiple input scenarios.
* **Cross‑Browser**: Support for Chrome, Firefox, and Edge.

---

## Prerequisites

* **Java JDK 8+** (set `JAVA_HOME`)
* **Maven 3.6+**
* **ChromeDriver**, **GeckoDriver**, **EdgeDriver** in your PATH or managed via WebDriverManager.

---

## Installation & Setup

1. **Clone repository**:

   ```bash
   git clone https://github.com/zuchalbastian/SeleniumJava-WebAutomation.git
   cd SeleniumJava-WebAutomation
   ```
2. **Build project**:

   ```bash
   mvn clean compile
   ```
3. **Install dependencies** (automatically managed by Maven):

   ```bash
   mvn dependency:resolve
   ```

---

## Project Structure

```plaintext
SeleniumJava-WebAutomation/
├── pom.xml                 # Maven configuration
├── src/main/java/
│   ├── pages/              # Page Object classes
│   ├── utils/              # Utility classes (e.g., WebDriverFactory, ConfigReader)
│   └── tests/              # Test classes using TestNG
├── src/main/resources/
│   └── config.properties   # Environment-specific settings
├── src/test/resources/
│   └── testdata/           # Data files (CSV, JSON)
└── logs/                   # Execution logs
```

---

## Configuration

* **config.properties**: define base URL, browser type, timeouts.

  ```properties
  base.url=https://example.com
  browser=chrome
  implicit.wait=10
  ```
* **WebDriverFactory**: reads `config.properties` to initialize driver instances.

---

## Writing Test Cases

* Place tests in `src/main/java/tests` and name using `Test` suffix (e.g., `LoginTest`).
* Use TestNG annotations:

  ```java
  @BeforeClass
  public void setUp() {
      driver = WebDriverFactory.createDriver();
      driver.get(ConfigReader.get("base.url"));
  }

  @Test(dataProvider = "loginData")
  public void testLogin(String user, String pass) {
      LoginPage login = new LoginPage(driver);
      login.login(user, pass);
      Assert.assertTrue(login.isLoginSuccessful());
  }

  @AfterClass
  public void tearDown() {
      driver.quit();
  }
  ```
* **Data Providers**: implement in test classes or a separate provider utility.

---

## Execution

* **Single Test**:

  ```bash
  mvn test -Dtest=LoginTest
  ```
* **All Tests**:

  ```bash
  mvn test
  ```
* **Custom TestNG Suite**: define `testng.xml` in project root and run:

  ```bash
  mvn test -DsuiteXmlFile=testng.xml
  ```

---

## Reporting

* TestNG generates default HTML reports at `test-output/index.html`.
* Enhanced reports via plugins (e.g., Allure) can be configured in `pom.xml`.
* Logs saved under `logs/` directory.

---

## Contributing

1. Fork the repo.
2. Create a branch: `git checkout -b feature/YourFeature`.
3. Commit and push: `git push origin feature/YourFeature`.
4. Open a Pull Request with your changes.

---

## License

Distributed under the [MIT License](LICENSE).

---

*Generated with ❤️ by Zuchal Ari Bastian*
