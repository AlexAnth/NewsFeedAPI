# News Feed API
SpringBoot API with Webflux

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.0/maven-plugin/reference/html/#build-image)
* [GraalVM Native Image Support](https://docs.spring.io/spring-boot/docs/3.0.0/reference/html/native-image.html#native-image)
* [Spring Reactive Web](https://docs.spring.io/spring-boot/docs/3.0.0/reference/htmlsingle/#web.reactive)
* [Spring Security](https://docs.spring.io/spring-boot/docs/3.0.0/reference/htmlsingle/#web.security)
* [Spring Data Reactive MongoDB](https://docs.spring.io/spring-boot/docs/3.0.0/reference/htmlsingle/#data.nosql.mongodb)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a Reactive RESTful Web Service](https://spring.io/guides/gs/reactive-rest-service/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)

### Additional Links
These additional references should also help you:

* [Configure AOT settings in Build Plugin](https://docs.spring.io/spring-boot/docs/3.0.0/maven-plugin/reference/htmlsingle/#aot)

## GraalVM Native Support

This project has been configured to let you generate either a lightweight container or a native executable.
It is also possible to run your tests in a native image.

### Lightweight Container with Cloud Native Buildpacks
If you're already familiar with Spring Boot container images support, this is the easiest way to get started.
Docker should be installed and configured on your machine prior to creating the image.

To create the image, run the following goal:

```
$ ./mvnw spring-boot:build-image -Pnative
```

Then, you can run the app like any other container:

```
$ docker run --rm storyteller:0.0.1-SNAPSHOT
```

### Executable with Native Build Tools
Use this option if you want to explore more options such as running your tests in a native image.
The GraalVM `native-image` compiler should be installed and configured on your machine.

NOTE: GraalVM 22.3+ is required.

To create the executable, run the following goal:

```
$ ./mvnw native:compile -Pnative
```

Then, you can run the app as follows:
```
$ target/storyteller
```

You can also run your existing tests suite in a native image.
This is an efficient way to validate the compatibility of your application.

To run your existing tests in a native image, run the following goal:

```
$ ./mvnw test -PnativeTest
```


# Spring Boot OpenAI Bot

Sample application showing how to use Spring Boot with OpenAI's GPT-3 API.

This is a fully reactive application that uses Spring WebFlux and the OpenAI streaming API,
that can be packaged as a GraalVM native image.

## Features

* Spring Boot 3
* Fully reactive with Spring WebFlux and Spring WebClient
* OpenAI streaming API
* Native image with GraalVM
* Deployment to Azure Container Apps

## Getting Started

### Prerequisites

- Java 17
- Access to OpenAI's GPT-3 API

### Installation

```bash
./mvnw package
```

### Quickstart

You will need to set the following environment variables to access OpenAI's API:

```bash
export APPLICATION_OPENAI_KEY=<your-openai-api-key>
export APPLICATION_OPENAI_URL=<your-openai-url>
```

## Demo

```bash
./mvnw spring-boot:run
```

## Resources

To customize the OpenAI prompt, you can check the following resource:

- [Prompt Engineering Guide](https://github.com/dair-ai/Prompt-Engineering-Guide)
