# Documents Management Application

This repository hosts a full-stack application facilitating document management. The backend, built with Spring Boot and integrated with MinIO for object storage, offers RESTful services. The Angular-based frontend provides a smooth user interface.

## Features

- Add new books with title, author, and cover image.
- View a list of all added books.
- (Any other features your application provides.)

## Technologies

- Backend: Spring Boot, MinIO for object storage
- Database: H2 (or specify if another database is used)

## Getting Started

### Prerequisites

- JDK 17
- Gradle (for backend)
- Docker (for running MinIO)

### Backend Setup

1. Clone the repository.
2. In the root directory, run `gradle build` to build the backend project.
3. Launch the backend server with `gradle bootRun`.

### MinIO Setup

1. Make sure Docker is up and running.
2. Use the `docker-compose.yml` file at the root of the project to start MinIO.
3. The MinIO dashboard is available at `http://localhost:9001`.

### Curl test
```curl --location 'http://localhost:8080/documents' \
--form 'document="{\"title\":\"test\", \"description\":\"test\"}";type=application/json' \
--form 'files=@"path-to-your-file"'
