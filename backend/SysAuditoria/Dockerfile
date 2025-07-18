FROM eclipse-temurin:21.0.7_6-jdk

WORKDIR /root

COPY ./pom.xml /root
COPY ./mvnw /root
COPY ./.mvn /root/.mvn

RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

COPY ./src /root/src

RUN ./mvnw clean install -DskipTests

ENTRYPOINT ["java", "-jar", "/root/target/demo-0.0.1-SNAPSHOT.jar"]
