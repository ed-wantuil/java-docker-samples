# Java Docker Sample with Spring and Gradle

Welcome to the **Java Docker  Sample**! This project demonstrates how to integrate Java 21 with Docker, using Spring Framework and Gradle. Each branch showcases the progression of tests and the project's evolution. ⚡

## 🚀 Getting Started

### Prerequisites

To run this project, ensure you have the following installed:

- **Java 21**
- **Gradle**
- **Docker**

### Setting Up the Environment

#### 1. Postgres Connect

To run the project, you need to have a remote PostgreSQL configured or installed locally on your computer.

This will create a container named `postgres-container` with:

- **User**: `ed-wantuil`
- **Password**: `complex-password`
- **Database**: `java-docker-sample`

PostgreSQL will be exposed on port `5432`.

#### 2. Start the Spring Application Locally

Once the database is up, start the Spring application locally:

```bash
./gradlew bootRun
```

This command compiles and runs the Spring Boot application, making it available on `http://localhost:8080` by default.

#### 3. Run Tests

To execute the project's tests, use:

```bash
./gradlew test
```

This will run all tests and provide a summary of the results.

## 🔄 Branches

Each branch represents a stage of the project's development.

Switch between branches to observe the progression and learn step by step.

## 🙏 Acknowledgments

Thank you for checking out this project. Happy coding! ❤‍💻
