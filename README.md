# Zadanie ewaluacyjne na młodszego programistę JAVA/Angular


## Technologies

* [Spring Boot](http://projects.spring.io/spring-boot/)
* [Spring MVC REST](http://spring.io/guides/gs/rest-service/)
* [Spring Data JPA](http://projects.spring.io/spring-data-jpa/)
* [Angular](https://angular.io/)
* [MySQL](https://www.mysql.com/)
* [Maven](http://maven.apache.org/)
* [Docker](https://www.docker.com/)
* [Docker Compose](https://docs.docker.com/compose/)
* ...

## Deploy

```
# Build the project and images
mvn clean package

# Pull docker images
docker pull mysql:5 
docker pull yarikwest/familystorage-server
docker pull yarikwest/familystorage-client

# run the containers
docker run --name db -e MYSQL_ROOT_PASSWORD=root mysql:5
docker run --name server --link db:db yarikwest/familystorage-server
docker run --name client --link server:server -p 4200:4200 yarikwest/familystorage-client

# or just use docker-compose running
docker-compose up

```