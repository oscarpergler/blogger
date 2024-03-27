# Containerized java services (Old, see compiled-javaservices for an updated repo)
### This project

This repository acts as a test-artifact for my thesis; investigating the potential cold start variances of compiling microservices Ahead-of-time or Just-in-time.

A quick test gave the following results.

JVM:<br>
```Started TestApplication in 1.495 seconds (process running for 1.935)```

GraalVM:<br>
```Started TestApplication in 0.041 seconds (process running for 0.044)```

### Diagram

![5b(1)](https://github.com/oscarpergler/blogger/assets/70218472/7350cb7b-1b61-4233-8b79-99095b5d1d13)

### Usage
JIT: ```docker-compose -f build.yml up && docker-compose up```
AOT: ```docker-compose -f build-native.yml up && docker-compose up```
