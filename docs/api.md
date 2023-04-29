# Parliament NewsFeed API

**Description**: Parliament NewsFeed API provides access to parliamentary articles related to legislative proceedings. The API allows users to retrieve articles based on various criteria, such as unique identifiers, categories, authors, publications, and more.

## Base URL

`http://localhost:8080`

## Endpoints

### Create Article

**Endpoint**: `/articles`

- **Method**: POST
- **Summary**: Retrieve an article based on a unique identifier.
- **Request Body**: Article object
    - Required: Yes
- **Responses**:
    - `201`: Article created
        - Content: Article object
    - `500`: Internal server error

### Get Article

**Endpoint**: `/articles/{id}`

- **Method**: GET
- **Summary**: Retrieve an article based on a unique identifier.
- **Parameters**:
    - `id` (path parameter): The unique article ID
        - Required: Yes
        - Type: string
- **Responses**:
    - `200`: Article found
        - Content: Article object
    - `404`: Article not found
    - `500`: Internal server error

### Get All Publications

**Endpoint**: `/articles/publications`

- **Method**: GET
- **Summary**: Retrieve a stream of all available publications.
- **Responses**:
    - `200`: Publications were found
        - Content: Array of Publication objects
    - `404`: Publications were not found
    - `500`: Internal server error

### Get Articles by Publication

**Endpoint**: `/articles/publication/{id}`

- **Method**: GET
- **Summary**: Retrieve a stream of articles based on a publication identifier.
- **Parameters**:
    - `id` (path parameter): The publication ID
        - Required: Yes
        - Type: string
        - Example: ΤΕΥΧΟΣ_055
- **Responses**:
    - `200`: Articles found
        - Content: Article object
    - `404`: Articles with the specified publication ID were not found
        - Content: Array of Article objects
    - `500`: Internal server error
        - Content: Array of Article objects

### Get All Categories

**Endpoint**: `/articles/categories`

- **Method**: GET
- **Summary**: Retrieve a stream of all available article categories.
- **Responses**:
    - `200`: Categories were found
        - Content: Array of Category objects
    - `404`: Categories were not found
    - `500`: Internal server error

### Get All Authors

**Endpoint**: `/articles/authors`

- **Method**: GET
- **Summary**: Retrieve a stream of all authors of available articles.
- **Responses**:
    - `200`: Authors were found
        - Content: Array of Author objects
    - `404`: Authors were not found
    - `500`: Internal server error

## Schemas

### Article

The article entity.

- **Properties**:
    - `id` (string): The article identifier
    - `category` (string): The article category
    - `headline` (string): The article headline
    - `subhead` (string): The article subhead
    - `introduction` (string): The introductory paragraph containing the article context
    - `magazine` (string): The magazine name
    - `author` (string): The article author
    - `publication` (string): The article publication
    - `date` (string): The publication date
    - `meeting` (string): The media URL of the corresponding parliamentary session
    - `content` (string): The article content

### Publication

- **Properties**:
    - `publication` (string): The publication name

### Category

- **Properties**:
    - `category` (string): The category name

### Author

- **Properties**:
    - `author` (string): The author name

    