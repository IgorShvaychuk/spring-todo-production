# Spring Boot ToDo Application (Production Ready)

A robust ToDo management application built with Spring Boot, demonstrating modern DevOps practices including Docker containerization, Spring Profiles, and cloud database integration.

## Key Features
- **Multi-Stage Docker Build**: Optimized Docker image for faster deployments and smaller footprint.
- **Environment Profiles**: Configured for seamless switching between `dev` (H2 In-Memory) and `prod` (PostgreSQL) environments.
- **Cloud Native**: Fully prepared for deployment on platforms like Render or Railway.
- **JDBC Persistence**: Robust data handling using `JdbcTemplate`.

## Tech Stack
- **Backend**: Java 17, Spring Boot 3.2
- **Frontend**: Thymeleaf, HTML5
- **Database**: PostgreSQL (Production), H2 (Development)
- **DevOps**: Docker, GitHub Actions (Ready)

## Quick Start (Local Development)

### Running with Docker
```bash
# Build the image
docker build -t todo-app .

# Run the container in Dev mode
docker run -p 8080:8080 -e SPRING_PROFILES_ACTIVE=dev todo-app