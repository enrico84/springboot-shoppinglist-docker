# syntax=docker/dockerfile:experimental

FROM openjdk:15-jdk-slim as bulid

WORKDIR application

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# uso di maven wrapper per chiamare il processo di maven build dall'interno del nostro Dockerfile.
#COPY mvnw .
#COPY .mvn .mvn
#COPY pom.xml .
#COPY src src
#RUN ./mvnw install -DskipTests

# Processo di caching utilizzando la cache di compilazione Docker, cos' da evitare la creazione di un nuovo container ad ogni build
#RUN --mount=type=cache,target=/root/.m2 ./mvnw install -DskipTests

#RUN cp /application/target/*.jar app.jar
RUN java -Djarmode=layertools -jar app.jar extract

# Aggiunta ed utilizzo di un altro utente e un gruppo (di sistema) docker che viene impostato come utente corrente (invece del valore predefinito, root):
RUN addgroup demogroup && adduser  --ingroup demogroup --disabled-password demo
USER demo

FROM openjdk:15-jdk-slim
WORKDIR application
COPY --from=bulid application/dependencies/ ./
COPY --from=bulid application/spring-boot-loader/ ./
COPY --from=bulid application/snapshot-dependencies/ ./
COPY --from=bulid application/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]