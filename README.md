# Containerized java services
### Built with Spring Boot, React, Docker and MySQL

This repository acts as a test-artifact for my thesis; investigating the potential cold start variances of compiling microservices Ahead-of-time or Just-in-time.

A quick test gave the following results.

JVM:<br>
```Started TestApplication in 1.495 seconds (process running for 1.935)```

GraalVM:<br>
```Started TestApplication in 0.041 seconds (process running for 0.044)```
