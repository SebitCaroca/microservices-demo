# This file will describe the reasonings behind each dependency used.

---

## Server dependencies
- Config Server — Allows for a more centralized way to configure the involved services, without having to restart each one individually.
- Eureka Server — Allows for a more dynamic way of linking each microservice together, without having to rely on fixed variables.
- Spring Cloud Gateway — Acts as the entry point for all requests, routing them to the appropiate microservice. It also integrates natively with Eureka & Security.

## Client dependencies
- Config Client — Communicates with Config Server to fetch its corresponding configuration data.
- Eureka Discovery Client — Communicates with Eureka Server so that a microservice can be able to communicate with others.
- OAuth2 Resource Server — Validates the JWT tokens issued by the IAM service (In this case, Keycloak), rejecting them if they fail said validation.

## Internal dependencies
- Spring Web — Enables HTTP communication between microservices, allowing the capability to expose REST endpoints via Controllers (*@RestController*, *@GetMapping*, etc.)
- Spring Data JPA — A way to implement the JPA Standard through Hibernate, providing database interaction without the need of manually writing SQL queries (most of the time) through query-generating methods (such as *findByUsername*), and standard CRUD operations (such as *getById* or *save*).
- PostgreSQL Driver — Enables support with PostgreSQL databases. Can be replaced with corresponding drivers for other databases (such as MySQL) when necessary.

## Complementary dependencies
- Actuator — Exposes ports that allow health verifications, alongside other utils.
- Lombok — Minimizes the amount of verbose code by using tags instead (eg. instead of writing getters manually, you write the @Getter tag instead)
- Validator — Validates a variable's integrity, and evaluates if the conditions are met for such data type to exist (eg. it's between two values, the string is not empty, etc.)

---
