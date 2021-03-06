# Project name

Jobs for juniors

# Description

Web application that allows juniors and employers to find each other. For employers, it provides a convenient interface for quickly filling vacancies. Applicants can find a job, an internship they like, or become a volunteer.

## Dependencies

* Spring Web
* Java Servlet API
* Spring Security
* Spring ORM
* Hibernate Core
* MySQL Connector / H2
* Tomcat DBCP
* Hibernate Validator Engine
* Thymeleaf
* SLF4j + log4j
* JUnit 5
* String Test
* Lombok

## Features

* User and employer registration, authentication and authorization
* Create resume, internship, vacancy
* View open source project
* View resume
* Delete resume
* Edit resume

# Installation

## Requirements

* JDK 11
* Maven
* MySQL 5+
* Apache Tomcat 9

## Specific steps 

Clone the repository.

```bash
git clone https://github.com/SergeyAnshin/jobs-juniors.git
```

Download Apache Tomcat from site and set up application server.

Create a database and set up datasourse in datasourse.properties.

```bash
datasource.url=jdbc:mysql://<host:port>/<database-name>
datasource.username=<username>
datasource.password=<password>
```

Change the path to the log file in log4j.properties.

```bash
log4j.appender.FILE.File=<path-to-log-file>
```

# Project status

Active