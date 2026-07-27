# This file documents, in a short form, what attributes will be used for each service.
### It will only apply for the scope of this project.
### If there's a discrepancy with other documents, then "Services - Functionality.md" will take priority.

---

## Infrastructure

- **Config Server**, **Eureka Server** and **Gateway Server** do not have attributes.

## Services

- **Profile**: id, userId, displayName, avatarURL, biography
- **Posts**: id, posterId, message

## External

- **Keycloak**: id, username, email, password, role (USER, ADMIN)
- **Database** depends for each service.
