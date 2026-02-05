# Item Management REST API (Spring Boot)

## Project Overview

A Spring Boot backend that exposes a REST API to manage items (e.g. products). It uses **in-memory storage** (no database), Spring Web, and input validation.

## Tech Stack

- Java 17
- Spring Boot
- Spring Web
- Spring Validation
- Maven
- Lombok

## Project Structure

```
com.example.Products
├── controller
│   └── ItemController.java
├── service
│   └── ItemService.java
├── repository
│   └── ItemRepository.java
├── models
│   └── Item.java
└── ProductsApplication.java
```

## Setup & Run

### Prerequisites

- Java 17
- Maven

### Steps

1. Clone or download the project.
2. Open in an IDE (e.g. IntelliJ) and reload Maven.
3. Run the main class: **`ProductsApplication.java`**
4. Server starts at: **http://localhost:8080**

From terminal:

```bash
./mvnw spring-boot:run
```

## API Endpoints

Base path: **`/api/items`**

| Method | Path           | Description      |
|--------|----------------|------------------|
| POST   | `/api/items/`  | Add a new item   |
| GET    | `/api/items/`  | Get all items    |
| GET    | `/api/items/{id}` | Get item by ID |

### 1. Add Item

**POST** `/api/items/`

Request body (JSON):

```json
{
  "name": "Laptop",
  "description": "Gaming laptop",
  "price": 75000
}
```

Response (200):

```json
{
  "id": 1,
  "name": "Laptop",
  "description": "Gaming laptop",
  "price": 75000
}
```

### 2. Get Item by ID

**GET** `/api/items/{id}`  

Example: `GET /api/items/1`

- **200** – Item found (JSON as above)
- **404** – Item not found

### 3. Get All Items

**GET** `/api/items/`

Response: array of items, e.g.:

```json
[
  {
    "id": 1,
    "name": "Laptop",
    "description": "Gaming laptop",
    "price": 75000
  }
]
```

## Validation

When adding an item:

| Field       | Rule                    |
|------------|-------------------------|
| name       | Required, not blank     |
| description| Required, not blank     |
| price      | Required, must be > 0   |

Invalid request (e.g. empty name/description or negative price) returns **400 Bad Request**.

## Notes

- Data is stored in memory (ArrayList); it is lost on restart.
- IDs are generated in the repository.
- No database or JPA.

## Architecture

```
Controller → Service → Repository → ArrayList
```

- **Controller** – HTTP requests/responses  
- **Service** – Business logic  
- **Repository** – In-memory data

---

Developed as part of a Spring Boot backend assignment.
