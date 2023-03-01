# Spring Boot shoppinglist-microservice

### Compile with Dockerfile

- Example take from https://codingfullstack.com/java/spring-boot/docker-spring-boot-guide/

- Compilation: `docker build -t shoppinglist-microservice .`
- Compilation also using this: `DOCKER_BUILDKIT=1 docker build -t shoppinglist-microservice .`                              
- Verify the history of compilation: `docker history shoppinglist-microservice`


- Start with Default profile: `docker --rm run -p 3024:3024 --name shoppinglist-microservice -t shoppinglist-microservice`
- Start with Prod profile: `docker run -e "SPRING_PROFILES_ACTIVE=prod" -p 3024:3024 --name shoppinglist-microservice -t shoppinglist-microservice`
- Check on the browser to http://localhost:3024/shopping-list/ and http://localhost:3024/shopping-list/message

### Add Redis to App
- Example take from https://codingfullstack.com/java/spring-boot/spring-boot-redis-cluster/
 
- Pull official Redis image: `docker pull redis`
- Start redis: `docker run --rm -p 4025:6379 -d --name redis-1 redis redis-server`
- Create a Docker Network for to able to speak redis image with springboot image: `docker network create shoppinglist-microservice-network`
- Connect the images to network: `docker network connect shoppinglist-microservice-network redis-1`
- Look ipAddres of redis instance: `docker inspect shoppinglist-microservice-network redis-1`
- We can see the `redis-1` Redis Container ipAddress, and with that values we can update `application.yml` file
- Build the our image for app one more time and connect to network we created: 
  `DOCKER_BUILDKIT=1 docker build -t shoppinglist-microservice .`
- We can connect to a network by passing `--net` when running our docker image
  `docker run --rm --net shoppinglist-microservice-network -p 3024:4324 --name shoppinglist-microservice shoppinglist-microservice`
- We should see the todo list items at http://localhost:3024/shopping-list/                                                                 


