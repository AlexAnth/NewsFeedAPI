# News Feed API 📢

#### <i> SpringBoot API with Webflux </i>

[![Build Status](https://github.com/AlexAnth/NewsFeedAPI/actions/workflows/maven.yml/badge.svg?style=flat-square)](https://github.com/AlexAnth/NewsFeedAPI/actions/workflows/maven.yml/badge.svg)
[![License](https://img.shields.io/badge/license-GNU%20General%20Public%20Licence-blue.svg?style=flat-square)](https://github.com/AlexAnth/NewsFeedAPI/LICENSE)
[![Docker Image Status](https://github.com/AlexAnth/NewsFeedAPI/actions/workflows/docker-image.yml/badge.svg?style=flat-square)](https://github.com/AlexAnth/NewsFeedAPI/actions/workflows/docker-image.yml/badge.svg)

---

The NewsFeed API is a powerful RESTful API built using Spring Boot, Java 17, and Spring WebFlux. Leveraging the reactive programming model, this API provides a high-performance and non-blocking solution for storing and retrieving parliamentary articles in a MongoDB document database. This means that the API is capable of efficient handling of concurrent requests, allowing for optimal utilization of system resources.

With this API, you can effortlessly distribute and manage articles content, with operations like create, read, update, and delete on information resources. Additionally, the API offers robust search functionality, enabling you to find articles based on various criteria, such as keywords, authors, or publication dates. With support for pagination, you can also navigate easily through the extensive collection of articles.

## Prerequisites

Before running the application, ensure that you have the following software installed:

- Java Development Kit (JDK) 17
- MongoDB
- Maven (for building and running the application)

## Getting Started

Follow the steps below to get started with newsfeed in Docker:

1. Build the Docker image:

   ```shell
   docker build -t newsfeed:newsfeedAPI .
   ```

2. Run the NewsFeed API container:

   ```shell
   docker run --network=host newsfeed:newsfeedAPI
   ```

3. Verify that the containers are running:

   ```shell
   docker ps
   ```

## API Documentation

The API is documented using Swagger UI. You can access the Swagger UI documentation at `http://localhost:8080/api-doc` after starting the NewsFeed API container.


<div style="display: flex; justify-content: center; align-items: center;">
    <img src="https://raw.githubusercontent.com/AlexAnth/NewsFeedAPI/main/docs/swagger.png" style="border-radius: 1%;" alt="Swagger API Documentation">
</div>



## API Endpoints

The following are the main endpoints provided by NewsFeed API:

- `GET /articles`: Retrieve a list of all articles.
- `GET /articles/{id}`: Retrieve a specific article by its ID.
- `POST /articles`: Create a new article.
- `PUT /articles/{id}`: Update an existing article.
- `DELETE /articles/{id}`: Delete an article.
- `GET /articles/publications`: Retrieve a stream of all the publications available.
- `GET /articles/publication/{id}`: Retrieve a stream of articles based on the publication identifier.
- `GET /articles/categories`: Retrieve a stream of all the available article categories.
- `GET /articles/authors`: Retrieve a stream of all the authors of available articles.

For detailed information about each endpoint and their request/response formats, refer to the [API documentation](docs/api.md).

## Contributing

Contributions to the Parliament Magazine API are welcome! If you find any bugs or have suggestions for improvements, please open an issue or submit a pull request.

Before contributing, please read our [contribution guidelines](docs/CONTRIBUTING.md).

## License

This project is licensed under the [General Public License](docs/LICENSE).

## Contact

For any questions or inquiries, please contact [anthiswebdev@gmail.com](mailto:anthiswebdev@gmail.com).
