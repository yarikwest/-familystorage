# Zadanie ewaluacyjne na młodszego programistę JAVA/Angular


## Technologies

* [Spring Boot](http://projects.spring.io/spring-boot/)
* [Spring MVC REST](http://spring.io/guides/gs/rest-service/)
* [Spring Data JPA](http://projects.spring.io/spring-data-jpa/)
* [Angular](https://angular.io/)
* [MySQL](https://www.mysql.com/)
* [Maven](http://maven.apache.org/)
* [Docker](https://www.docker.com/)


## Deploy

```
# Build the project and images
mvn clean package

# Pull docker images
docker pull mysql:5 
docker pull yarikwest/familystorage-server
docker pull yarikwest/familystorage-client

# run the containers
docker run -d --name db -p 33060:3306 --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_DATABASE=familyDB" mysql:5
docker run --name server --network host yarikwest/familystorage-server
docker run -d --name client -p 4200:4200 yarikwest/familystorage-client

```
