# This file will describe what dependencies correspond to each microservice, grouped by any given service.

---

Elements that are highlighted in **bold** are client dependencies that fetch data from another service, or in other words, require another service to work properly.

Elements that are *italicized* are server dependencies that give data to other services, and are independent by themselves. Does not imply the microservice itself is independent, just the particular dependency.

Elements that are neither *italicized* or **bold** are dependencies that work within the scope of the microservice.

---

ConfigServer:

- *Config Server*
- Actuator
- Lombok
- Validator

Eureka:

- *Eureka Server*
- **Config Client**
- Actuator
- Lombok
- Validator

Gateway:

- *Spring Cloud Gateway*
- **Eureka Discovery Client**
- **Config Client**
- **OAuth2 Resource Server**
- Actuator
- Lombok
- Validator

Profile Service:

- Spring Web
- Spring Data JPA
- PostgreSQL Driver
- **Eureka Discovery Client**
- **Config Client**
- **OAuth2 Resource Server**
- Actuator
- Lombok
- Validator

Post Service:
- (same as Profile Service, to be updated if there are potential changes in the future for any reason)

---
