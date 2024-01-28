# Spring Boot & Spring Cloud

A real world example to put in practice microservices architecture, secure them with spring security and explore [Netflix Spring Cloud](https://spring.io/projects/spring-cloud-netflix) integrations.

## Requirements

- Java 11 
- Spring Boot 2
- Gradle 
- CURL
- JQ
- Docker

## How to start a Microservice

To start a microservice you need to execute the next command inside the project folder:
```bash
JAVA_HOME=/usr/lib/jvm/java-11 ./gradlew bootRun
```

## Services

### Config Service

- **Default URL:** http://localhost:8090/customer-service/default

### Discovery Service (Eureka)
    
- **Default URL:** http://localhost:8099/

### Microservice Product

**Example Requests:**
- GET
    ```bash
    curl -X GET http://localhost:8091/products  -H 'Accept: application/json' | jq '.'
    ```

- POST
    ```bash
    curl  --request POST 'localhost:8091/products' \
    --header 'Content-Type: application/json' \
    --data-raw '{
    "name":"Wallabee Men'\''s Suede Shoe",
    "description":"Comfort and tendency do not have to be at odds. This suede wallabee style shoe is all you need for marathon work days. With soft suede design and stitched details, it is perfect to combine with jeans",
    "stock":4,
    "price":30,
    "category":{"id":1,"name": "shoes"}
    }'
    ```

### Microservice Customer

**Example Requests:**
- GET
    ```bash
    curl -X GET http://localhost:8092/customers    -H 'Accept: application/json' | jq '.'
    ```

- POST
    ```bash
    curl --request POST 'localhost:8092/customers' \
    --header 'Content-Type: application/json' \
    --data-raw '
        {
            "numberID":"40408083",
            "firstName": "Luis",
            "lastName": "rodriguez",
            "email": "profesor@digitallab.academy",
            "photoUrl": "",
            "region": {
                "id": 1
            }
        }
    '
    ```

### Microservice Shopping

**Example Requests:**
- GET
    ```bash
    curl -X GET http://localhost:8093/invoices/1 -H 'Accept: application/json' | jq '.'
    ```

- POST
    ```bash
    curl  --request POST 'localhost:8093/invoices' \
    --header 'Content-Type: application/json' \
    --data-raw '{

        "numberInvoice": "002",
        "description": "invoice store",
        "customerId": 1,
        "items": [
            {
                "quantity": 1,
                "priceItem": 178.89,
                "productId": 1
            },
    
            {
                "quantity": 2,
                "priceItem": 40.06,
                "productId": 3
            }
        ]
    }'
    ```

### Gateway Service 

**Example Requests:**
- Customer
    ```bash
    curl -X GET http://localhost:8080/customers    -H 'Accept: application/json' | jq '.'
    ```

- Products
    ```bash
    curl -X GET http://localhost:8080/products  -H 'Accept: application/json' | jq '.'
    ```

- Invoices
    ```bash
    curl -X GET http://localhost:8080/invoices/1 -H 'Accept: application/json' | jq '.'
    ```
