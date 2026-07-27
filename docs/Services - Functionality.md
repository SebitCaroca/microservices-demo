# This file describes what each service in this project is supposed to do, what roles are involved, and other important things.
### It's surprisingly easy to forget.

---

Anything that is *italicized* is future functionality, aka, not implemented in the current version of the project for simplicity's sake.

Keep in mind that this version of the project does not have a frontend for the time being.

---

## Infrastructure

- Config Server:
    - Centralized configuration provider for all services.
    - Each service fetches its own configuration from here on startup,
      instead of managing its own properties/yaml file independently.
    - Supports both local filesystem and Git-backed configuration.
    - Must start before any other service.

- Eureka Server:
    - Service registry. Every microservice registers itself here on
      startup with its name, IP, and port.
    - When a service needs to communicate with another, it asks Eureka
      for its current address instead of using a hardcoded URL.
    - Must start after Config Server, before business services.

- Gateway Server:
    - Single entry point for all incoming requests.
    - Validates Keycloak tokens before forwarding requests to services.
    - Routes requests to the correct service based on the URL path,
      using Eureka to find where each service is running.
    - Must start after Eureka.

## Services

- Profile:
    - **Attributes**: id, userId, displayName, avatarURL, biography
    - Unlike Keycloak, this contains information not relevant to the validation of each account.
    - Functionality:
        - Logged out users cannot see any information here.
        - Logged in normal users can only see their profile.
        - Logged in admin users can see everyone's profile.
- Posts:
    - **Attributes**: id, posterId, message
    - Contains user-submitted messages, akin to a forum, *where the latest message will be at the top, in an ordered list from top to bottom with the syntax "<user\>: <message\>"*
    - The displayed username will be fetched from Profile at read-time through posterId.
    - Functionality:
        - Logged out users can see everything posted here.
        - Logged in normal users can see & post, *but can't delete posts except their own.*
        - Logged in admin users can see, post, *and delete others' posts.*

## External

- Keycloak
  - Authentication service that manages users interacting with the system through their identity.
  - Due to its focus on identity management, although it can hold multiple attributes, it should only contain those designed with identity in mind, such as an username, password, email, and others depending on the design of the system. These depend on the way the project overall is meant to be used, so it will differ from project to project. The ones listed here are used for **this** project in mind.
  - **Attributes**: id, username, email, password (hashed), role (USER / ADMIN)
- Database
  - Stores important data from the project, such as entity instances, and can be managed through the other services.
  - For a microservices project, each service will hold their own database, whether its PostgreSQL, MySQL, or other, depending on the project's goal; and each database is completely independent from the others, only being able to communicate with each other through their respective services.
  - You can also host a single database engine that hosts multiple databases for each microservice, such as what this project does with PostgreSQL.
  - **Attributes** vary from table to table (where each entity's data is stored), and depend on the corresponding service.
