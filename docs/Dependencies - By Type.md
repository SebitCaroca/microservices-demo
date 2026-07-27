# This file will describe what dependencies correspond to each microservice, grouped by the dependency type.

---

Elements that are highlighted in **bold** are client dependencies that fetch data from another service, or in other words, require another service to work properly.

Elements that are *italicized* are server dependencies that give data to other services, and are independent by themselves. Does not imply the microservice itself is independent, just the particular dependency.

Elements that are neither *italicized* or **bold** are dependencies that work within the scope of the microservice.

---

## Server dependencies
- *Config Server* — ConfigServer only
- *Eureka Server* — Eureka only
- *Spring Cloud Gateway* — Gateway only

## Client dependencies
- **Config Client** — Eureka, Gateway, Profile, Post
- **Eureka Discovery Client** — Gateway, Profile, Post
- **OAuth2 Resource Server** — Gateway, Profile, Post

## Internal dependencies
- Spring Web — Profile, Post
- Spring Data JPA — Profile, Post
- PostgreSQL Driver — Profile, Post

## Complementary dependencies
- Actuator — all services
- Lombok — all services
- Validator — all services

---
