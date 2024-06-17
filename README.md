# EXCHANGE

## Description

> **Currency conversion API:** This application allows you to retrieve and view exchange rates from the initial startup of the application up to the present moment.

_Build with Java Spring Boot Framework and PostgresQL_

## Endpoints

- **GET** `/symbols`:
  - Returning all available currencies.
- **GET** `/exchanges/`:
  - Returns all saved exchange rates
- **GET** `/exchanges/{date}`:
  - Return exchanges rates by date
  - Date format: ***YYYY-MM-DD*** (***latest*** get current rates)

## Instructions for starting the project

### Prerequisites

- Make sure you have Java 19 and Maven installed on your machine. You can download Java from [the official Java website](https://www.oracle.com/java/) and Maven from [Apache Maven](https://maven.apache.org/).
- Make sure you have [postgresql](https://www.postgresql.org/) installed on your machine.

### Steps to get started

1. **Close the project:**

   ```bash
   git clone https://github.com/micael-jerry/exchange-api.git
   cd exchange-api

2. **Install dependencies**

    ```bash
    mvn clean install

3. **Configuration**

- Create database with name: `exchange`
- Access the [application.properties](./src/main/resources/application.properties) and uncomment and complete the fields
- And also add `api.key` which you can get [here](https://apilayer.com/marketplace/fixer-api?utm_source=apilayermarketplace&utm_medium=featured&e=Sign+In&l=Success) after creating an account and using the free option

4. **Run app**

   ```bash
   mvn spring-boot:run
   ```

## Future features

- Get exchange rates from the desired base (default: `USD`)
- Currency conversion
- Filter by currency