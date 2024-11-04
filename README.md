# Appium Test Automation Framework

This repository provides an Appium-based test automation framework for mobile applications. It is designed to support both Android and iOS platforms and uses Cucumber for BDD-style test scenarios.

For a visual demonstration of this test case, please refer to the example video below:

[![Example Video for Test Case](https://img.youtube.com/vi/xbmC4IyqBkk/0.jpg)](https://www.youtube.com/watch?v=xbmC4IyqBkk)

You can click on the image or follow [this link](https://www.youtube.com/watch?v=3wPyg5HPzRc) to watch the example video on YouTube.
## Table of Contents

1. [Requirements](#requirements)
2. [Project Structure](#project-structure)
3. [Configuration](#configuration)
4. [Running Tests](#running-tests)
5. [Author](#author)
## Requirements

To get started with this framework, ensure you have the following installed:

- **Java JDK 11** or higher
- **Maven** for dependency management and project build
- **Appium** server (v1.15 or higher)
- **Android SDK** (if running Android tests)
- **Xcode** (if running iOS tests on macOS)
- **Node.js and npm** (for Appium setup)

## Project Structure

The project follows a structured layout:

- `src/main/java`: Contains main framework code including drivers, utilities, and base classes.
    - **driver**: Contains platform-specific driver factories and a driver manager.
    - **base**: Contains base classes for page objects and test cases.
    - **config**: Manages configuration and settings.
    - **util**: Holds utility classes for handling shared context and error codes.
    - **pages**: Contains page object classes, each representing a screen or module in the application
    - **constants**: Contains centralized constants used across the framework for improved modularity and readability.
- `src/test/java`: Contains the test scenarios and step definitions for Cucumber.
    - **stepdefinitions**: Holds the implementation of Cucumber steps.
    - **runners**: Cucumber runner configurations.
    - **features**: Cucumber feature files.


## Configuration

The configuration file `config.json` contains platform-specific settings and Appium server details. Place this file in the `src/` directory with the following structure:

 ```json
    {
      "appiumUrl": "http://localhost:4723/wd/hub",
      "platform": "android",
      "android": {
        "platformName": "Android",
        "deviceName": "Android Emulator",
        "app": "path/to/android/app.apk"
      },
      "ios": {
        "platformName": "iOS",
        "deviceName": "iPhone Simulator",
        "app": "path/to/ios/app.app"
      }
    }
```

## Running Tests

Running Tests
To execute the test cases in this framework, ensure that you have completed the necessary configuration as described in the Configuration section and that the Appium server is running. Follow these steps to run the tests:

Start the Appium Server: Ensure that the Appium server is running and accessible. The URL for the Appium server should match the value set in the config.json file under appiumUrl.

```
 appium
```

Run the Tests with Maven: Use the following Maven command to execute the tests. This will automatically start running all Cucumber feature files specified in the src/test/resources/features directory:

```
 mvn test
```

View Test Results: After the tests have finished running, you can view the results in the console output. Additionally, a Cucumber HTML report will be generated in the target/cucumber-reports.html file.

Customizing Test Execution: You can specify individual feature files or tags to run specific scenarios. For example, to run scenarios tagged with @smoke, use:

```
mvn test -Dcucumber.filter.tags="@smoke"
```
## Author

Email: cem.acar03@gmail.com
This case was developed by Cem AÇAR.



    

