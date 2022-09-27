# Read Me First
The following was discovered as part of building this project:

* The JVM level was changed from '11' to '17', review the [JDK Version Range](https://github.com/spring-projects/spring-framework/wiki/Spring-Framework-Versions#jdk-version-range) on the wiki for more details.
* The original package name 'com.office.users-app' is invalid and this project uses 'com.office.usersapp' instead.

# Getting Started

## Run Application
mvn clean spring-boot:run

## REST requests

#### Create Employee
curl --location --request POST 'http://localhost:8080/user-management/v1/employees' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Andrzej",
    "surname": "Kubas",
    "grade": 5,
    "salary": 200
}'

#### Get Employee
curl --location --request GET 'http://localhost:8080/user-management/v1/employees/1'

#### Get All Employees
curl --location --request GET 'http://localhost:8080/user-management/v1/employees'

#### Filter Employees
curl --location --request GET 'http://localhost:8080/user-management/v1/employees?surname=Kubas&grade=5'

#### Delete Employee
curl --location --request DELETE 'http://localhost:8080/user-management/v1/employees/1'


#### Update Employee
curl --location --request PUT 'http://localhost:8080/user-management/v1/employees' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 1,
    "name": "Adam",
    "surname": "Kubas",
    "grde": 6,
    "salaty": 201
}'

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.0-M5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.0-M5/maven-plugin/reference/html/#build-image)

