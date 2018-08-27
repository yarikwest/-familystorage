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
<<<<<<< HEAD

=======
>>>>>>> f319a5aef144e870dbc2949a8ea60d21859de239

## Deploy

```
# Build the project and images
mvn clean package

# Pull docker images
docker pull mysql:5 
docker pull yarikwest/familystorage-server
docker pull yarikwest/familystorage-client

# run the containers
<<<<<<< HEAD
docker run -d --name db -p 33060:3306 --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_DATABASE=familyDB" mysql:5
docker run --name server --network host yarikwest/familystorage-server
docker run -d --name client -p 4200:4200 yarikwest/familystorage-client
=======
docker run --name db --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_DATABASE=familyDB" mysql:5
docker run --name server --link db:db yarikwest/familystorage-server
docker run --name client --link server:server -p 4200:4200 yarikwest/familystorage-client
>>>>>>> f319a5aef144e870dbc2949a8ea60d21859de239

# or just use docker-compose running
docker-compose up

```
