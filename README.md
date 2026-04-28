# Products API (Kotlin + Spring Boot)

Simple REST API for managing products, built with **Kotlin**, **Spring Boot**, and **PostgreSQL**.

---

## 🚀 Features

* Create product
* Get all products
* Get product by ID
* Update stock
* Update price
* Delete product
* Input validation
* Global error handling

---

## 🛠️ Tech Stack

* Kotlin
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Docker & Docker Compose

---

## 📦 Running with Docker

### 1. Clone the repository

```bash
git clone https://github.com/jordyfoliveira/products-kotlin.git
cd products-kotlin
```

---

### 2. Create `.env` file

```env
POSTGRES_DB=products_db
POSTGRES_USER=app
POSTGRES_PASSWORD=app
POSTGRES_PORT=5433

SERVER_PORT=8081
```

---

### 3. Run the application

```bash
docker compose up --build
```

---

### 4. Access API

```
http://localhost:8081/products
```

---

## 📚 API Endpoints

### Get all products

```
GET /products
```

### Get product by ID

```
GET /products/{id}
```

### Create product

```
POST /products
```

```json
{
  "sku": "SKU123",
  "name": "Product name",
  "description": "Optional description",
  "price": 10.50,
  "stock": 100
}
```

### Update stock

```
PATCH /products/{id}/stock
```

```json
{
  "stock": 50
}
```

### Update price

```
PATCH /products/{id}/price
```

```json
{
  "price": 15.99
}
```

### Delete product

```
DELETE /products/{id}
```

---

## ⚙️ Notes

* `createdAt` is set on creation
* `updatedAt` is **null until the first update**
* SKU must be unique
* Validation is enforced on input data

---

## 📁 Environment variables

| Variable          | Description       |
| ----------------- | ----------------- |
| POSTGRES_DB       | Database name     |
| POSTGRES_USER     | Database user     |
| POSTGRES_PASSWORD | Database password |
| POSTGRES_PORT     | Local DB port     |
| SERVER_PORT       | API port          |

---

## 🧪 Run locally (without Docker)

Configure `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5433/products_db
spring.datasource.username=app
spring.datasource.password=app
server.port=8081
```

Then run:

```bash
./gradlew bootRun
```

---

## 📌 Future improvements

* Add pagination
* Add authentication (JWT)
* Add integration tests
* Add CLI client (like Python version)
* Use DTOs for responses
* Add Swagger / OpenAPI

---

## 👨‍💻 Author

Jordy Oliveira
