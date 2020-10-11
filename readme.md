# java-challenge

A simple web API project based on Spring Boot.

## How to use this spring-boot project

- Install packages with `mvn package`
- Run `mvn spring-boot:run` for starting the application (or use your IDE)

Application (with the embedded H2 database) is ready to be used ! You can access
the url below for testing it :

- Swagger UI : http://localhost:8080/swagger-ui.html
- H2 UI : http://localhost:8080/h2-console

> Don't forget to set the `JDBC URL` value as `jdbc:h2:mem:testdb` for H2 UI.

## Instructions

- download the zip file of this project
- create a repository in your own github named 'java-challenge'
- clone your repository in a folder on your machine
- extract the zip file in this folder
- commit and push

- Enhance the code in any ways you can see, you are free! Some possibilities:
  - Add tests
  - Change syntax
  - Protect controller end points
  - Add caching logic for database calls
  - Improve doc and comments
  - Fix any bug you might find
- Edit readme.md and add any comments. It can be about what you did, what you
  would have done if you had more time, etc.
- Send us the link of your repository.

## Restrictions
- use java 8

## What we will look for
- Readability of your code
- Documentation
- Comments in your code
- Appropriate usage of spring boot
- Appropriate usage of packages
- Is the application running as expected
- No performance issues

## Changes has been made
- Added caching to speed up employee data query

## Pending changes

Due to time constraint, some changes were not completed:

- In the codebase:
  - The employee record checking logic in the controller (in update and delete
    API) should be moved to the service class. The controller should not contain
    business logic.
  - Add authentication in front of the APIs.
    - As simple as HTTP Basic Authentication is good enough for small
      applications. The credentials are not encrypted by HTTP Basic
      Authentication but a reverse proxy (e.g. HAProxy) can be put in front of
      the application to encrypt all traffic between the client and the
      application.
    - The username can be the employee name. A new field can be added to the
      database to store the hashed password (e.g. hashed by PBKDF2).
  - Add automated testing to test the controller, service, and repository
    classes.
- In the Swagger UI:
  - For the update employee API, the `id` field in the employee object is not
    necessary as the employee ID cannot be updated.
